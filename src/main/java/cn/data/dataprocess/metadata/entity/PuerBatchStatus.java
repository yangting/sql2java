package cn.data.dataprocess.metadata.entity;
import java.io.Serializable;

/**
* 本段代码由sql2java自动生成.
* https://github.com/yangting/sql2java
* @author Yate
*/
public class PuerBatchStatus implements Serializable{
private Long id;
private Date dataDate;
private Date processDate;
private Integer currentStatus;
private Integer clearStatus;
private Integer dTradeInfo;
private Integer dEntrustInfo;
public void setId(Long v){
	this.id=v;
}

public Long getId(){
	return this.id;
}

public void setDataDate(Date v){
	this.dataDate=v;
}

public Date getDataDate(){
	return this.dataDate;
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

public void setClearStatus(Integer v){
	this.clearStatus=v;
}

public Integer getClearStatus(){
	return this.clearStatus;
}

public void setDTradeInfo(Integer v){
	this.dTradeInfo=v;
}

public Integer getDTradeInfo(){
	return this.dTradeInfo;
}

public void setDEntrustInfo(Integer v){
	this.dEntrustInfo=v;
}

public Integer getDEntrustInfo(){
	return this.dEntrustInfo;
}

}