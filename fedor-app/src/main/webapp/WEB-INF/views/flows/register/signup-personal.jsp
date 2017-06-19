<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@include file="../shared/flows-header.jsp" %>
		<!-- Page Content -->
			

			<div class="container">
				
			<div class="row">
			
			<div class="col-md-6 col-md-offset-3">
			
			<div class="panel panel-primary">
			
			<div class="panel-heading">
			
			<h4>SIGN UP - PERSONAL</h4>
			
			</div>
			
			<div class="panel-body">
			<sf:form method="POST" class="form-horizontal" id="registerForm" modelAttribute="user">
			
			<div class="form-group">
			<label class="control-label col-md-4">First Name</label>
			<div class="col-md-8">
			
			<sf:input type="text" path="fName" class="form-control" placeholder ="First Name"/>
			
			
			</div>		
			</div>
			
			<div class="form-group">
			<label class="control-label col-md-4">Last Name</label>
			<div class="col-md-8">
			
			<sf:input type="text" path="lName" class="form-control" placeholder ="Last Name"/>
			
			</div>		
			</div>
			
				<div class="form-group">
			<label class="control-label col-md-4">Email</label>
			<div class="col-md-8">
			
			<sf:input type="text" path="email" class="form-control" placeholder ="name@mail.com"/>
			
			</div>		
			</div>
			
			<div class="form-group">
			<label class="control-label col-md-4">Contact number</label>
			<div class="col-md-8">
			
			<sf:input type="text" path="contactNumber" class="form-control" placeholder ="0679020613" maxlength="10"/>
			
			</div>		
			</div>
			
			
			<div class="form-group">
			<label class="control-label col-md-4">Password</label>
			<div class="col-md-8">
			
			<sf:input type="text" path="pswd" class="form-control" placeholder ="password"/>
			
			</div>		
			</div>
			<div class="form-group">
			
			<div class="col-md--offset col-md-8">
		
				<button type="submit" class="btn btn-primary" name="_eventId_confirm">Sign Up<span class="glyphicon glyphicon-chevron-right"></span></button>
			
			</div>		
			</div>
			
			
			</sf:form>
			
			
			
			
			
			
			</div>
			
			
			
			</div>
			
			
			
			</div>
			
			
			
			
			
			
			
			</div>



			</div>

	
<%@include file="../shared/flows-footer.jsp"%>