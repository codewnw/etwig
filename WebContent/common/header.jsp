<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="true" %>

<!-- ##### Header Area Start ##### -->
<header class="header_area">
	<div
		class="classy-nav-container breakpoint-off d-flex align-items-center justify-content-between">
		<!-- Classy Menu -->
		<nav class="classy-navbar" id="etwigNav">
			<!-- Logo -->
			<a class="nav-brand"
				href="${pageContext.request.contextPath}/index.jsp"><img
				src="${pageContext.request.contextPath}/img/core-img/logo.png"
				alt=""></a>
			<!-- Navbar Toggler -->
			<div class="classy-navbar-toggler">
				<span class="navbarToggler"><span></span><span></span><span></span></span>
			</div>
			<!-- Menu -->
			<div class="classy-menu">
				<!-- close btn -->
				<div class="classycloseIcon">
					<div class="cross-wrap">
						<span class="top"></span><span class="bottom"></span>
					</div>
				</div>
				<!-- Nav Start -->
				<div class="classynav">
					<ul>
						<li><a href="${pageContext.request.contextPath}">Shop</a>
							<div class="megamenu">
								<ul class="single-mega cn-col-4">
									<li class="title">Women's Collection</li>
									<li><a href="${pageContext.request.contextPath}/shop.html">Dresses</a></li>
									<li><a href="${pageContext.request.contextPath}/shop.html">Blouses
											&amp; Shirts</a></li>
									<li><a href="${pageContext.request.contextPath}/shop.html">T-shirts</a></li>
									<li><a href="${pageContext.request.contextPath}/shop.html">Rompers</a></li>
									<li><a href="${pageContext.request.contextPath}/shop.html">Bras
											&amp; Panties</a></li>
								</ul>
								<ul class="single-mega cn-col-4">
									<li class="title">Men's Collection</li>
									<li><a href="${pageContext.request.contextPath}/shop.html">T-Shirts</a></li>
									<li><a href="${pageContext.request.contextPath}/shop.html">Polo</a></li>
									<li><a href="${pageContext.request.contextPath}/shop.html">Shirts</a></li>
									<li><a href="${pageContext.request.contextPath}/shop.html">Jackets</a></li>
									<li><a href="${pageContext.request.contextPath}/shop.html">Trench</a></li>
								</ul>
								<ul class="single-mega cn-col-4">
									<li class="title">Kid's Collection</li>
									<li><a href="${pageContext.request.contextPath}/shop.html">Dresses</a></li>
									<li><a href="${pageContext.request.contextPath}/shop.html">Shirts</a></li>
									<li><a href="${pageContext.request.contextPath}/shop.html">T-shirts</a></li>
									<li><a href="${pageContext.request.contextPath}/shop.html">Jackets</a></li>
									<li><a href="${pageContext.request.contextPath}/shop.html">Trench</a></li>
								</ul>
								<div class="single-mega cn-col-4">
									<img
										src="${pageContext.request.contextPath}/img/bg-img/bg-6.jpg"
										alt="">
								</div>
							</div></li>
						<li><a href="#">Pages</a>
							<ul class="dropdown">
								<li><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
								<li><a href="${pageContext.request.contextPath}/shop.html">Shop</a></li>
								<li><a
									href="${pageContext.request.contextPath}/single-product-details.html">Product
										Details</a></li>
								<li><a href="checkout.html">Checkout</a></li>
								<li><a href="blog.html">Blog</a></li>
								<li><a
									href="${pageContext.request.contextPath}/single-blog.html">Single
										Blog</a></li>
								<li><a
									href="${pageContext.request.contextPath}/regular-page.html">Regular
										Page</a></li>
								<li><a
									href="${pageContext.request.contextPath}/contact.html">Contact</a></li>
							</ul></li>
						<li><a href="${pageContext.request.contextPath}/blog.html">Blog</a></li>
						<li><a href="${pageContext.request.contextPath}/contact.html">Contact</a></li>
					</ul>
				</div>
				<!-- Nav End -->
			</div>
		</nav>

		<!-- Header Meta Data -->
		<div class="header-meta d-flex clearfix justify-content-end">
			<!-- Search Area -->
			<div class="search-area">
				<form action="#" method="post">
					<input type="search" name="search" id="headerSearch"
						placeholder="Type for search">
					<button type="submit">
						<i class="fa fa-search" aria-hidden="true"></i>
					</button>
				</form>
			</div>
			<!-- Favourite Area -->
			<div class="favourite-area">
				<a href="${pageContext.request.contextPath}/#"><img
					src="${pageContext.request.contextPath}/img/core-img/heart.svg"
					alt=""></a>
			</div>
			<c:if test="${sessionScope.userName eq null}">
			<!-- User Login Info -->
			<div class="user-login-info">
				<a
					href="${pageContext.request.contextPath}/login"><img
					src="${pageContext.request.contextPath}/img/core-img/user.svg"
					alt="">&nbsp;Login</a>
			</div>
			<div class="user-login-info">
					<a
					href="${pageContext.request.contextPath}/customer-registration.html"><img
					src="${pageContext.request.contextPath}/img/core-img/user.svg"
					alt="">&nbsp;Sign Up</a>
			</div>
			</c:if>
			
			<!-- Cart Area -->
			<div class="cart-area">
				<a href="${pageContext.request.contextPath}/#" id="etwigCartBtn"><img
					src="${pageContext.request.contextPath}/img/core-img/bag.svg"
					alt=""> <span>3</span></a>
			</div>
		</div>

	</div>
</header>
<!-- ##### Header Area End ##### -->