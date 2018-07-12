#!/usr/bin/env python
# -*- coding: UTF-8 -*-

__author__ = "Yate"
__version__ = "1.0.0"
__maintainer__ = "Yate"

import sys
import os
import re

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
        self.pks=[]

    def AddField(self,name,t,length,IsPK):
        fd = Field(name,t,length,IsPK)
        self.fields.append(fd)

    def AddPK(self,name):
        self.pks.append(name)
        for f in self.fields:
            if f.name == name:
                f.IsPK = True


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

    def AddJavaField(self,sql_fn,java_fn,sql_type,java_type,IsPK):
        fd = JavaFieldType(sql_fn,java_fn,sql_type,java_type,IsPK)
        self.fields.append(fd)

class JavaFieldType:
    def __init__(self,sql_fn,java_fn,sql_type,java_type,IsPK):
        self.sql_fn = sql_fn
        self.java_fn = java_fn
        self.sql_type = sql_type
        self.java_type = java_type
        self.IsPK = IsPK

def issubstr_exp(exp,s):
    r = re.match(exp,s,re.I)
    if r:
        return True;
    return False;

def issubstr(s1, s2):
    return s1 in s2

def get_between(str):
    num1 = str.find("`", 0)
    num2 = str.find("`", num1+1)
    if num2 -num1 <= 0:
        return str.split(" ")[-1].replace("(","")
    res = str[(num1+1):num2]
    return res

def get_field_name(str):
    num1 = str.find("`", 0)
    num2 = str.find("`", num1+1)
    if num2 -num1 <= 0:
        return str
    res = str[(num1+1):num2]
    return res

def get_field_type(str):
    num1 = str.find("(", 0)
    num2 = str.find(")", num1+1)
    print str,num1,num2
    if num2 == -1 and num1 > 0:
        return str[:num1]
    if num2 -num1 <= 0:
        return str
    res = str[:num1]
    print str,num1,num2,res
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
    if type == 'smallint':
        return "Integer"
    if type == 'bigint':
        return "Long"
    if type == 'varchar': 
        return "String"
    if type == 'char': 
        return "String"
    if type == 'timestamp':
        return "java.util.Date"
    if type == 'datetime': 
        return "java.util.Date"
    if type == 'date':
        return "java.util.Date"
    if type == 'decimal':
        return "java.math.BigDecimal"
    if type == 'double':
        return "java.math.BigDecimal"
    if type == 'float':
        return "java.math.BigDecimal"
    if type == 'text':
        return "String"
    

def py2java(pkg,Database):
    for ts in db.tables: 
        jt = JavaType(pkg,ts.name.replace("\n",""))

        javaclass=""
        tmp1 = ts.name.split("_")
        for x1 in tmp1:
            javaclass += x1.capitalize()

        jt.clazz = javaclass.replace("\n","")
        
        
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

            jt.AddJavaField(sql_fn,java_fn,sql_type,java_type,fs.IsPK)

        writeDotJava(jt)
        wirteMyBatis(jt)
        wirteMapper(jt)
        wirteService(jt)
        wirteBaseService(jt)


