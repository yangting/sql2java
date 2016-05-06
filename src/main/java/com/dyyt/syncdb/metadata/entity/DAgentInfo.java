package com.dyyt.syncdb.metadata.entity;
import java.io.Serializable;

/**
* 本段代码由sql2java自动生成.
* git clone https://github.com/yangting/sql2java
* @author Yate
*/
public class DAgentInfo implements Serializable{
private Integer id;
private Integer branchNo;
private Integer agentNo;
private String agentName;
private String agentType;
private Integer agentLevel;
private String fundAccount;
private Integer upAgentNo;
private String upAgentName;
private String provinceCode;
private String provinceName;
private String developSource;
public void setId(Integer v){
	this.id=v;
}

public Integer getId(){
	return this.id;
}

public void setBranchNo(Integer v){
	this.branchNo=v;
}

public Integer getBranchNo(){
	return this.branchNo;
}

public void setAgentNo(Integer v){
	this.agentNo=v;
}

public Integer getAgentNo(){
	return this.agentNo;
}

public void setAgentName(String v){
	this.agentName=v;
}

public String getAgentName(){
	return this.agentName;
}

public void setAgentType(String v){
	this.agentType=v;
}

public String getAgentType(){
	return this.agentType;
}

public void setAgentLevel(Integer v){
	this.agentLevel=v;
}

public Integer getAgentLevel(){
	return this.agentLevel;
}

public void setFundAccount(String v){
	this.fundAccount=v;
}

public String getFundAccount(){
	return this.fundAccount;
}

public void setUpAgentNo(Integer v){
	this.upAgentNo=v;
}

public Integer getUpAgentNo(){
	return this.upAgentNo;
}

public void setUpAgentName(String v){
	this.upAgentName=v;
}

public String getUpAgentName(){
	return this.upAgentName;
}

public void setProvinceCode(String v){
	this.provinceCode=v;
}

public String getProvinceCode(){
	return this.provinceCode;
}

public void setProvinceName(String v){
	this.provinceName=v;
}

public String getProvinceName(){
	return this.provinceName;
}

public void setDevelopSource(String v){
	this.developSource=v;
}

public String getDevelopSource(){
	return this.developSource;
}

}