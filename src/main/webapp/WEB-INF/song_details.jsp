<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/scripts.js"></script>

    <title>Song Details</title>
</head>
<body>


<div class="container">
    <t:generic_navbar>
            <jsp:attribute name="top_nav">
            </jsp:attribute>
    </t:generic_navbar>
    <br/>
    <div class="song_details">

        <h4>Details of the song go here</h4>
        ${song.title}<br/>
        ${song.artist}<br/>
        ${song.rating}<br/>

    </div>






</div>

</body>
</html>

