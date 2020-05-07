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
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
<%--loop through restaurant list to get contents of restaurant --%>
    <c:forEach var="place" items="${restaurants}">
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="card" style="width: 18rem;">
        <div class="card-body">
            <h5 class="card-title"><c:out value="${place.title}" /></h5>
            <p class="card-title">Description:<c:out value="${place.description}"/></p>
            <p class="card-text">Rating: <c:out value="${place.rating}"/></p>
            <p class="card-text">Mask: <c:out value="${place.mask}"/></p>
            <p class="card-text">Gloves: <c:out value="${place.gloves}"/></p>
            <p class="card-text">Social Distancing: <c:out value="${place.socialDistancing}"/></p>
            <p class="card-text">Dine-In: <c:out value="${place.dineIn}"/></p>
            <p class="card-text">Take-Out: <c:out value="${place.takeOut}"/></p>
        </div>
    </c:forEach>
    </div>
</body>
</html>
