import java.sql.*;


public class Register {
	Connection con=null;
	public boolean establishConnection(){
		boolean status=false;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","babu","babu");
		}catch(Exception e){
			e.printStackTrace();
			System.out.print(e);
		
		}
		return status;
	}
	
	
	public boolean registerDetail(Bean sib){
		boolean status=false;
		try{
			establishConnection();
			Integer id=sib.getId();
			String username=sib.getUsername();
			Integer loan_tenure=sib.getEnterthenumberofmonths();
			Double rate_of_interest=sib.getEntertheniterestrate();
			Integer loan_amount=sib.getEntertheamount();
			Double total_interest=sib.getInterestpayable();
			Double total_amount=sib.getTotalpayment();
			Double interest_permonth=sib.getFinalValue();
			
			Statement st=con.createStatement();
			String query = "insert into finance(loan_amount,rate_of_interest,loan_tenure,user_name,interest_permonth,total_interest,total_amount,id) values('"+loan_amount+"','"+rate_of_interest+"','"+loan_tenure+"','"+username+"','"+interest_permonth+"','"+total_interest+"','"+total_amount+"','"+id+"')";
			System.out.println(query);
			int i = st.executeUpdate(query);
			if(i>0){
				//status=true;
				System.out.println(i);
			}
		}catch(Exception e){
			System.out.println(e);
		}
		return status;
	}
	
}

