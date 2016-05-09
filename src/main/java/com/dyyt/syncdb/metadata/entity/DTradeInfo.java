package com.dyyt.syncdb.metadata.entity;
import java.io.Serializable;

/**
* 本段代码由sql2java自动生成.
* https://github.com/yangting/sql2java
* @author Yate
*/
public class DTradeInfo implements Serializable{
private Long id;
private Date initDate;
private Date currDate;
private Date currTime;
private Integer serialNo;
private Integer branchNo;
private String fundAccount;
private String clientId;
private String otcexchType;
private String seatNo;
private String otcAccount;
private String otcCode;
private String otcProp;
private Integer entrustNo;
private Integer reportNo;
private Long businessAmount;
private Long businessPrice;
private Long businessBalance;
private String oppOtcaccount;
private Integer businessNo;
private Integer businessTime;
private String realStatus;
private String cancelSerialno;
private String positionStr;
public void setId(Long v){
	this.id=v;
}

public Long getId(){
	return this.id;
}

public void setInitDate(Date v){
	this.initDate=v;
}

public Date getInitDate(){
	return this.initDate;
}

public void setCurrDate(Date v){
	this.currDate=v;
}

public Date getCurrDate(){
	return this.currDate;
}

public void setCurrTime(Date v){
	this.currTime=v;
}

public Date getCurrTime(){
	return this.currTime;
}

public void setSerialNo(Integer v){
	this.serialNo=v;
}

public Integer getSerialNo(){
	return this.serialNo;
}

public void setBranchNo(Integer v){
	this.branchNo=v;
}

public Integer getBranchNo(){
	return this.branchNo;
}

public void setFundAccount(String v){
	this.fundAccount=v;
}

public String getFundAccount(){
	return this.fundAccount;
}

public void setClientId(String v){
	this.clientId=v;
}

public String getClientId(){
	return this.clientId;
}

public void setOtcexchType(String v){
	this.otcexchType=v;
}

public String getOtcexchType(){
	return this.otcexchType;
}

public void setSeatNo(String v){
	this.seatNo=v;
}

public String getSeatNo(){
	return this.seatNo;
}

public void setOtcAccount(String v){
	this.otcAccount=v;
}

public String getOtcAccount(){
	return this.otcAccount;
}

public void setOtcCode(String v){
	this.otcCode=v;
}

public String getOtcCode(){
	return this.otcCode;
}

public void setOtcProp(String v){
	this.otcProp=v;
}

public String getOtcProp(){
	return this.otcProp;
}

public void setEntrustNo(Integer v){
	this.entrustNo=v;
}

public Integer getEntrustNo(){
	return this.entrustNo;
}

public void setReportNo(Integer v){
	this.reportNo=v;
}

public Integer getReportNo(){
	return this.reportNo;
}

public void setBusinessAmount(Long v){
	this.businessAmount=v;
}

public Long getBusinessAmount(){
	return this.businessAmount;
}

public void setBusinessPrice(Long v){
	this.businessPrice=v;
}

public Long getBusinessPrice(){
	return this.businessPrice;
}

public void setBusinessBalance(Long v){
	this.businessBalance=v;
}

public Long getBusinessBalance(){
	return this.businessBalance;
}

public void setOppOtcaccount(String v){
	this.oppOtcaccount=v;
}

public String getOppOtcaccount(){
	return this.oppOtcaccount;
}

public void setBusinessNo(Integer v){
	this.businessNo=v;
}

public Integer getBusinessNo(){
	return this.businessNo;
}

public void setBusinessTime(Integer v){
	this.businessTime=v;
}

public Integer getBusinessTime(){
	return this.businessTime;
}

public void setRealStatus(String v){
	this.realStatus=v;
}

public String getRealStatus(){
	return this.realStatus;
}

public void setCancelSerialno(String v){
	this.cancelSerialno=v;
}

public String getCancelSerialno(){
	return this.cancelSerialno;
}

public void setPositionStr(String v){
	this.positionStr=v;
}

public String getPositionStr(){
	return this.positionStr;
}

}