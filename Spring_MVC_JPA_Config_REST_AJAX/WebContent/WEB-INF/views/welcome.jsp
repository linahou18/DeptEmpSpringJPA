<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" >
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">
	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
	<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
	
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
</head>
<body>

	<h3>Welcome to Department-Employee Application</h3>

	<a href="/DeptEmp4">back</a>

	<br />
	<br />

	<a href="department">Department</a>

	<br />

	<a href="employee">Employee</a>
	<table class = "table table-striped">
		<thead>
			<tr>
				<th>Department Name</th>
				<th>Department Email</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${deptList}" var="dept">
				<tr data-toggle="collapse" data-target="#dept_${dept.id}"
					onclick="getDeptDetail(${dept.getId()})" class="accordion-toggle">
					<td>${dept.getName()}</td>
					<td>${dept.getEmail()}</td>
				</tr>
				<tr>
					<td colspan="12" class="hiddenRow">
						<div class="accordian-body collapse" id="dept_${dept.id}">
							<table class="table table-striped">
								<thead>
									<tr>
									    <th>Id</th>
										<th>First Name</th>
										<th>Last Name</th>
										<th>Age</th>
									</tr>
								</thead>
								<tbody id="testBody_${dept.id}">

								</tbody>
							</table>
						</div>

					</td>

				</tr>
			</c:forEach>

		</tbody>

	</table>
<script>
function getDeptDetail(deptId){
	$( document ).ready(function() {
		
	});
	$.ajax({
		  type: "GET",
		  dataType: "json",
		  url: "getDeptDetail",
		  data:{"id":deptId},
		  success:function(msg){
			  var empField = "";
			  $.each(msg.employeeList, function(empid, emp){
				  empField = empField + "<tr>";
				  $.each(emp, function(key, valueField) {
					  empField = empField + '<td>'+ valueField+'</td>';
				  })
				  empField = empField + "</tr>";
			  });
			  $('#testBody_'+ deptId).html(empField);
		  }
		});
}
</script>
</body>

</html>



