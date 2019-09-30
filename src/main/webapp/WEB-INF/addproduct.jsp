<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ page isELIgnored="false" %>
    
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Spring MVC Form Handling</title>
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

 </head>
<body>

	<h2>Add Product Data</h2>

<div class="container">  
  <form:form method="POST" action="http://localhost:8081/newmvc/save" modelAttribute="productbean">
      <table>
       <tr>
           <td><form:label path="productId">Product ID:</form:label></td>
           <td><form:input path="productId" value="${productbean.productId}" /></td>
       </tr>
       
        <tr>
           <td><form:label path="productName">Product Name:</form:label></td>
           <td><form:input path="productName" value="${productbean.productName}" /></td>
       </tr>
       
        <tr>
           <td><form:label path="productPrice">Product Price:</form:label></td>
           <td><form:input path="productPrice" value="${productbean.productPrice}" /></td>
       </tr>
       
        <tr>
           <td><form:label path="productCategory">Product Category:</form:label></td>
           <td><form:input path="productCategory" value="${productbean.productCategory}" /></td>
       </tr>
       
        <tr>
           <td><form:label path="vendorName">Product Vendor:</form:label></td>
           <td><form:input path="vendorName" value="${productbean.vendorName}"/></td>
       </tr>
	
		<tr>
         <td colspan="2"><input type="submit" value="Submit"/></td>
        </tr>
	
		</table>
	</form:form>
	
	
		
		<hr>
		
		<c:if test="${!empty products}">
  <h2>List Products</h2>
 <table align="left" border="1">
  <tr>
   <th>Product ID</th>
   <th>Product Name</th>
   <th>Product Age</th>
   <th>Product Salary</th>
   <th>Product Address</th>
           <th>Actions on Row</th>
  </tr>

  <c:forEach items="${products}" var="product">
   <tr>
    <td><c:out value="${product.productId}"/></td>
    <td><c:out value="${product.productName}"/></td>
    <td><c:out value="${product.productPrice}"/></td>
    <td><c:out value="${product.productCategory}"/></td>
    <td><c:out value="${product.vendorName}"/></td>
    <td align="center">
	<a href="edit/${product.productId}">Edit</a> | 
	<a href="delete/${product.productId}">Delete</a></td>
   </tr>
  </c:forEach>
 </table>
</c:if>
		
	</div>	
	

</body>

</html>