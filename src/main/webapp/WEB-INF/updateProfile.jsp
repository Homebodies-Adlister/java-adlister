<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Profile Setting" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container">
        <h1>Welcome, <c:out value="${sessionScope.user.username}" />!</h1>
        <h2>Profile Setting</h2>
        <form action="/profile/edit" method="post">
            <div class="form-group">
                <label for="changeEmail">Change email</label>
                <input id="changeEmail" name="email" class="form-control" type="text" placeholder="Enter New Email">
            </div>
            <div class="form-group">
                <label for="password">Change Password</label>
                <input id="password" name="password" class="form-control" type="password" placeholder="Enter Current Password">
                <input id="newPassword" name="newPassword" class="form-control" type="password" placeholder="Enter New Password">
                <input id="confirm_newPassword" name="confirm_newPassword" class="form-control" type="password" placeholder="Confirm New Password">
            </div>
            <div class="form-group">
                <label for="zip">Zip Code</label>
                <input id="zip" name="zip" class="form-control" type="text" placeholder="Enter New Zip">
            </div>
            <input type="submit" class="btn btn-primary btn-block">
        </form>
    </div>

</body>
</html>
