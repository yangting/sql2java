#!/usr/bin/env python
# -*- coding: UTF-8 -*-

__author__ = "Yate"
__version__ = "1.0.0"
__maintainer__ = "Yate"

import sys
import os

class Database(object):
    def __init__(self):
        self.tables = []

    def AddTable(self,name):
        t = Table(name)
        self.tables.append(t)

    def GetLastTable(self):
        return self.tables[-1]

class Table:
    def __init__(self,name):
        self.name=name
        self.fields=[]

    def AddField(self,name,t,length,IsPK):
        fd = Field(name,t,length,IsPK)
        self.fields.append(fd)


class Field:
    def __init__(self,name,t,length,IsPK):
        self.name=name
        self.type=t
        self.length=length
        self.IsPK=IsPK

class JavaType:
    def __init__(self,pkg,tn):
        self.pkg = pkg
        self.table_name = tn
        self.clazz = ""
        self.fields = []

    def AddJavaField(self,sql_fn,java_fn,sql_type,java_type):
        fd = JavaFieldType(sql_fn,java_fn,sql_type,java_type)
        self.fields.append(fd)

class JavaFieldType:
    def __init__(self,sql_fn,java_fn,sql_type,java_type):
        self.sql_fn = sql_fn
        self.java_fn = java_fn
        self.sql_type = sql_type
        self.java_type = java_type


def issubstr(s1, s2):
    return s1 in s2

def get_between(str):
    num1 = str.find("`", 0)
    num2 = str.find("`", num1+1)
    if num2 -num1 < 0:
        return str
    res = str[(num1+1):num2]
    return res

def get_field_type(str):
    num1 = str.find("(", 0)
    num2 = str.find(")", num1+1)
    if num2 -num1 <= 0:
        return str
    res = str[:num1]
    return res

def get_field_length(str):
    num1 = str.find("(", 1)
    num2 = str.find(")", num1+1)
    if num2 -num1 <= 0:
        return 0
    res = str[(num1+1):num2]
    return res

def sqltype2javatype(type):
    if type == 'int':
        return "Integer"
    if type == 'tinyint':
        return "Integer"
    if type == 'bigint':
        return "Long"
    if type == 'varchar': 
        return "String"
    if type == 'char': 
        return "String"
    if type == 'datetime': 
        return "Date"
    

def py2java(pkg,Database):
    for ts in db.tables: 
        jt = JavaType(pkg,ts.name)

        javaclass=""
        tmp1 = ts.name.split("_")
        for x1 in tmp1:
            javaclass += x1.capitalize()

        jt.clazz = javaclass
        
        
        for fs in ts.fields:
            sql_fn = fs.name
            sql_type=fs.type
            java_fn ="" 
            java_type=""

            tmp2 = fs.name.split("_")
            for x2 in tmp2:
                if java_fn == "":
                    java_fn += x2
                else:
                    java_fn += x2.capitalize()
            java_type=sqltype2javatype(fs.type)

            jt.AddJavaField(sql_fn,java_fn,sql_type,java_type)

        writeDotJava(jt)
        wirteMyBatis(jt)


def writeDotJava(jt):
    author = """
/**
* 本段代码由sql2java自动生成.
* git clone https://github.com/yangting/sql2java
* @author Yate
*/\n"""

    s = "package "+jt.pkg+".metadata.entity;\n"
    s +="import java.io.Serializable;\n"
    s += author
    s +="public class "+jt.clazz+" implements Serializable{\n"        

    for f in jt.fields:
        s+="private "+f.java_type +" "+f.java_fn+";\n"

    for f in jt.fields:
        s+="public void set"+f.java_fn[0].capitalize()+f.java_fn[1:]+"("+f.java_type+" v){\n\tthis."+f.java_fn+"=v;\n}\n\n"
        s+="public "+f.java_type+" get"+f.java_fn[0].capitalize()+f.java_fn[1:]+"(){\n\treturn this."+f.java_fn+";\n}\n\n";

    s+="}"

    x = jt.pkg.replace(".", "/")
    if not os.path.exists("src/main/java/"+x+"/metadata/entity"):
        os.makedirs("src/main/java/"+x+"/metadata/entity")

    f = open("src/main/java/"+x+"/metadata/entity/"+jt.clazz+".java",'w')
    f.write(s) # python will convert \n to os.linesep
    f.close() # you can omit in most cases as the destructor will call it

