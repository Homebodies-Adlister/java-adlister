<%--
  Created by IntelliJ IDEA.
  User: johnnydelgado
  Date: 5/7/20
  Time: 1:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>
<%--loop through restaurant list to get contents of restaurant --%>
<c:forEach var="place" items="${Restaurants}">
    <div class="card" style="width: 18rem;">
        <div class="card-body">
            <h5 class="card-title d-flex justify-content-center"><c:out value="${place.title}"/></h5>
            <p class="card-title">Description:<c:out value="${place.description}"/></p>
            <hr>
            <p class="card-text">Rating: <c:out value="${place.rating}"/>/5</p>
            <hr>
            <p class="card-text">Mask: <c:out value="${place.mask}"/></p>
            <hr>
            <p class="card-text">Gloves: <c:out value="${place.gloves}"/></p>
            <hr>
            <p class="card-text">Social Distancing: <c:out value="${place.socialDistancing}"/></p>
            <hr>
            <p class="card-text">Dine-In: <c:out value="${place.dineIn}"/></p>
            <hr>
            <p class="card-text">Take-Out: <c:out value="${place.takeOut}"/></p>
        </div>

        <span>
            <form action="/update-restaurant" method="get">
                <input type="hidden" name="id" value="${place.id}">
                <button type="submit">Update</button>
            </form>
        </span>

        <span>
            <form action="#" method="post">
                <input type="hidden" name="id" value="${place.id}">
                <button type="submit">Delete</button>
            </form>
        </span>

        <span>
            <form action="/profile" method="get">
                <button type="submit">Cancel</button>
            </form>
        </span>
    </div>
</c:forEach>
</body>
</html>
