package cn.data.dataprocess.metadata.entity;
import java.io.Serializable;

/**
* 本段代码由sql2java自动生成.
* https://github.com/yangting/sql2java
* @author Yate
*/
public class DVarietyInfo implements Serializable{
private Long id;
private String otcexchType;
private String otcCode;
private String otcType;
private String otcName;
public void setId(Long v){
	this.id=v;
}

public Long getId(){
	return this.id;
}

public void setOtcexchType(String v){
	this.otcexchType=v;
}

public String getOtcexchType(){
	return this.otcexchType;
}

public void setOtcCode(String v){
	this.otcCode=v;
}

public String getOtcCode(){
	return this.otcCode;
}

public void setOtcType(String v){
	this.otcType=v;
}

public String getOtcType(){
	return this.otcType;
}

public void setOtcName(String v){
	this.otcName=v;
}

public String getOtcName(){
	return this.otcName;
}

}