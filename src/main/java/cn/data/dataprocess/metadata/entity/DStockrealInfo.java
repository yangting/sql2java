package cn.data.dataprocess.metadata.entity;
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
private Double currentAmount;
private Double uncomeBuyAmount;
private Double uncomeSellAmount;
private Double frozenAmount;
private Double unfrozenAmount;
private Double correctAmount;
private Double enableAmount;
private Double realBuyAmount;
private Double realBuyBalance;
private Double realSellAmount;
private Double realSellBalance;
private Double entrustSellAmount;
private Double sumBuyAmount;
private Double sumBuyBalance;
private Double sumSellAmount;
private Double sumSellBalance;
private Double costPrice;
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

public void setCurrentAmount(Double v){
	this.currentAmount=v;
}

public Double getCurrentAmount(){
	return this.currentAmount;
}

public void setUncomeBuyAmount(Double v){
	this.uncomeBuyAmount=v;
}

public Double getUncomeBuyAmount(){
	return this.uncomeBuyAmount;
}

public void setUncomeSellAmount(Double v){
	this.uncomeSellAmount=v;
}

public Double getUncomeSellAmount(){
	return this.uncomeSellAmount;
}

public void setFrozenAmount(Double v){
	this.frozenAmount=v;
}

public Double getFrozenAmount(){
	return this.frozenAmount;
}

public void setUnfrozenAmount(Double v){
	this.unfrozenAmount=v;
}

public Double getUnfrozenAmount(){
	return this.unfrozenAmount;
}

public void setCorrectAmount(Double v){
	this.correctAmount=v;
}

public Double getCorrectAmount(){
	return this.correctAmount;
}

public void setEnableAmount(Double v){
	this.enableAmount=v;
}

public Double getEnableAmount(){
	return this.enableAmount;
}

public void setRealBuyAmount(Double v){
	this.realBuyAmount=v;
}

public Double getRealBuyAmount(){
	return this.realBuyAmount;
}

public void setRealBuyBalance(Double v){
	this.realBuyBalance=v;
}

public Double getRealBuyBalance(){
	return this.realBuyBalance;
}

public void setRealSellAmount(Double v){
	this.realSellAmount=v;
}

public Double getRealSellAmount(){
	return this.realSellAmount;
}

public void setRealSellBalance(Double v){
	this.realSellBalance=v;
}

public Double getRealSellBalance(){
	return this.realSellBalance;
}

public void setEntrustSellAmount(Double v){
	this.entrustSellAmount=v;
}

public Double getEntrustSellAmount(){
	return this.entrustSellAmount;
}

public void setSumBuyAmount(Double v){
	this.sumBuyAmount=v;
}

public Double getSumBuyAmount(){
	return this.sumBuyAmount;
}

public void setSumBuyBalance(Double v){
	this.sumBuyBalance=v;
}

public Double getSumBuyBalance(){
	return this.sumBuyBalance;
}

public void setSumSellAmount(Double v){
	this.sumSellAmount=v;
}

public Double getSumSellAmount(){
	return this.sumSellAmount;
}

public void setSumSellBalance(Double v){
	this.sumSellBalance=v;
}

public Double getSumSellBalance(){
	return this.sumSellBalance;
}

public void setCostPrice(Double v){
	this.costPrice=v;
}

public Double getCostPrice(){
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