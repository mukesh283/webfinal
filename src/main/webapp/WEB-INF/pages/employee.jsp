<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Form</title>
<style type="text/css">
.errMsg{
	color: red;
	font-size: 14px;
	font-weight: bold;
}
</style>

</head>
<body>
<form:form action="empSave" method="post" commandName="emp">
	<h2 align="center">Employee Form</h2>
	
	<table>
		<%-- <tr>
			<td>EmployeeId:</td>
			<td>
				<form:input path="empId"/>
			</td>
		</tr> --%>
		<tr>
			<td>FirstName:</td>
			<td>
				<form:input path="firstName"/>
			</td>
			<td>
				<form:errors cssClass="errMsg" path="firstName"></form:errors>
			</td>
		</tr>
		<tr>
			<td>LastName:</td>
			<td>
				<form:input path="lastName"/>
			</td>
			<td>
			</td>
		</tr>
		
		
		<tr>
			<td>Salary:</td>
			<td>
				<form:input path="salary"/>
			</td>
			<td>
			</td>
		</tr>
		
		<tr>
			<td>Date of Birth:</td>
			<td>
				<form:input path="empDob"/>
			</td>
		</tr>
		<tr>
			<td>Date Of Joining:</td>
			<td>
				<form:input path="empDoj"/>
			</td>
			<td>
			</td>
		</tr>
		<tr>
			<td>Departments</td>
			<td>
			<c:if test="${!empty deps }">
				<form:select path="department">
					<c:forEach var="depart" items="${deps}">
						<form:option value="${depart}">${depart}</form:option>
					</c:forEach>
				
				</form:select>
			</c:if>
			</td>
			<td>
			</td>
		</tr>
		
		
		<tr>
			<td>
			</td>
			<td>
				<input type="submit" name="save" value="Save">
			</td>
			<td>
			</td>
		</tr>
	
	</table>
	
</form:form>

<c:if test="${!empty employees }">
	<table>
		<tr>
			<th>EmployeeId</th>
			<th>FirstName</th>
			<th>LastName</th>
			<th>Salary</th>
			<th>Department</th>
			<th>DateOf Birth</th>
			<th>Date of joining</th>
			<th>Edit</th>
			
		</tr>
		
		<c:forEach var="employee" items="${employees}">
		<tr>
			<td>${employee.empId}</td>
			<td>${employee.firstName}</td>
			<td>${employee.lastName}</td>
			<td>${employee.salary}</td>
			<td>${employee.department}</td>
			<td>${employee.empDob}</td>
			<td>${employee.empDoj}</td>
			<td>
				<a href="deleteEmployee/${employee.empId}">Delete</a>
				&nbsp;&nbsp;&nbsp;
				<a href="#">Update</a>
			</td>
			
		</tr>
		</c:forEach>
	</table>

</c:if>



</body>
</html>