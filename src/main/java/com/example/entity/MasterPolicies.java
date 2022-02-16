package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MasterPolicies {
	
	@Id
	private Integer masterPolicyId;
	private String policyName;
	
	private String policyDetails;

	public MasterPolicies(String policyName, String policyDetails) {
		super();
		this.policyName = policyName;
		this.policyDetails = policyDetails;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public String getPolicyDetails() {
		return policyDetails;
	}

	public void setPolicyDetails(String policyDetails) {
		this.policyDetails = policyDetails;
	}

	@Override
	public String toString() {
		return "MasterPolicies [policyName=" + policyName + ", policyDetails=" + policyDetails + "]";
	}
	
	
}
