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

    <title>Search result</title>
</head>
<body>


<div class="container">
    <t:generic_navbar>
            <jsp:attribute name="top_nav">
            </jsp:attribute>
    </t:generic_navbar>
    <br/>
    <div class="songlist">
        <h4>Songs by artist: ${selected_artist}</h4>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th scope="col">
                    #
                </th>
                <th scope="col">
                    Title
                </th>
                <th scope="col">
                    Artist
                </th>
                <th scope="col">
                    Rating
                </th>
                <th scope="col">
                    Action
                </th>
            </tr>
            </thead>
            <tbody>
            <%--for loop can go here, or in the tr tag --%>
            <c:forEach var="song" items="${songs}" varStatus="loop" >
                <tr>
                    <th scope="row">
                            ${loop.index+1}
                    </th>
                    <th scope="row">
                            ${song.title}
                        <a href="songs/view/${song.id}">get song: ${song.id}</a>

                    </th>
                    <td>
                            ${song.artist}
                    </td>
                    <td>
                            ${song.rating}
                    </td>
                    <td>
                        <button name="delete" class="table-btn btn-danger" value="Delete" href="/items/delete/item.id">remove</button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>






</div>

</body>
</html>

