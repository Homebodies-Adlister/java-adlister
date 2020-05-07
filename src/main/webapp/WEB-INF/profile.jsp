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
    <div>
        <h2>Please choose from the following options:</h2>
        <button type="button" class="btn btn-primary btn-lg btn-block" href="/AddPlace">Add A Restaurant</button>
        <button type="button" class="btn btn-primary btn-lg btn-block" href="/AddPlace">Add A Retail Store</button>
        <button type="button" class="btn btn-primary btn-lg btn-block" href="/whatsopen">View All Open Businesses</button>
    </div>


</body>
</html>
