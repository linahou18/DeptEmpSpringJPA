<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

Manage Employee!

<html>

<body>
<br/><br/>
<a href = "main" >Back to Main Page</a>
<br/><br/>
<form action="<c:url value="/addEmp" />" method="POST">

<label for="firstname">FirstName:</label>
<input type="text" name="firstName" placeholder="First Name" required="required"/>

<br/><br/>

<label for="lastname">LastName:</label>
<input type="text" name="lastName" placeholder="Last Name" required="required"/>

<br/><br/>

<label for="age">Age:</label>
<input name="age" placeholder="Age" />

<br/><br/>

<select id="deptSelect" name="deptSelect">
       <c:forEach var="dept" items="${deptList}">
        <option value = "${dept.getId()}"><c:out value="${dept.getName()}"/></option>
       </c:forEach>
</select>

<br/><br/>

<button type="submit">Add</button>

</form>

<table>
   <tr>
      <th>First Name</th>
      <th>Last Name</th>
      <th>Age</th>
      <th>Department</th>
   </tr>

	<c:forEach items="${employeeList}" var="emp">
        <tr>
            <td>${emp.getFirstName()}</td>
            <td>${emp.getLastName()}
            <td>${emp.getAge()}</td>
            <td>${emp.getDepartment().getName()}</td>
        </tr>
	</c:forEach>

</table>
</body>

</html>