def writeDotJava(jt):
    author = """
/**
* 本段代码由sql2java自动生成.
* https://github.com/yangting/sql2java
* @author Yate
*/\n"""

    s = "package "+jt.pkg+".metadata.entity;\n\n"
    s +="import java.io.Serializable;\n\nimport lombok.EqualsAndHashCode;\nimport lombok.ToString;\nimport lombok.experimental.Accessors;"
    s += author
    s += "@ToString\n@EqualsAndHashCode(exclude={\""+jt.fields[0].java_fn+"\"})\n"
    s +="public class "+jt.clazz+" implements Serializable{\n"        

    for f in jt.fields:
        print jt.clazz,f.java_type ,f.java_fn
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

    s+="<resultMap type=\""+jt.pkg+".metadata.entity."+jt.clazz+"\" id=\""+jt.clazz+"Map\">\n"
    for f in jt.fields:
        if f.IsPK:
            s+="<id property=\""+f.java_fn+"\" column=\""+f.sql_fn+"\" />\n"
        else:
            s+="<result property=\""+f.java_fn+"\" column=\""+f.sql_fn+"\" />\n"
    s+="</resultMap>\n\n"

    s+="<!-- auto implement code by "+jt.pkg+".metadata.dao.IBaseMapperDao.java -->\n"
    s+="<select id=\"getEntity\" resultMap=\""+jt.clazz+"Map\">\n"
    s+="select * from "+jt.table_name+" where "
    for f in jt.fields:
        if f.IsPK:
            s+= f.sql_fn + "= #{"+f.java_fn+"} and "
    s = s[0:-4]+"\n"
    s+="</select>\n\n"


    s+="<insert id=\"add\">\n"
    s+="<selectKey resultType=\""+jt.fields[0].java_type+"\" order=\"AFTER\" keyProperty=\"id\">\n"
    s+="SELECT LAST_INSERT_ID() AS id\n"
    s+="</selectKey>\n"
    s+="insert into "+jt.table_name+"("
    for f in jt.fields:
        if not f.IsPK:
            s+=f.sql_fn+","
    s=s[:-1]+") values("
    for f in jt.fields:
        if not f.IsPK:
            s+="#{"+f.java_fn+"},"
    s=s[:-1]+")\n"
    s+="</insert>\n\n"

    s+="<insert id=\"batchAdd\">"
    s+="insert into "+jt.table_name+"("
    for f in jt.fields:
        if not f.IsPK:
            s+=f.sql_fn+","
    s=s[:-1]+") values\n"
    s+="<foreach collection=\"list\" item=\"item\" index=\"index\" separator=\",\">\n"
    s+="("
    for f in jt.fields:
        if not f.IsPK:
            s+="#{item."+f.java_fn+"},"
    s=s[:-1]+")\n"
    s+="</foreach>\n"
    s+="</insert>\n\n"


    s+="<update id=\"update\">\n"
    s+="update "+jt.table_name+ "\n<set>\n"
    for f in jt.fields:
        if not f.IsPK:
            s+="<if test=\""+f.java_fn+"!=null\" >\n"
            s+=f.sql_fn+"=#{"+f.java_fn+"},\n"
            s+="</if>\n"
    s+="</set>\n"
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

    f = open("src/main/resources/mybatis/mapper/"+jt.clazz+"Mapper.xml",'w')
    f.write(s) # python will convert \n to os.linesep
    f.close() # you can omit in most cases as the destructor will call it
    
def wirteMapper(jt):
    author = """
/**
* 本段代码由sql2java自动生成.
* https://github.com/yangting/sql2java
* @author Yate
*/\n"""
    s = "package "+jt.pkg+".metadata.dao.mapper;\n"
    s +="import org.springframework.stereotype.Repository;\n"
    s +="import "+jt.pkg+".metadata.dao.IBaseMapperDao;\n"
    s +="import "+jt.pkg+".metadata.entity."+jt.clazz+";\n\n"
    s += author
    s += "@Repository\n"
    s +="public interface "+jt.clazz+"Mapper extends IBaseMapperDao<"+jt.clazz+", "+jt.fields[0].java_type+">{\n" 
    s +="}\n" 

    x = jt.pkg.replace(".", "/")
    if not os.path.exists("src/main/java/"+x+"/metadata/dao/mapper"):
        os.makedirs("src/main/java/"+x+"/metadata/dao/mapper")

    f = open("src/main/java/"+x+"/metadata/dao/mapper/"+jt.clazz+"Mapper.java",'w')
    f.write(s) # python will convert \n to os.linesep
    f.close() # you can omit in most cases as the destructor will call it

    base="""import java.util.List;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

/**
* 本段代码由sql2java自动生成.
* https://github.com/yangting/sql2java
* @author Yate
*/
public interface IBaseMapperDao<E, PK> {
    /**
     * @description 通过实体进行添加
     * @param e
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void add(final E e);

    /**
     * @description 通过集合进行批量添加
     * @param e
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void batchAdd(final List<E> list);

    /**
     * @description 通过主键进行删除
     * @param e
     */
    Integer remove(@Param(value = "id") final PK e);

    /**
     * @description 通过主键进行批量删除
     * @param e
     */
    void batchRemove(final PK[] ids);

    /**
     * @description 通过实体更新
     * @param e
     */
    Integer update(final E e);

    /**
     * @description 通过主键查询
     * @param id
     * @return
     * @throws Exception
     */
    E getEntity(@Param(value = "id") final PK id);
}"""

    f1 = open("src/main/java/"+x+"/metadata/dao/IBaseMapperDao.java",'w')
    f1.write("package "+jt.pkg+".metadata.dao;\n"+base) # python will convert \n to os.linesep
    f1.close() # you can omit in most cases as the destructor will call it


