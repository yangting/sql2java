# 工具箱

## SQL转换POJO
通过sql建表语句自动生成pojo对象

### 系统需求
<b>Required</b> python 2.7 or python 3.x

### 使用方法
python sql2java.py {sqlfile.path} {java.pkg.name}

1. 参数sqlfile.path是输入Sql建表语句文件的路径
2. 参数java.pkg.name是输入生成java文件后的包名，eg:one.yate.test 所有的Pojo文件会生成到当前目录下的src/main/java/one/yate/test/metadata/entity/目录下面


## 注意事项
没什么特别要注意的本来就打算自己用的^_^b
