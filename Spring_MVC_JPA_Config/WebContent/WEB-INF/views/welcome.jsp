<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>

<body>

	<h3>Welcome to Department-Employee Application</h3>

	<a href="/DeptEmp4">back</a>

	<br />
	<br />

	<a href="department">Department</a>

	<br />

	<a href="employee">Employee</a>
	<table>
		<tr>
			<th>Dept Name</th>
			<th>Dept Email</th>
		</tr>
		<c:forEach items="${deptList}" var="dept">
			<tr>
				<td>${dept.getName()}</td>
				<td>${dept.getEmail()}</td>
			</tr>
		</c:forEach>
	</table>
</body>

</html>



