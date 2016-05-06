package com.dyyt.syncdb.metadata.entity;
import java.io.Serializable;
public class DEntrustInfo implements Serializable{
private Long id;
private Date initDate;
private Date currDate;
private Date currTime;
private Long entrustNo;
private Long opBranchNo;
private String operatorNo;
private Integer opEntrustWay;
private String opStation;
private Integer batchNo;
private Integer branchNo;
private String fundAccount;
private String clientId;
private String otcexchType;
private String otcAccount;
private String otcreportAccount;
private String seatNo;
private String propSeatNo;
private String otcCode;
private String otcName;
private String otcType;
private Long entrustAmount;
private Long entrustPrice;
private Integer invPromiseNo;
private Integer otcPromiseNo;
private String otcProp;
private Date reportTime;
private Integer reportNo;
private Integer recordNo;
private Long businessPrice;
private Long businessAmount;
private Long withdrawAmount;
private Long businessBalance;
private Long clearBalance;
private Long prevBalance;
private String reportBs;
private Integer storeUnit;
private Integer reportUnit;
private Integer errorNo;
private String entrustStatus;
private String moneyType;
private Integer clientGroup;
private Integer roomCode;
private String cancelSerialno;
private Integer otcfareKind;
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

public void setEntrustNo(Long v){
	this.entrustNo=v;
}

public Long getEntrustNo(){
	return this.entrustNo;
}

public void setOpBranchNo(Long v){
	this.opBranchNo=v;
}

public Long getOpBranchNo(){
	return this.opBranchNo;
}

public void setOperatorNo(String v){
	this.operatorNo=v;
}

public String getOperatorNo(){
	return this.operatorNo;
}

public void setOpEntrustWay(Integer v){
	this.opEntrustWay=v;
}

public Integer getOpEntrustWay(){
	return this.opEntrustWay;
}

public void setOpStation(String v){
	this.opStation=v;
}

public String getOpStation(){
	return this.opStation;
}

public void setBatchNo(Integer v){
	this.batchNo=v;
}

public Integer getBatchNo(){
	return this.batchNo;
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

public void setOtcAccount(String v){
	this.otcAccount=v;
}

public String getOtcAccount(){
	return this.otcAccount;
}

public void setOtcreportAccount(String v){
	this.otcreportAccount=v;
}

public String getOtcreportAccount(){
	return this.otcreportAccount;
}

public void setSeatNo(String v){
	this.seatNo=v;
}

public String getSeatNo(){
	return this.seatNo;
}

public void setPropSeatNo(String v){
	this.propSeatNo=v;
}

public String getPropSeatNo(){
	return this.propSeatNo;
}

public void setOtcCode(String v){
	this.otcCode=v;
}

public String getOtcCode(){
	return this.otcCode;
}

public void setOtcName(String v){
	this.otcName=v;
}

public String getOtcName(){
	return this.otcName;
}

public void setOtcType(String v){
	this.otcType=v;
}

public String getOtcType(){
	return this.otcType;
}

public void setEntrustAmount(Long v){
	this.entrustAmount=v;
}

public Long getEntrustAmount(){
	return this.entrustAmount;
}

public void setEntrustPrice(Long v){
	this.entrustPrice=v;
}

public Long getEntrustPrice(){
	return this.entrustPrice;
}

public void setInvPromiseNo(Integer v){
	this.invPromiseNo=v;
}

public Integer getInvPromiseNo(){
	return this.invPromiseNo;
}

public void setOtcPromiseNo(Integer v){
	this.otcPromiseNo=v;
}

public Integer getOtcPromiseNo(){
	return this.otcPromiseNo;
}

public void setOtcProp(String v){
	this.otcProp=v;
}

public String getOtcProp(){
	return this.otcProp;
}

public void setReportTime(Date v){
	this.reportTime=v;
}

public Date getReportTime(){
	return this.reportTime;
}

public void setReportNo(Integer v){
	this.reportNo=v;
}

public Integer getReportNo(){
	return this.reportNo;
}

public void setRecordNo(Integer v){
	this.recordNo=v;
}

public Integer getRecordNo(){
	return this.recordNo;
}

public void setBusinessPrice(Long v){
	this.businessPrice=v;
}

public Long getBusinessPrice(){
	return this.businessPrice;
}

public void setBusinessAmount(Long v){
	this.businessAmount=v;
}

public Long getBusinessAmount(){
	return this.businessAmount;
}

public void setWithdrawAmount(Long v){
	this.withdrawAmount=v;
}

public Long getWithdrawAmount(){
	return this.withdrawAmount;
}

public void setBusinessBalance(Long v){
	this.businessBalance=v;
}

public Long getBusinessBalance(){
	return this.businessBalance;
}

public void setClearBalance(Long v){
	this.clearBalance=v;
}

public Long getClearBalance(){
	return this.clearBalance;
}

public void setPrevBalance(Long v){
	this.prevBalance=v;
}

public Long getPrevBalance(){
	return this.prevBalance;
}

public void setReportBs(String v){
	this.reportBs=v;
}

public String getReportBs(){
	return this.reportBs;
}

public void setStoreUnit(Integer v){
	this.storeUnit=v;
}

public Integer getStoreUnit(){
	return this.storeUnit;
}

public void setReportUnit(Integer v){
	this.reportUnit=v;
}

public Integer getReportUnit(){
	return this.reportUnit;
}

public void setErrorNo(Integer v){
	this.errorNo=v;
}

public Integer getErrorNo(){
	return this.errorNo;
}

public void setEntrustStatus(String v){
	this.entrustStatus=v;
}

public String getEntrustStatus(){
	return this.entrustStatus;
}

public void setMoneyType(String v){
	this.moneyType=v;
}

public String getMoneyType(){
	return this.moneyType;
}

public void setClientGroup(Integer v){
	this.clientGroup=v;
}

public Integer getClientGroup(){
	return this.clientGroup;
}

public void setRoomCode(Integer v){
	this.roomCode=v;
}

public Integer getRoomCode(){
	return this.roomCode;
}

public void setCancelSerialno(String v){
	this.cancelSerialno=v;
}

public String getCancelSerialno(){
	return this.cancelSerialno;
}

public void setOtcfareKind(Integer v){
	this.otcfareKind=v;
}

public Integer getOtcfareKind(){
	return this.otcfareKind;
}

public void setPositionStr(String v){
	this.positionStr=v;
}

public String getPositionStr(){
	return this.positionStr;
}

}