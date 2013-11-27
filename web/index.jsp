<%-- 
    Document   : index
    Created on : 26-nov-2013, 21:09:11
    Author     : HugoCésar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List produc5s</title>
    </head>
    <body>
        <h1>List products</h1>

        <table style="border: 2px ">
            <thead>
            <th>Product Id</th>
            <th>Product code</th>
            <th> Purchase cost</th>
            <th>Quantity on hand</th>
            <th>Description</th>
        </thead>
        <c:forEach var="product" items="${products}">
            <tr>
                <td>${product.id}</td>
                <td>${product.code}</td>
                <td>${product.cost}</td>
                <td>${product.quantity}</td>
                <td>${product.description}</td>
            </tr>

        </c:forEach>

        <form method="get" action="controller">
            <input type="hidden" name="action" value="displayProducts">
            <input type="hidden" name="from" value="${from}">
            <input type="hidden" name="to" value="${count}">


            
            
            
            <input type="submit" value="display products">
        </form>


</body>
</html>
