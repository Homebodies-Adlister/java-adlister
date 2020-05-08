<%--
  Created by IntelliJ IDEA.
  User: jamesspicer
  Date: 5/7/20
  Time: 3:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Please update retail"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>
<%--    <c:if test="${param.true_masks == true}">--%>
<%--    </c:if>--%>
<%--    <c:if test="${param.movieCheck == 'no'}">--%>
<%--        Oops! Perhaps you can try watching them!--%>
<%--    </c:if>--%>

<form action="/update-restaurant" method="POST">
    <input type="hidden" name="id" value="${restaurant.id}">
    <div class="form-group">
        <label for="title">Restaurant Title</label>
        <input id="title" name="title" class="form-control" type="text" value="<c:out value="${restaurant.title}"/>">
    </div>
    <div class="form-group">
        <label for="description">Description</label>
        <input id="description" name="description" class="form-control" type="text" value="<c:out value="${restaurant.description}"/>">
    </div>
    <div>
        <label>The restaurant uses masks</label>
        <label for="masks_form_1">True</label>
        <input id="masks_form_1" type="radio" name="masks" value="true" value="<c:out value="${restaurant.title}"/>">
        <label for="masks_form_2">False</label>
        <input id="masks_form_2" type="radio" name="masks" value="false" value="<c:out value="${restaurant.title}"/>">
    </div>
    <div>
        <label>The restaurant uses masks</label>
        <label for="gloves_form_1">True</label>
        <input id="gloves_form_1" type="radio" name="gloves" value="<c:out value="${restaurant.gloves}"/>">
        <label for="masks_form_2">False</label>
        <input id="gloves_form_2" type="radio" name="gloves" value="<c:out value="${restaurant.gloves}"/>">
    </div>
    <div>
        <label>The restaurant practices social distancing</label>
        <label for="sd_form_1">True</label>
        <input id="sd_form_1" type="radio" name="sd" value="<c:out value="${restaurant.socialDistancing}"/>">
        <label for="sd_form_2">False</label>
        <input id="sd_form_2" type="radio" name="sd" value="<c:out value="${restaurant.socialDistancing}"/>">
    </div>
    <div>
        <label>The restaurant has delivery options</label>
        <label for="cs_form_1">True</label>
        <input id="cs_form_1" type="radio" name="cs" value="<c:out value="${restaurant.takeOut}"/>">
        <label for="cs_form_2">False</label>
        <input id="cs_form_2" type="radio" name="cs" value="<c:out value="${restaurant.takeOut}"/>">
    </div>
    <div>
        <label>Dine in is allowed at the restaurant</label>
        <label for="is_form_1">True</label>
        <input id="is_form_1" type="radio" name="di" value="<c:out value="${restaurant.dineIn}"/>">
        <label for="is_form_2">False</label>
        <input id="is_form_2" type="radio" name="di" value="<c:out value="${restaurant.dineIn}"/>">
    </div>
    <div>
        <label for="rating">Overall rating</label>
        <input type="text" id="rating" name="rating">
    </div>
    <input type="submit" class="btn btn-primary btn-block" value="Submit Changes">

</form>
</body>
</html>
