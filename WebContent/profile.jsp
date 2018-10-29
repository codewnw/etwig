<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title  -->
    <title>etwig - Fashion Ecommerce Template</title>

    <!-- Favicon  -->
    <link rel="icon" href="${pageContext.request.contextPath}/img/core-img/favicon.ico">

    <!-- Core Style CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/core-style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
<title>User Profile</title>
</head>
<body>
<%@ include file="common/header.jsp" %>

  <!-- ##### Single Product Details Area Start ##### -->
    <section class="single_product_details_area d-flex align-items-center">

        <!-- Single Product Thumb -->
        <div class="single_product_thumb clearfix">
            <div class="product_thumbnail_slides owl-carousel">
                <img src="img/product-img/product-big-1.jpg" alt="">
                <img src="img/product-img/product-big-2.jpg" alt="">
                <img src="img/product-img/product-big-3.jpg" alt="">
            </div>
        </div>

        <!-- Single Product Description -->
        <div class="single_product_desc clearfix">
            <span>Profile</span>
            <a href="cart.html">
                <h2>${requestScope.customer.firstName} &nbsp; ${requestScope.customer.lastName}</h2>
            </a>
            <p class="product-price">${requestScope.customer.mobile},&nbsp; ${requestScope.customer.email}</p>
            <p class="product-desc">
            ${requestScope.customer.street1},&nbsp; ${requestScope.customer.street2}<br />
            ${requestScope.customer.city}<br />
            ${requestScope.customer.state}, &nbsp; ${requestScope.customer.postCode}<br />
            ${requestScope.customer.country}
            </p>

            <!-- Form -->
        
                <div class="cart-fav-box d-flex align-items-center">
                    <!-- Cart -->
                    <a href="${pageContext.request.contextPath}/customers/edit/${requestScope.customer.id}" class="btn etwig-btn">Edit Profile</a>
                    <!-- Favourite -->
                    <div class="product-favourite ml-4">
                        <a href="#" class="favme fa fa-heart"></a>
                    </div>
                </div>
           
        </div>
    </section>
    <!-- ##### Single Product Details Area End ##### -->
</body>
</html>