<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

Manage department!

<html>
<head>
	<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
	
</head>

<body>
<br/><br/>
<a href = "main" >Back to Main Page</a>
<br/><br/>
<form action="<c:url value="/addDept" />" method="POST">

<label for="name">Name:</label>
<input type="text" name="name" placeholder="Name" required="required"/>

<br/><br/>

<label for="email">Email address:</label>
<input type="email" name="email" placeholder="Enter email"/>

<br/><br/>

<button type="submit">Add</button>

</form>


<script>
function getDeptDetail(deptId){
	$.ajax({
		  type: "GET",
		  dataType: "json",
		  url: "getDeptDetail",
		  data:{"id":deptId},
		  success:function(msg){console.log(msg)},
		  error:function(){
			  alert("get dept detail error");
		  }
		});
}
</script>


<table>
   <tr>
      <th>Dept Name</th>
      <th>Dept Email</th>
      <th>Employee</th>
   </tr>
    
    <c:forEach items="${deptList}" var="dept">
      		<c:if test="${not empty dept.getEmployeeList()}">
      		  <c:forEach items = "${dept.getEmployeeList()}" var = "emp">
		       		<tr onclick="getDeptDetail(${dept.getId()})">
		             <td>${dept.getName()}</td>
		             <td>${dept.getEmail()}</td>
		             <td>${emp.getLastName()} &nbsp ${emp.getFirstName()}</td> 
		            </tr>
      		  </c:forEach>
      		</c:if>
       		
       		<c:if test="${empty dept.getEmployeeList()}">
       				<tr onclick="getDeptDetail(${dept.getId()})">
		             <td>${dept.getName()}</td>
		             <td>${dept.getEmail()}</td>
		             <td> </td>
              	    </tr>
       		</c:if>
    </c:forEach>
    
</table>


</body>

</html>