package com.calsoft.emicalculator.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Finance {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	@Column(name="LOAN_AMOUNT")
    private Double loanamount;

	@Column(name="RATE_OF_INTEREST")
    private Double rateofinterest;
	
	@Column(name="LOAN_TENURE")
    private Double loantenure;
	
	@Column(name="USER_NAME")
    private String username;
	
	@Column(name="PRINCIPAL_AMOUNT")
    private Double principalamount;
	
	@Column(name="TOTAL_INTEREST")
    private Double totalinterest;
	
	@Column(name="TOTAL_AMOUNT")
    private Double totalamount;

	public Finance() {
	
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getLoanamount() {
		return loanamount;
	}

	public void setLoanamount(Double loanamount) {
		this.loanamount = loanamount;
	}

	public Double getRateofinterest() {
		return rateofinterest;
	}

	public void setRateofinterest(Double rateofinterest) {
		this.rateofinterest = rateofinterest;
	}

	public Double getLoantenure() {
		return loantenure;
	}

	public void setLoantenure(Double loantenure) {
		this.loantenure = loantenure;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Double getPrincipalamount() {
		return principalamount;
	}

	public void setPrincipalamount(Double principalamount) {
		this.principalamount = principalamount;
	}

	public Double getTotalinterest() {
		return totalinterest;
	}

	public void setTotalinterest(Double totalinterest) {
		this.totalinterest = totalinterest;
	}

	public Double getTotalamount() {
		return totalamount;
	}

	public void setTotalamount(Double totalamount) {
		this.totalamount = totalamount;
	}

	
	
	
}
