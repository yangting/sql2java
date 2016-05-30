package cn.data.dataprocess.metadata.entity;
import java.io.Serializable;

/**
* 本段代码由sql2java自动生成.
* https://github.com/yangting/sql2java
* @author Yate
*/
public class PuerBaseStatus implements Serializable{
private Long id;
private Date processDate;
private Integer currentStatus;
private Date complateDate;
private Integer dCustomerInfo;
public void setId(Long v){
	this.id=v;
}

public Long getId(){
	return this.id;
}

public void setProcessDate(Date v){
	this.processDate=v;
}

public Date getProcessDate(){
	return this.processDate;
}

public void setCurrentStatus(Integer v){
	this.currentStatus=v;
}

public Integer getCurrentStatus(){
	return this.currentStatus;
}

public void setComplateDate(Date v){
	this.complateDate=v;
}

public Date getComplateDate(){
	return this.complateDate;
}

public void setDCustomerInfo(Integer v){
	this.dCustomerInfo=v;
}

public Integer getDCustomerInfo(){
	return this.dCustomerInfo;
}

}