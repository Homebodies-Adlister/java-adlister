<%--
  Created by IntelliJ IDEA.
  User: jamesspicer
  Date: 5/6/20
  Time: 3:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/update">
        <jsp:param name="title" value="Please update retail" />
    </jsp:include>
</head>

    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <body>
        <form action="/update" method="POST">
            <div class="form-group">
                <label for="title">Retail Title</label>
                <input id="title" name="title" class="form-control" type="text">
            </div>
            <div class="form-group">
                <label for="description">Enter Description</label>
                <input id="description" name="description" class="form-control" type="text">
            </div>
            <div class="form-group">
                <label for="rating">1 Star</label>
                <input id="rating" name="rating" class="form-control" type="radio">

                <label for="rating1">2 Star</label>
                <input id="rating1" name="rating1" class="form-control" type="radio">

                <label for="rating2">3 Star</label>
                <input id="rating2" name="rating2" class="form-control" type="radio">

                <label for="rating3">4 Star</label>
                <input id="rating3" name="rating3" class="form-control" type="radio">

                <label for="rating4">5 Star</label>
                <input id="rating4" name="rating4" class="form-control" type="radio">
            </div>
            <div class="form-group">
                <label>Has curb side option</label>

                <label for="true">True</label>
                <input id="true" name="true" class="form-control" type="radio">

                <label for="false">False</label>
                <input id="false" name="false" class="form-control" type="radio">
            </div>

            <div class="form-group">
                <label>Can shop in store</label>

                <label for="true1">True</label>
                <input id="true1" name="true1" class="form-control" type="radio">

                <label for="false1">False</label>
                <input id="false1" name="false1" class="form-control" type="radio">
            </div>

            <div class="form-group">
                <label>Uses masks in store</label>

                <label for="true2">True</label>
                <input id="true2" name="true2" class="form-control" type="radio">

                <label for="false2">False</label>
                <input id="false2" name="false2" class="form-control" type="radio">
            </div>

            <div class="form-group">
                <label>Uses gloves in store</label>

                <label for="true3">True</label>
                <input id="true3" name="true3" class="form-control" type="radio">

                <label for="false3">False</label>
                <input id="false3" name="false3" class="form-control" type="radio">
            </div>

            <div class="form-group">
                <label>Practices social distancing</label>

                <label for="true4">True</label>
                <input id="true4" name="true4" class="form-control" type="radio">

                <label for="false4">False</label>
                <input id="false4" name="false4" class="form-control" type="radio">
            </div>
            <input type="submit" class="btn btn-primary btn-block" value="Submit Changes">

        </form>
    </body>
</html>
