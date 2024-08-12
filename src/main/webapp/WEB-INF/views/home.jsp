<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="base.jsp" %>
</head>
<body>
<div class="container mt-3">
    <div class="row">
    <div class="col-md-12">
    <h1 class="text-center md-3">Welcome To Product App</h1>
    
    <table class="table table table-dark table-striped">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Name</th>
      <th scope="col">Description</th>
      <th scope="col">Price</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${products }" var="p">
    <tr>
      <th scope="row">${p.id }</th>
      <td>${p.name }</td>
      <td>${p.description }</td>
      <td class="font-weight-bold">&#8377 ${p.price }</td>
      <td>
      <a href="delete/${p.id }"><i class="fa-solid fa-trash" style="font-size:20px"></i></a>
      <a href="update/${p.id }"><i class="fa-solid fa-pen-to-square" style="font-size:20px"></i></a>
      </td>
    </tr>
     </c:forEach>
   
  </tbody>
</table>
    
    <div class="container text-center">
    <a href="add_product" class=" btn btn-outline-success">Add product</a>
    </div>
    </div>
    </div>
    </div>
    
   <!--  <script>
function calculateGrandTotal() {
    fetch('${pageContext.request.contextPath}/total_price')
        .then(response => response.json())
        .then(total => {
            document.getElementById('grandTotal').value = total.toFixed(2);
        })
        .catch(error => {
            console.error('Error fetching total price:', error);
        });
}
</script> -->
</body>
</html>