def wirteService(jt):
    author = """
/**
* 本段代码由sql2java自动生成.
* https://github.com/yangting/sql2java
* @author Yate
*/\n"""
    s = "package "+jt.pkg+".service;\n\n"
    s +="import "+jt.pkg+".metadata.entity."+jt.clazz+";\n\n"
    s += author
    s += "public interface I"+jt.clazz+"Service extends IBaseService<"+jt.clazz+","+jt.fields[0].java_type+">{\n\n"
    s += "}"

    x = jt.pkg.replace(".", "/")
    if not os.path.exists("src/main/java/"+x+"/service"):
        os.makedirs("src/main/java/"+x+"/service")


    f1 = open("src/main/java/"+x+"/service/I"+jt.clazz+"Service.java",'w')
    f1.write(s) # python will convert \n to os.linesep
    f1.close() # you can omit in most cases as the destructor will call it

    s1 ="package "+jt.pkg+".service.impl;\n\n"
    s1+="import org.springframework.stereotype.Service;\n"
    s1+="import javax.annotation.Resource;\n"
    s1+="import "+jt.pkg+".metadata.dao.IBaseMapperDao;\n"
    s1+="import "+jt.pkg+".metadata.dao.mapper."+jt.clazz+"Mapper;\n"
    s1+="import "+jt.pkg+".service.I"+jt.clazz+"Service;\n"
    s1+="import "+jt.pkg+".metadata.entity."+jt.clazz+";\n\n"
    s1+=author
    s1+="@Service\n"
    s1+="public class "+jt.clazz+"ServiceImpl extends BaseServiceImpl<"+jt.clazz+","+jt.fields[0].java_type+"> implements I"+jt.clazz+"Service {\n"
    s1+="@Resource\n"
    s1+="private "+jt.clazz+"Mapper mapper;\n\n"
    s1+="protected IBaseMapperDao<"+jt.clazz+","+jt.fields[0].java_type+"> getMapperDao() {\n"
    s1+="return mapper;\n"    
    s1+="}\n}"

    x1 = jt.pkg.replace(".", "/")
    if not os.path.exists("src/main/java/"+x1+"/service/impl"):
        os.makedirs("src/main/java/"+x1+"/service/impl")

    f1 = open("src/main/java/"+x1+"/service/impl/"+jt.clazz+"ServiceImpl.java",'w')
    f1.write(s1) # python will convert \n to os.linesep
    f1.close() # you can omit in most cases as the destructor will call it


