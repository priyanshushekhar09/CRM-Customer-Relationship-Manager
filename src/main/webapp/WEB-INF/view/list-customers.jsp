<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Customers</title>

<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css"/>

</head>
<body>

	<div id="wrapper">
		<div id="header">
				<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
		
			<input type="button" value="Add Customer" onClick="window.location.href='showFormForAddCustomer'; return false;"
					class="add-button"/>
		
			<form:form action="searchCustomer" method="GET">
			
				Search Customer: <input type="text" name="theSearchName" />
				
				<input type="submit" value="Search" class="add-button" />
				
				<input type="button" value="Back to List" onClick="window.location.href='list'; return false;"
						class="add-button"/>
			
			</form:form>
		
			<table>
				
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				
				<tr>
					<c:forEach var="tempCustomer" items="${customers}">
					
						<c:url var="updateLink" value="/customer/showFormForUpdate">
							<c:param name="customerId" value="${tempCustomer.ID}"></c:param>
						</c:url>
						
						<c:url var="deleteLink" value="/customer/deleteCustomer">
							<c:param name="customerId" value="${tempCustomer.ID}"></c:param>
						</c:url>
					
						<tr>
							<td>${tempCustomer.firstName}</td>
							<td>${tempCustomer.lastName}</td>
							<td>${tempCustomer.email}</td>
							<td><a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}" onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
							
							</td>
						</tr>
					</c:forEach>
				</tr>
				
			</table>
		</div>
	</div>

</body>
</html>