def wirteMyBatis(jt):
    s="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
    s+="<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">\n"
    s+="<mapper namespace=\""+jt.pkg+".metadata.dao.mapper."+jt.clazz+"Mapper\">\n\n"

    isId = True
    s+="<resultMap type=\""+jt.pkg+".metadata.entity."+jt.clazz+"\" id=\""+jt.clazz+"Map\">\n"
    for f in jt.fields:
        if isId:
            s+="<id property=\""+f.java_fn+"\" column=\""+f.sql_fn+"\" />\n"
            isId=False
        else:
            s+="<result property=\""+f.java_fn+"\" column=\""+f.sql_fn+"\" />\n"
    s+="</resultMap>\n\n"

    s+="<!-- auto implement code by "+jt.pkg+".metadata.dao.IBaseMapperDao.java -->\n"
    s+="<select id=\"getEntity\" resultMap=\""+jt.clazz+"Map\">\n"
    s+="select * from "+jt.table_name+" where id = #{"+jt.fields[0].java_fn+"}\n"
    s+="</select>\n\n"


    s+="<insert id=\"add\">\n"
    s+="<selectKey resultType=\""+jt.fields[0].java_type+"\" order=\"AFTER\" keyProperty=\"id\">\n"
    s+="SELECT LAST_INSERT_ID() AS id\n"
    s+="</selectKey>\n"
    s+="insert into "+jt.table_name+"("
    for f in jt.fields:
        s+=f.sql_fn+","
    s=s[:-1]+") values("
    for f in jt.fields:
        s+="#{"+f.java_fn+"},"
    s=s[:-1]+")\n"
    s+="</insert>\n\n"

    s+="<insert id=\"batchAdd\">"
    s+="insert into "+jt.table_name+"("
    for f in jt.fields:
        s+=f.sql_fn+","
    s=s[:-1]+") values\n"
    s+="<foreach collection=\"list\" item=\"item\" index=\"index\" separator=\",\">\n"
    s+="("
    for f in jt.fields:
        s+="#{"+f.java_fn+"},"
    s=s[:-1]+")\n"
    s+="</foreach>\n"
    s+="</insert>\n\n"


    s+="<update id=\"update\">\n"
    s+="update "+jt.table_name+ "\n<set>"
    for f in jt.fields:
        s+="<if test=\""+f.java_fn+"!=null\" >\n"
        s+=f.sql_fn+"=#{"+f.sql_fn+"},\n"
        s+="</if>\n"
    s+="</set>"
    s+="where "+jt.fields[0].sql_fn+"=#{"+jt.fields[0].java_fn+"}\n"
    s+="</update>\n\n"

    s+="<delete id=\"remove\">\n"
    s+="delete from "+jt.table_name+ "\n"
    s+="where "+jt.fields[0].sql_fn+"=#{"+jt.fields[0].java_fn+"}\n"
    s+="</delete>\n\n"

    s+="<delete id=\"batchRemove\">\n"
    s+="delete from "+jt.table_name+ " where id in \n"
    s+="<foreach collection=\"list\" item=\"item\" index=\"index\" separator=\",\" open=\"(\" close=\")\">\n"
    s+="#{item."+jt.fields[0].java_fn+"}\n"
    s+="</foreach>\n"
    s+="</delete>\n\n"

    s+="</mapper>"

    if not os.path.exists("src/main/resources/mybatis/mapper"):
        os.makedirs("src/main/resources/mybatis/mapper")

    f = open("src/main/resources/mybatis/mapper/"+jt.clazz+".xml",'w')
    f.write(s) # python will convert \n to os.linesep
    f.close() # you can omit in most cases as the destructor will call it
    



if __name__=='__main__':
    sql_file = sys.argv[1]
    pkg_name = sys.argv[2]
    f = open(sql_file)

    db = Database()

    line = f.readline()
    while line:
        if issubstr("CREATE TABLE", line):
            table_name = get_between(line)
            db.AddTable(table_name)
        elif issubstr("PRIMARY KEY", line):
            line = f.readline()
            continue
        elif issubstr("ENGINE", line):
            line = f.readline()
            continue
        else:
            ds = line.split()
            if len(ds) > 0:
                fname = get_between(ds[0])
                if ds[1]:
                    x = ds[1]
                    ftype = get_field_type(x)
                    flen = get_field_length(x)
                    db.GetLastTable().AddField(fname,ftype,flen,False)
        line = f.readline()
    f.close()

    py2java(pkg_name,db)



