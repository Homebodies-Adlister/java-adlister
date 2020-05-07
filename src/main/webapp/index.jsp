<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Welcome to my site!" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container">
        <h1>Welcome Covid Connections!</h1>
    </div>

    <div>
        <p>
            This webapp was created by student at<br>
            CodeUp so that people can inform others in their<br>
            community about stores and restaurants that are open<br>
            and their current conditions.
        </p>
        <p>Developed By Ted Zamarron, Johnny Delgado, Jackie Muralles, and James Spicer</p>
    </div>

    <div>
        <form></form>
    </div>
</body>
</html>
