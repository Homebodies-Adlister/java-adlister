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

<div class="container">
    <h1>Welcome, <c:out value="${sessionScope.user.username}"/>!</h1>
</div>
<br>
<div>
    <h3 class="d-flex justify-content-center">Please choose from the following options:</h3>

    <%--*****************************************ADD A RESTAURANT BUTTON AND MODAL**************************************************************--%>
    <!-- Button trigger modal -->
    <button type="button" class="btn btn-warning" data-toggle="modal" data-target="#myModal">
        Add A Restaurant
    </button>
    <!-- Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="myModalLabel">Add A New Restaurant</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form action="/addRestaurant" method="post">
                        <div class="form-group">
                            <label for="restaurant-title">Restaurant Title</label>
                            <input type="text" name="restaurant-title" class="form-control" id="restaurant-title">
                        </div>

                        <div class="form-group">
                            <label for="restaurant-rating">Please rate the sanitation of the restaurant:</label>
                            <select class="form-control" id="restaurant-rating" name="restaurant-rating">
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
                            </select>
                        </div>

                        <hr>

                        <h2>Which of the following does the restaurant enforce?</h2>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" name="gloves" type="checkbox" id="gloves" value="gloves">
                            <label class="form-check-label" for="gloves">Gloves</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" name="mask" type="checkbox" id="mask" value="mask">
                            <label class="form-check-label" for="mask">Masks</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" name="social-distance" type="checkbox" id="social-distance"
                                   value="social-distance">
                            <label class="form-check-label" for="social-distance">Social Distancing</label>
                        </div>

                        <hr>

                        <h2>This restaurant is currently open for:</h2>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" name="dine-in" type="checkbox" id="dine-in" value="dine-in">
                            <label class="form-check-label" for="dine-in">Dine In</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" name="take-out" type="checkbox" id="take-out"
                                   value="take-out">
                            <label class="form-check-label" for="take-out">Take-out</label>
                        </div>
                        <div class="form-group">
                            <label for="restaurantDescription">Description</label>
                            <textarea class="form-control" name="restaurantDescription" id="restaurantDescription"
                                      rows="3"
                                      placeholder="Please write a small description of your experience at this restaurant."></textarea>
                        </div>

                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-primary">Save changes</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <%--*****************************************ADD A RETAIL STORE BUTTON AND MODAL**************************************************************--%>
    <!-- Button trigger modal -->
    <button type="button" class="btn btn-info" id="retail" data-toggle="modal" data-target="#addRetail">
        Add A Retail Store
    </button>
    <!-- Modal -->
    <div class="modal fade" id="addRetail" tabindex="-1" role="dialog" aria-labelledby="addRetailLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="addRetailLabel">Add A New Store</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form action="/addRetail" method="post">

                        <div class="form-group">
                            <label for="shop-title">Shop Title</label>
                            <input type="text" name="shop-title" class="form-control" id="shop-title">
                        </div>

                        <div class="form-group">
                            <label for="retail-rating">Please rate the sanitation of the store:</label>
                            <select class="form-control" id="retail-rating" name="retail-rating">
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
                            </select>
                        </div>

                        <h2>Which of the following does the store enforce?</h2>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" name="shop-gloves" type="checkbox" id="shop-gloves"
                                   value="shop-gloves">
                            <label class="form-check-label" for="shop-gloves">Gloves</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" name="shop-gloves" type="checkbox" id="shop-mask"
                                   value="shop-mask">
                            <label class="form-check-label" for="shop-mask">Masks</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" name="shop-distance" type="checkbox" id="shop-distance"
                                   value="shop-distance">
                            <label class="form-check-label" for="shop-distance">Social Distancing</label>
                        </div>

                        <h2>This restaurant is currently open for:</h2>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" name="curb-side" type="checkbox" id="curb-side"
                                   value="curb-side">
                            <label class="form-check-label" for="curb-side">Curb-Side Pickup</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" name="in-store" type="checkbox" id="in-store"
                                   value="in-store">
                            <label class="form-check-label" for="in-store">In Store Shopping Available</label>
                        </div>
                        <div class="form-group">
                            <label for="retailDescription">Description</label>
                            <textarea class="form-control" name="retailDescription" id="retailDescription" rows="3"
                                      placeholder="Please write a small description of your experience at this store."></textarea>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary">Save changes</button>
                </div>
            </div>
        </div>
    </div>
    <a type="button" class="btn btn-dark" href="/whatsopen">View All Open Businesses</a>
