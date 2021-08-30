

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class for Servlet: Controler
 *
 */
 public class Controler extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Controler() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer amount=Integer.parseInt(request.getParameter("amount"));
		Double inter=Double.parseDouble(request.getParameter("rate"));
		Integer month=Integer.parseInt(request.getParameter("month"));
		String user=request.getParameter("user");
		Integer id=Integer.parseInt(request.getParameter("id"));
		
		Integer loanAmount = amount;
		double rateOfInterest = inter;
		Integer numberOfMonths = month;
		double temp = 1200;           //100*numberofmonths(12))
		double interestPerMonth = rateOfInterest/temp;
		
		double interestpayable = Math.round(loanAmount*(rateOfInterest/100)*numberOfMonths)/365; 

        double onePlusInterestPerMonth = 1 + interestPerMonth;

        double powerOfOnePlusInterestPerMonth = Math.pow(onePlusInterestPerMonth,numberOfMonths);

        double powerofOnePlusInterestPerMonthMinusOne = powerOfOnePlusInterestPerMonth-1;

        double divides = powerOfOnePlusInterestPerMonth/powerofOnePlusInterestPerMonthMinusOne;

		double principleMultiplyInterestPerMonth = loanAmount * interestPerMonth;

        double totalEmi =  principleMultiplyInterestPerMonth*divides;

        double finalValue = Math.round( totalEmi * 100.0 ) / 100.0;
        
        double totalpayment = loanAmount + interestpayable;

        Bean ra = new Bean();
        ra.setId(id);
        ra.setUsername(user);
        ra.setEnterthenumberofmonths(month);
        ra.setEntertheniterestrate(inter);
        ra.setEntertheamount(amount);
        ra.setTotalpayment(totalpayment);
        ra.setInterestpayable(interestpayable);
        ra.setFinalValue(finalValue);
        
        Register re=new Register();
        boolean status=re.registerDetail(ra);
        
        
	 request.setAttribute("emi_payable", finalValue);
	 request.setAttribute("total_interest", interestpayable);
	 request.setAttribute("totalpay", totalpayment);
	request.getRequestDispatcher("/emi.jsp").forward(request,response);
}
}