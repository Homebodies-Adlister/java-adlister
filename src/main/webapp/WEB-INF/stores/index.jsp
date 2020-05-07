<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Everything that's open" />
    </jsp:include>
<%--    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/index.css">--%>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container-fluid">
        <h1>Everything that is currently reported open</h1>
        <div class="row" id="places_area">
<%--  restuarants retailers --%>
            <c:forEach var="place" items="${restaurants}">
                <div class="card border-dark mb-3 mx-4" style="width: 18rem;">
                    <h5 class="card-header"><c:out value="${place.title}"/></h5>
                    <div class="card-body text-dark">
                        <p class="card-title"><c:out value="${place.description}"/></p>
                        <p class="card-text">Rating: <c:out value="${place.rating}"/></p>
                        <p class="card-text">Mask: <c:out value="${place.mask}"/></p>
                        <p class="card-text">Gloves: <c:out value="${place.gloves}"/></p>
                        <p class="card-text">Social Distancing: <c:out value="${place.socialDistancing}"/></p>
                        <p class="card-text">Dine-In: <c:out value="${place.dineIn}"/></p>
                        <p class="card-text">Take-Out: <c:out value="${place.takeOut}"/></p>
                    </div>
                </div>
            </c:forEach>

            <c:forEach var="place" items="${retailers}">
                <div class="card border-dark m-4" style="width: 18rem;">
                    <h5 class="card-header"><c:out value="${place.retailTitle}"/></h5>
                    <div class="card-body text-dark">
                        <p class="card-title"><c:out value="${place.retailDescription}"/></p>
                        <p class="card-text">Rating: <c:out value="${place.rating}"/></p>
                        <p class="card-text">Mask: <c:out value="${place.masks}"/></p>
                        <p class="card-text">Gloves: <c:out value="${place.gloves}"/></p>
                        <p class="card-text">Social Distancing: <c:out value="${place.socialDistance}"/></p>
                        <p class="card-text">Dine-In: <c:out value="${place.inStore}"/></p>
                        <p class="card-text">Take-Out: <c:out value="${place.curbSide}"/></p>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
    <jsp:include page="/WEB-INF/partials/bootstrap-scripts.jsp" />
</body>
</html>
