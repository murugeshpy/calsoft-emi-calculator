<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Emi calculator</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<script src="bootstrap/js/bootstrap.min.js" type="text/javascript">
	
</script>
</head>
<body>


	<div class="container" style="margin-top: 150px;">
		<!-- Text input-->
		<div class="form-group">
			<label class="col-md-4 control-label" for="textinput">EMI
				Amount Payable per Month:</label>
			<div class="col-md-4">${emi_payable}</div>
			<br>
			<label class="col-md-4 control-label" for="textinput">Total 
			Interest Payable :</label>
			<div class="col-md-4">${total_interest}</div>
			<br>
			<label class="col-md-4 control-label" for="textinput">Total 
			Payment :</label>
			<div class="col-md-4">${totalpay}</div>
		</div>
	</div>
</body>
</html>