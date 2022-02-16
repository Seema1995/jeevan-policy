package com.example.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.UpdateTimestamp;

import com.example.utility.PolicyValidity;

@Entity
public class UserPolicies {
	
	@Id
	private Integer userPolicyId;
	
	@ManyToOne
	private Users userId;
	
	private String policyName;
	
	private Double amountPaid;
	
	@UpdateTimestamp
	private Timestamp endDate;
	
	@Enumerated(EnumType.STRING)
	private PolicyValidity valid;

	public UserPolicies(String policyName, Double amountPaid, Timestamp endDate, PolicyValidity valid) {
		super();
		this.policyName = policyName;
		this.amountPaid = amountPaid;
		this.endDate = endDate;
		this.valid = valid;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public Double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(Double amountPaid) {
		this.amountPaid = amountPaid;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public PolicyValidity getValid() {
		return valid;
	}

	public void setValid(PolicyValidity valid) {
		this.valid = valid;
	}

	@Override
	public String toString() {
		return "UserPolicies [policyName=" + policyName + ", amountPaid=" + amountPaid + ", endDate=" + endDate
				+ ", valid=" + valid + "]";
	}
	
	
}
