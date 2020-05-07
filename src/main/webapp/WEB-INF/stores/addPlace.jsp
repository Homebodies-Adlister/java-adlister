<%--
  Created by IntelliJ IDEA.
  User: jacquelinemuralles
  Date: 5/6/20
  Time: 6:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Add A Place" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<form>
    <h1>Create An Open Location</h1>

    <h2>Are you creating a:</h2>
    <button type="button" class="btn btn-light" onclick="showRestaurantForm()">Restaurant</button>
    <h2>Or</h2>
    <button type="button" class="btn btn-dark" onclick="showRetailForm()">Retail Shop</button>

    <div class="form-group">
        <label for="restaurant-title">Restaurant Title</label>
        <input type="text" class="form-control" id="restaurant-title">
    </div>

    <h2>Which of the following does the restaurant enforce?</h2>
    <div class="form-check form-check-inline">
        <input class="form-check-input" type="checkbox" id="gloves" value="gloves">
        <label class="form-check-label" for="gloves">Gloves</label>
    </div>
    <div class="form-check form-check-inline">
        <input class="form-check-input" type="checkbox" id="mask" value="mask">
        <label class="form-check-label" for="mask">Masks</label>
    </div>
    <div class="form-check form-check-inline">
        <input class="form-check-input" type="checkbox" id="social-distance" value="social-distance">
        <label class="form-check-label" for="social-distance">Social Distancing</label>
    </div>

    <h2>This restaurant is currently open for:</h2>
    <div class="form-check form-check-inline">
        <input class="form-check-input" type="checkbox" id="curb-side" value="curb-side">
        <label class="form-check-label" for="curb-side">Curb-Side Pickup</label>
    </div>
    <div class="form-check form-check-inline">
        <input class="form-check-input" type="checkbox" id="dine-in" value="dine-in">
        <label class="form-check-label" for="dine-in">Dine In</label>
    </div>
    <div class="form-check form-check-inline">
    <input class="form-check-input" type="checkbox" id="delivery" value="delivery">
    <label class="form-check-label" for="delivery">Delivery</label>
    </div>

    <div class="form-group">
        <label for="exampleFormControlTextarea1">Description</label>
        <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" placeholder="Please write a small description of your experience at this restaurant."></textarea>
    </div>
</form>
</body>
</html>