</div>

<div class="container-fluid">
    <%--        <c:forEach var="place" items="${restaurant}">--%>
    <%--            <div class="card border-dark mb-3 mx-4" style="width: 18rem;">--%>
    <%--                <h5 class="card-header d-flex justify-content-center"><c:out value="${place.title}"/></h5>--%>
    <%--                <div class="card-body text-dark">--%>
    <%--                    <p class="card-title">Description: <c:out value="${place.description}"/></p>--%>
    <%--                    <hr>--%>
    <%--                    <p class="card-text">Rating: <c:out value="${place.rating}"/>/5</p>--%>
    <%--                    <hr>--%>
    <%--                    <p class="card-text">Mask: <c:out value="${place.mask}"/></p>--%>
    <%--                    <hr>--%>
    <%--                    <p class="card-text">Gloves: <c:out value="${place.gloves}"/></p>--%>
    <%--                    <hr>--%>
    <%--                    <p class="card-text">Social Distancing: <c:out value="${place.socialDistancing}"/></p>--%>
    <%--                    <hr>--%>
    <%--                    <p class="card-text">Dine-In: <c:out value="${place.dineIn}"/></p>--%>
    <%--                    <hr>--%>
    <%--                    <p class="card-text">Take-Out: <c:out value="${place.takeOut}"/></p>--%>

    <%--                    <form action="/update-restaurant" method="get">--%>
    <%--                        <input type="hidden" name="id" value="${place.id}">--%>
    <%--                        <button type="submit">Update</button>--%>
    <%--                    </form>--%>
    <%--                </div>--%>
    <%--            </div>--%>
    <%--        </c:forEach>--%>

    <%--        <c:forEach var="place" items="${retail}">--%>
    <%--            <div class="card border-dark m-4" style="width: 18rem;">--%>
    <%--                <h5 class="card-header d-flex justify-content-center"><c:out value="${place.retailTitle}"/></h5>--%>
    <%--                <div class="card-body text-dark">--%>
    <%--                    <p class="card-title">Description: <c:out value="${place.retailDescription}"/></p>--%>
    <%--                    <hr>--%>
    <%--                    <p class="card-text">Rating: <c:out value="${place.rating}"/>/5</p>--%>
    <%--                    <hr>--%>
    <%--                    <p class="card-text">Mask: <c:out value="${place.masks}"/></p>--%>
    <%--                    <hr>--%>
    <%--                    <p class="card-text">Gloves: <c:out value="${place.gloves}"/></p>--%>
    <%--                    <hr>--%>
    <%--                    <p class="card-text">Social Distancing: <c:out value="${place.socialDistance}"/></p>--%>
    <%--                    <hr>--%>
    <%--                    <p class="card-text">Dine-In: <c:out value="${place.inStore}"/></p>--%>
    <%--                    <hr>--%>
    <%--                    <p class="card-text">Take-Out: <c:out value="${place.curbSide}"/></p>--%>
    <%--                </div>--%>
    <%--            </div>--%>
    <%--        </c:forEach>--%>


    <table class="table">
        <thead>
        <tr>
            <th>Name</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${restaurant}" var="place">
            <tr>
                <td>${place.title}</td>
                <td>
                    <form action="/myrestaurants" method="post">
                        <input type="hidden" name="id" value="${place.id}">
                        <input class="btn" type="submit" value="View">
                    </form>
                </td>
            </tr>
        </c:forEach>
        <c:forEach items="${retail}" var="place">
            <tr>
                <td>${place.retailTitle}</td>
                <td>
                    <form action="/mystores" method="post">
                        <input type="hidden" name="id" value="${place.id}">
                        <input class="btn" type="submit" value="View">
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<jsp:include page="/WEB-INF/partials/bootstrap-scripts.jsp"/>
<script>
    $(document).ready(function () {
        $('#restaurant').click(function () {
            $('#myModal').modal();
        });
    });
</script>


</body>
</html>