def wirteBaseService(jt):
    author = """
/**
* 本段代码由sql2java自动生成.
* https://github.com/yangting/sql2java
* @author Yate
*/\n"""

    ibase = """

    import java.util.List;

/**
 * 本段代码由sql2java自动生成.
 * https://github.com/yangting/sql2java
 * @author Yate
 */
public interface IBaseService<E, PK> {
    void add(final E e);

    void batchAdd(final List<E> list);

    int remove(final PK id);

    void batchRemove(final PK[] ids);
 
    int update(final E e);
    
    E getEntity(final PK id);

}"""
    
    x = jt.pkg.replace(".", "/")
    if not os.path.exists("src/main/java/"+x+"/service"):
        os.makedirs("src/main/java/"+x+"/service")

    f1 = open("src/main/java/"+x+"/service/IBaseService.java",'w')
    f1.write("package "+jt.pkg+".service;\n"+ibase) # python will convert \n to os.linesep
    f1.close() # you can omit in most cases as the destructor will call it

    xbase ="import "+jt.pkg+".metadata.dao.IBaseMapperDao;\n"
    xbase +="import "+jt.pkg+".service.IBaseService;\n"
    xbase +="import java.util.List;\n\n"
    xbase +=author
    xbase +="public abstract class BaseServiceImpl<E, PK> implements IBaseService<E, PK> {\n"
    xbase +="protected abstract IBaseMapperDao<E, PK> getMapperDao();\n"
    xbase +="public void add(E e) {\n"
    xbase +="this.getMapperDao().add(e);\n"
    xbase +="}\n\n"
    xbase +="public void batchAdd(List<E> list) {\n"
    xbase +="this.getMapperDao().batchAdd(list);\n"
    xbase +="}\n\n"
    xbase +="public int remove(PK id) {\n"
    xbase +="return this.getMapperDao().remove(id);\n"
    xbase +="}\n\n"
    xbase +="public void batchRemove(PK[] ids) {\n"
    xbase +="this.getMapperDao().batchRemove(ids);\n"
    xbase +="}\n\n"
    xbase +="public int update(E e) {\n"
    xbase +="return this.getMapperDao().update(e);\n"
    xbase +="}\n\n"
    xbase +="public E getEntity(PK id) {\n"
    xbase +="return this.getMapperDao().getEntity(id);\n"
    xbase +="}\n\n}"

    f1 = open("src/main/java/"+x+"/service/impl/BaseServiceImpl.java",'w')
    f1.write("package "+jt.pkg+".service.impl;\n\n"+xbase) # python will convert \n to os.linesep
    f1.close() # you can omit in most cases as the destructor will call it



if __name__=='__main__':
    sql_file = sys.argv[1]
    pkg_name = sys.argv[2]
    f = open(sql_file)

    db = Database()

    line = f.readline()
    skip = False
    while line:
        print line
        if skip :
            if issubstr_exp(".*\*/",line):
                skip = False
                line = f.readline()
                continue
            else:
                line = f.readline()
                continue
        if issubstr_exp("^/\*.*",line):
            skip = True
            line = f.readline()
            continue
        if issubstr_exp("^SET.*",line):
            line = f.readline()
            continue
        if issubstr_exp(".*INDEX.*",line):
            line = f.readline()
            continue
        if issubstr_exp("DROP.*",line):
            line = f.readline()
            continue
        if issubstr_exp(".*SET.*FOREIGN_KEY_CHECKS.*",line):
            line = f.readline()
            continue
        if issubstr_exp("^--.*",line):
            line = f.readline()
            continue
        if issubstr_exp("^/\*.*",line):
            line = f.readline()
            continue
        if issubstr_exp(".*drop.*table.*",line):
            line = f.readline()
            continue
        if issubstr_exp(".*create.*table.*",line):
            table_name = get_between(line)
            print table_name
            db.AddTable(table_name)
        elif issubstr_exp(".*primary.*key.*",line):
            r = re.match(".*\((.*)\)",line,re.I)
            if r:
                pkstr = r.group(1)
                pkarr = pkstr.split(',')
                #print pkstr,pkarr
                for x in pkarr:
                    #print x.replace("`","")
                    db.GetLastTable().AddPK(x.replace("`",""))
            line = f.readline()            
            continue
        elif issubstr_exp("\s*key.*",line):
            line = f.readline()
            continue
        elif issubstr_exp(".*engine.*",line):
            line = f.readline()
            continue
        else:
            ds = line.split()
            if len(ds) > 0:
                fname = get_field_name(ds[0])
                if ds[1]:
                    x = ds[1]
                    ftype = get_field_type(x)
                    flen = get_field_length(x)
                    print "test=",db.GetLastTable().name,fname,ftype,flen
                    if fname == None :
                        break;
                    if ftype == None :
                        break;
                    db.GetLastTable().AddField(fname,ftype,flen,False)
        line = f.readline()
    f.close()

    py2java(pkg_name,db)



