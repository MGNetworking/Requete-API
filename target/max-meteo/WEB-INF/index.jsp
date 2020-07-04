<%--
  Created by IntelliJ IDEA.
  User: Maxime
  Date: 02/07/2020
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>--%>
<html>
<head>
    <title>home</title>
    <link rel="shortcut icon" type="image/png" href="/image/favicon.ico"/>
</head>
<body>

<h1>Application Meteo</h1>

<form id="formulaire" action="webapp" name="formulaire" method="post">
    <fieldset>My meteo</fieldset>

    <div>
        Entre la ville recherche : <input id="ville" name="ville" value="">
        <button type="submit">Click</button>
    </div>
    <div>
        Longitude : <input id="longitude" name="longitude" type="text" value="${ requestScope.cod.longitude }">
        Latitude : <input id="latitude" name="latitude" type="text" value="${ requestScope.cod.latitude }">
        Météo : <input id="meteo" name="meteo" type="text" value="${ requestScope.cod.descriptionMetoe }">
    </div>

    <input id="longitude-hidden" name="longitude-hidden" type="hidden">
    <input id="latitude-hidden" name="latitude-hidden" type="hidden">
</form>

<script src="<c:url value="/static/js/nominatim.js" />"></script>
</body>

<footer>
    <p>copyright &copy; Site du GEEK Learning 2019 / 2020</p>
</footer>
</html>
