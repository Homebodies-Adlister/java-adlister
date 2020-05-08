<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container">
        <h1>Welcome, <c:out value="${sessionScope.user.username}" />!</h1>
    </div>
    <br>
    <div>

        <h3 class="d-flex justify-content-center">Please choose from the following options:</h3>
        <a type="button" class="btn btn-primary btn-lg btn-block" href="/AddPlace">Add A Restaurant</a>
        <a type="button" class="btn btn-primary btn-lg btn-block" href="/AddPlace">Add A Retail Store</a>
        <a type="button" class="btn btn-primary btn-lg btn-block" href="/whatsopen">View All Open Businesses</a>
    </div>

    <div class="container-fluid">
        <c:forEach var="place" items="${restaurant}">
            <div class="card border-dark mb-3 mx-4" style="width: 18rem;">
                <h5 class="card-header d-flex justify-content-center"><c:out value="${place.title}"/></h5>
                <div class="card-body text-dark">
                    <p class="card-title">Description: <c:out value="${place.description}"/></p>
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
            </div>
        </c:forEach>

        <c:forEach var="place" items="${retail}">
            <div class="card border-dark m-4" style="width: 18rem;">
                <h5 class="card-header d-flex justify-content-center"><c:out value="${place.retailTitle}"/></h5>
                <div class="card-body text-dark">
                    <p class="card-title">Description: <c:out value="${place.retailDescription}"/></p>
                    <hr>
                    <p class="card-text">Rating: <c:out value="${place.rating}"/>/5</p>
                    <hr>
                    <p class="card-text">Mask: <c:out value="${place.masks}"/></p>
                    <hr>
                    <p class="card-text">Gloves: <c:out value="${place.gloves}"/></p>
                    <hr>
                    <p class="card-text">Social Distancing: <c:out value="${place.socialDistance}"/></p>
                    <hr>
                    <p class="card-text">Dine-In: <c:out value="${place.inStore}"/></p>
                    <hr>
                    <p class="card-text">Take-Out: <c:out value="${place.curbSide}"/></p>
                </div>
            </div>
        </c:forEach>
    </div>

</body>
</html>
