<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="/whatsopen">Adlister</a>
        </div>
        <ul class="nav navbar-nav navbar-right d-flex">
            <c:choose>
                <c:when test="${user == null}">
                    <li><a href="/login">Login</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="/profile"><i class="fas fa-user"></i></a></li>
                    <li><a href="/profile/edit"><i class="fas fa-users-cog"></i></a></li>
                    <li><a href="/logout">Logout</a></li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
