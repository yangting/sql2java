package cn.data.dataprocess.metadata.entity;
import java.io.Serializable;

/**
* 本段代码由sql2java自动生成.
* https://github.com/yangting/sql2java
* @author Yate
*/
public class DFundInfo implements Serializable{
private Long id;
private String clientId;
private String fundAccount;
private String moneyType;
private String rateKind;
private Integer branchNo;
private Double beginBalance;
private Double currentBalance;
private Double cashBalance;
private Double checkBalance;
private Double frozenBalance;
private Double unfrozenBalance;
private Double correctBalance;
private Double foregiftBalance;
private Double mortgageBalance;
private Double integralBalance;
private Double fineIntegral;
private Double interest;
private Double interestTax;
private Integer integralUpdate;
private String bankNo;
private String squareFlag;
private String checkStr;
private String positionStr;
public void setId(Long v){
	this.id=v;
}

public Long getId(){
	return this.id;
}

public void setClientId(String v){
	this.clientId=v;
}

public String getClientId(){
	return this.clientId;
}

public void setFundAccount(String v){
	this.fundAccount=v;
}

public String getFundAccount(){
	return this.fundAccount;
}

public void setMoneyType(String v){
	this.moneyType=v;
}

public String getMoneyType(){
	return this.moneyType;
}

public void setRateKind(String v){
	this.rateKind=v;
}

public String getRateKind(){
	return this.rateKind;
}

public void setBranchNo(Integer v){
	this.branchNo=v;
}

public Integer getBranchNo(){
	return this.branchNo;
}

public void setBeginBalance(Double v){
	this.beginBalance=v;
}

public Double getBeginBalance(){
	return this.beginBalance;
}

public void setCurrentBalance(Double v){
	this.currentBalance=v;
}

public Double getCurrentBalance(){
	return this.currentBalance;
}

public void setCashBalance(Double v){
	this.cashBalance=v;
}

public Double getCashBalance(){
	return this.cashBalance;
}

public void setCheckBalance(Double v){
	this.checkBalance=v;
}

public Double getCheckBalance(){
	return this.checkBalance;
}

public void setFrozenBalance(Double v){
	this.frozenBalance=v;
}

public Double getFrozenBalance(){
	return this.frozenBalance;
}

public void setUnfrozenBalance(Double v){
	this.unfrozenBalance=v;
}

public Double getUnfrozenBalance(){
	return this.unfrozenBalance;
}

public void setCorrectBalance(Double v){
	this.correctBalance=v;
}

public Double getCorrectBalance(){
	return this.correctBalance;
}

public void setForegiftBalance(Double v){
	this.foregiftBalance=v;
}

public Double getForegiftBalance(){
	return this.foregiftBalance;
}

public void setMortgageBalance(Double v){
	this.mortgageBalance=v;
}

public Double getMortgageBalance(){
	return this.mortgageBalance;
}

public void setIntegralBalance(Double v){
	this.integralBalance=v;
}

public Double getIntegralBalance(){
	return this.integralBalance;
}

public void setFineIntegral(Double v){
	this.fineIntegral=v;
}

public Double getFineIntegral(){
	return this.fineIntegral;
}

public void setInterest(Double v){
	this.interest=v;
}

public Double getInterest(){
	return this.interest;
}

public void setInterestTax(Double v){
	this.interestTax=v;
}

public Double getInterestTax(){
	return this.interestTax;
}

public void setIntegralUpdate(Integer v){
	this.integralUpdate=v;
}

public Integer getIntegralUpdate(){
	return this.integralUpdate;
}

public void setBankNo(String v){
	this.bankNo=v;
}

public String getBankNo(){
	return this.bankNo;
}

public void setSquareFlag(String v){
	this.squareFlag=v;
}

public String getSquareFlag(){
	return this.squareFlag;
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