package com.calsoft.emicalculator.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.calsoft.emicalculator.model.Finance;
import com.calsoft.emicalculator.repo.FinanceRepo;

@RestController
public class Emicontroller {
	
	@Autowired
	FinanceRepo financeRepo;

	@GetMapping("/finance")
	public Object index() {
		return financeRepo.findAll();
	}
	
	@PostMapping(path = "/finance", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public boolean createfinance(@RequestParam Map<String, String> body) {
		
		Finance finance = new Finance();
		finance.setLoanamount(Double.valueOf(body.get("amount")));
		finance.setRateofinterest(Double.valueOf(body.get("rate")));
		finance.setLoantenure(Double.valueOf(body.get("month")));
		finance.setUsername(body.get("user").toString());
		
		
		double temp = 12 * 100;
		
		double interestPerMonth = finance.getLoanamount()/temp;
		
		double interestpayable = Math.round(finance.getLoanamount()*(finance.getRateofinterest()/100)*finance.getLoantenure())/365;

        double onePlusInterestPerMonth = 1 + interestPerMonth;

        double powerOfOnePlusInterestPerMonth = Math.pow(onePlusInterestPerMonth,finance.getLoantenure());

        double powerofOnePlusInterestPerMonthMinusOne = powerOfOnePlusInterestPerMonth-1;

        double divides = powerOfOnePlusInterestPerMonth/powerofOnePlusInterestPerMonthMinusOne;

		double principleMultiplyInterestPerMonth = finance.getLoanamount() * interestPerMonth;

        double totalEmi =  principleMultiplyInterestPerMonth*divides;

        double finalValue = Math.round( totalEmi * 100.0 ) / 100.0;
        
        double totalpayment = finance.getLoanamount() + interestpayable;
        
        finance.setTotalinterest(totalpayment);
        finance.setPrincipalamount(finalValue);

		financeRepo.save(finance);
		return true;
	}
	
	@PutMapping(path = "/finance", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public boolean updatefinance(@RequestParam Map<String, String> body) {
		
		Optional<Finance> _finance = financeRepo.findById(Long.parseLong(body.get("id").toString()));
		Finance finance = _finance.get();
		finance.setLoanamount(Double.valueOf(body.get("amount")));
		finance.setRateofinterest(Double.valueOf(body.get("rate")));
		finance.setLoantenure(Double.valueOf(body.get("month")));
		finance.setUsername(body.get("user").toString());

		double temp = 12 * 100;
		
		double interestPerMonth = finance.getLoanamount()/temp;
		
		double interestpayable = Math.round(finance.getLoanamount()*(finance.getRateofinterest()/100)*finance.getLoantenure())/365;

        double onePlusInterestPerMonth = 1 + interestPerMonth;

        double powerOfOnePlusInterestPerMonth = Math.pow(onePlusInterestPerMonth,finance.getLoantenure());

        double powerofOnePlusInterestPerMonthMinusOne = powerOfOnePlusInterestPerMonth-1;

        double divides = powerOfOnePlusInterestPerMonth/powerofOnePlusInterestPerMonthMinusOne;

		double principleMultiplyInterestPerMonth = finance.getLoanamount() * interestPerMonth;

        double totalEmi =  principleMultiplyInterestPerMonth*divides;

        double finalValue = Math.round( totalEmi * 100.0 ) / 100.0;
        
        double totalpayment = finance.getLoanamount() + interestpayable;

        finance.setTotalinterest(totalpayment);
        finance.setPrincipalamount(finalValue);
		
		financeRepo.save(finance);
		return true;
	}
	
	@DeleteMapping(path = "/finance", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public boolean deleteFinance(@RequestParam String id) {
		
		Optional<Finance> finance = financeRepo.findById(Long.parseLong(id));
		
		
		financeRepo.delete(finance.get());
		return true;
	}

}