<%--
  Created by IntelliJ IDEA.
  User: jamesspicer
  Date: 5/6/20
  Time: 3:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Please update retail" />
    </jsp:include>
</head>
    <body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
<%--    <c:if test="${param.true_masks == true}">--%>

<%--    </c:if>--%>
<%--    <c:if test="${param.movieCheck == 'no'}">--%>
<%--        Oops! Perhaps you can try watching them!--%>
<%--    </c:if>--%>


<%--    //gets the retail id--%>
<%--    String rId = request.getParameter("retailId");--%>
<%--    Long id = Long.parseLong(rId);--%>

<%--    //gets the title of the retail--%>
<%--    String retailTitle = request.getParameter("titles");--%>
<%--    //gets the description of the retail--%>
<%--    String retailDescription = request.getParameter("description");--%>

<%--    //gets weather or not the retail uses masks--%>
<%--    String useMask = (request.getParameter("masks"));--%>
<%--    boolean masks = usesMasks(useMask);--%>

<%--    //gets weather or not the retail uses gloves--%>
<%--    String useGloves = (request.getParameter("gloves"));--%>
<%--    boolean gloves = usesGloves(useGloves);--%>

<%--    //gets weather or not the retail practices social distancing--%>
<%--    String practiceSD = (request.getParameter("sd"));--%>
<%--    boolean socialDistance = implementsSD(practiceSD);--%>

<%--    //gets weather or not the retail has a curbside option--%>
<%--    String hasCurbside = (request.getParameter("cs"));--%>
<%--    boolean curbSide = curbSide(hasCurbside);--%>

<%--    //gets weather or not the retail allows shoppers in store--%>
<%--    String isInStore = (request.getParameter("is"));--%>
<%--    boolean inStore = inStoreShopping(isInStore);--%>

<%--    //gets the rating of the user for the retail--%>
<%--    String userRate = (request.getParameter("rating"));--%>
<%--    int rating = userRating(userRate);--%>

        <form action="/update-retail" method="POST">
<%--            <div class="form-group">--%>
<%--                <label for="title">Retail Title</label>--%>
<%--                <input id="title" name="title" class="form-control" type="text" value="${retail.retailTitle}">--%>
<%--            </div>--%>
<%--            <div class="form-group">--%>
<%--                <label for="description">Retail Description</label>--%>
<%--                <input id="description" name="description" class="form-control" type="text" value="${retail.retailDescription}">--%>
<%--            </div>--%>
<%--            <div>--%>
<%--                <label>The store uses masks</label>--%>
<%--                <label for="masks_form_1">True</label>--%>
<%--                <input id="masks_form_1" type="radio" name="masks" value="${retail.masks}">--%>
<%--                <label for="masks_form_2">False</label>--%>
<%--                <input id="masks_form_2" type="radio" name="masks" value="${retail.masks}">--%>
<%--            </div>--%>
<%--            <div>--%>
<%--                <label>The store uses masks</label>--%>
<%--                <label for="gloves_form_1">True</label>--%>
<%--                <input id="gloves_form_1" type="radio" name="gloves" value="${retail.gloves}">--%>
<%--                <label for="masks_form_2">False</label>--%>
<%--                <input id="gloves_form_2" type="radio" name="gloves" value="${retail.gloves}">--%>
<%--            </div>--%>
<%--            <div>--%>
<%--                <label>The store practices social distancing</label>--%>
<%--                <label for="sd_form_1">True</label>--%>
<%--                <input id="sd_form_1" type="radio" name="sd" value="${retail.socialDistance}">--%>
<%--                <label for="sd_form_2">False</label>--%>
<%--                <input id="sd_form_2" type="radio" name="sd" value="${retail.socialDistance}">--%>
<%--            </div>--%>
<%--            <div>--%>
<%--                <label>The store has curb side options</label>--%>
<%--                <label for="cs_form_1">True</label>--%>
<%--                <input id="cs_form_1" type="radio" name="cs" value="${retail.curbSide}">--%>
<%--                <label for="cs_form_2">False</label>--%>
<%--                <input id="cs_form_2" type="radio" name="cs" value="${retail.curbSide}">--%>
<%--            </div>--%>
<%--            <div>--%>
<%--                <label>in store shopping is allowed</label>--%>
<%--                <label for="is_form_1">True</label>--%>
<%--                <input id="is_form_1" type="radio" name="is" value="${retail.inStore}">--%>
<%--                <label for="is_form_2">False</label>--%>
<%--                <input id="is_form_2" type="radio" name="is" value="${retail.inStore}">--%>
<%--            </div>--%>
<%--            <div>--%>
<%--                <label for="rating">Overall rating</label>--%>
<%--                <input type="text" id="rating" name="rating" ${retail.rating}>--%>
<%--            </div>--%>
<%--            <input type="submit" class="btn btn-primary btn-block" value="Submit Changes">--%>

        </form>
    </body>
</html>

<%--            <div class="form-group">--%>
<%--                <label for="rating">1 Star</label>--%>
<%--                <input id="rating" name="rating" class="form-control" type="radio">--%>

<%--                <label for="rating1">2 Star</label>--%>
<%--                <input id="rating1" name="rating1" class="form-control" type="radio">--%>

<%--                <label for="rating2">3 Star</label>--%>
<%--                <input id="rating2" name="rating2" class="form-control" type="radio">--%>

<%--                <label for="rating3">4 Star</label>--%>
<%--                <input id="rating3" name="rating3" class="form-control" type="radio">--%>

<%--                <label for="rating4">5 Star</label>--%>
<%--                <input id="rating4" name="rating4" class="form-control" type="radio">--%>
<%--            </div>--%>
<%--            <div class="form-group">--%>
<%--                <label>Has curb side option</label>--%>

<%--                <label for="true">True</label>--%>
<%--                <input id="true" name="true" class="form-control" type="radio">--%>

<%--                <label for="false">False</label>--%>
<%--                <input id="false" name="false" class="form-control" type="radio">--%>
<%--            </div>--%>

<%--            <div class="form-group">--%>
<%--                <label>Can shop in store</label>--%>

<%--                <label for="true1">True</label>--%>
<%--                <input id="true1" name="true1" class="form-control" type="radio">--%>

<%--                <label for="false1">False</label>--%>
<%--                <input id="false1" name="false1" class="form-control" type="radio">--%>
<%--            </div>--%>

<%--            <div class="form-group">--%>
<%--                <label>Uses masks in store</label>--%>

<%--                <label for="true2">True</label>--%>
<%--                <input id="true2" name="true2" class="form-control" type="radio">--%>

<%--                <label for="false2">False</label>--%>
<%--                <input id="false2" name="false2" class="form-control" type="radio">--%>
<%--            </div>--%>

<%--            <div class="form-group">--%>
<%--                <label>Uses gloves in store</label>--%>

<%--                <label for="true3">True</label>--%>
<%--                <input id="true3" name="true3" class="form-control" type="radio">--%>

<%--                <label for="false3">False</label>--%>
<%--                <input id="false3" name="false3" class="form-control" type="radio">--%>
<%--            </div>--%>

<%--            <div class="form-group">--%>
<%--                <label>Practices social distancing</label>--%>

<%--                <label for="true4">True</label>--%>
<%--                <input id="true4" name="true4" class="form-control" type="radio">--%>

<%--                <label for="false4">False</label>--%>
<%--                <input id="false4" name="false4" class="form-control" type="radio">--%>
<%--            </div>--%>