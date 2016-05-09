package com.dyyt.syncdb.metadata.entity;
import java.io.Serializable;

/**
* 本段代码由sql2java自动生成.
* https://github.com/yangting/sql2java
* @author Yate
*/
public class DStockrealInfo implements Serializable{
private Long id;
private String otcAccount;
private String otcCode;
private Integer branchNo;
private String otcexchType;
private String fundAccount;
private String clientId;
private String moneyType;
private String otcType;
private Long currentAmount;
private Long uncomeBuyAmount;
private Long uncomeSellAmount;
private Long frozenAmount;
private Long unfrozenAmount;
private Long correctAmount;
private Long enableAmount;
private Long realBuyAmount;
private Long realBuyBalance;
private Long realSellAmount;
private Long realSellBalance;
private Long entrustSellAmount;
private Long sumBuyAmount;
private Long sumBuyBalance;
private Long sumSellAmount;
private Long sumSellBalance;
private Long costPrice;
private String checkStr;
private String positionStr;
public void setId(Long v){
	this.id=v;
}

public Long getId(){
	return this.id;
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

public void setBranchNo(Integer v){
	this.branchNo=v;
}

public Integer getBranchNo(){
	return this.branchNo;
}

public void setOtcexchType(String v){
	this.otcexchType=v;
}

public String getOtcexchType(){
	return this.otcexchType;
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

public void setMoneyType(String v){
	this.moneyType=v;
}

public String getMoneyType(){
	return this.moneyType;
}

public void setOtcType(String v){
	this.otcType=v;
}

public String getOtcType(){
	return this.otcType;
}

public void setCurrentAmount(Long v){
	this.currentAmount=v;
}

public Long getCurrentAmount(){
	return this.currentAmount;
}

public void setUncomeBuyAmount(Long v){
	this.uncomeBuyAmount=v;
}

public Long getUncomeBuyAmount(){
	return this.uncomeBuyAmount;
}

public void setUncomeSellAmount(Long v){
	this.uncomeSellAmount=v;
}

public Long getUncomeSellAmount(){
	return this.uncomeSellAmount;
}

public void setFrozenAmount(Long v){
	this.frozenAmount=v;
}

public Long getFrozenAmount(){
	return this.frozenAmount;
}

public void setUnfrozenAmount(Long v){
	this.unfrozenAmount=v;
}

public Long getUnfrozenAmount(){
	return this.unfrozenAmount;
}

public void setCorrectAmount(Long v){
	this.correctAmount=v;
}

public Long getCorrectAmount(){
	return this.correctAmount;
}

public void setEnableAmount(Long v){
	this.enableAmount=v;
}

public Long getEnableAmount(){
	return this.enableAmount;
}

public void setRealBuyAmount(Long v){
	this.realBuyAmount=v;
}

public Long getRealBuyAmount(){
	return this.realBuyAmount;
}

public void setRealBuyBalance(Long v){
	this.realBuyBalance=v;
}

public Long getRealBuyBalance(){
	return this.realBuyBalance;
}

public void setRealSellAmount(Long v){
	this.realSellAmount=v;
}

public Long getRealSellAmount(){
	return this.realSellAmount;
}

public void setRealSellBalance(Long v){
	this.realSellBalance=v;
}

public Long getRealSellBalance(){
	return this.realSellBalance;
}

public void setEntrustSellAmount(Long v){
	this.entrustSellAmount=v;
}

public Long getEntrustSellAmount(){
	return this.entrustSellAmount;
}

public void setSumBuyAmount(Long v){
	this.sumBuyAmount=v;
}

public Long getSumBuyAmount(){
	return this.sumBuyAmount;
}

public void setSumBuyBalance(Long v){
	this.sumBuyBalance=v;
}

public Long getSumBuyBalance(){
	return this.sumBuyBalance;
}

public void setSumSellAmount(Long v){
	this.sumSellAmount=v;
}

public Long getSumSellAmount(){
	return this.sumSellAmount;
}

public void setSumSellBalance(Long v){
	this.sumSellBalance=v;
}

public Long getSumSellBalance(){
	return this.sumSellBalance;
}

public void setCostPrice(Long v){
	this.costPrice=v;
}

public Long getCostPrice(){
	return this.costPrice;
}

public void setCheckStr(String v){
	this.checkStr=v;
}

public String getCheckStr(){
	return this.checkStr;
}

public void setPositionStr(String v){
	this.positionStr=v;
}

public String getPositionStr(){
	return this.positionStr;
}

}