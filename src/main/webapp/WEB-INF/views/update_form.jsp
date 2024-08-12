<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="base.jsp" %>
</head>
<body>
    <div class="container mt-3">
    <div class="row">
    <div class="col-md-6 offset-md-3">
        <h2 class="text-center mb-3">Edit the product detail</h2>
        <form action="${pageContext.request.contextPath }/handle-product" method="post">
            <input type="hidden" id="productId" name="id" value="${products.id}"> 
        
            <div class="form-group mb-3">
                <label for="productName">Product Name</label>
                <input type="text" class="form-control" id="productName" name="name" value="${products.name }" placeholder="Enter the product name here">
            </div>
            <div class="form-group mb-3">
                <label for="productDescription">Product Description</label>
                <textarea class="form-control" id="productDescription" name="description" rows="5" placeholder="Enter the product description">${products.description }</textarea>
            </div>
            <div class="form-group mb-3">
                <label for="productPrice">Product Price</label>
                <input type="text" class="form-control" id="productPrice" name="price" value="${products.price }" placeholder="Enter Product Price">
            </div>
           <div class="row">
             <div class="col text-center">
            <button type="button" class="btn btn-warning mx-2" onclick="goHome()">Back</button>
            <button type="submit" class="btn btn-primary text-center mx-2">Update</button>
             </div>
               </div>
        </form>
        </div>
        </div>
    </div>
    
    <script >
    function goHome(){
    	window.location.href= '/product/home';
    }
    </script>


</body>
</html>