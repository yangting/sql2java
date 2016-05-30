package cn.data.dataprocess.metadata.entity;
import java.io.Serializable;

/**
* 本段代码由sql2java自动生成.
* https://github.com/yangting/sql2java
* @author Yate
*/
public class DAgentInfo implements Serializable{
private Long id;
private Integer branchNo;
private String agentNo;
private String agentName;
private String agentType;
private String agentLevel;
private String fundAccount;
private String upAgentNo;
private String upAgentName;
private String provinceCode;
private String provinceName;
private String remark;
public void setId(Long v){
	this.id=v;
}

public Long getId(){
	return this.id;
}

public void setBranchNo(Integer v){
	this.branchNo=v;
}

public Integer getBranchNo(){
	return this.branchNo;
}

public void setAgentNo(String v){
	this.agentNo=v;
}

public String getAgentNo(){
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

public void setAgentLevel(String v){
	this.agentLevel=v;
}

public String getAgentLevel(){
	return this.agentLevel;
}

public void setFundAccount(String v){
	this.fundAccount=v;
}

public String getFundAccount(){
	return this.fundAccount;
}

public void setUpAgentNo(String v){
	this.upAgentNo=v;
}

public String getUpAgentNo(){
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

public void setRemark(String v){
	this.remark=v;
}

public String getRemark(){
	return this.remark;
}

}