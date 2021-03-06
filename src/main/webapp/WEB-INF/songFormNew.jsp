<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <%--<link rel="stylesheet" href="../../resources/static/css/style.css">--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/scripts.js"></script>
    <title>New Song Form</title>
</head>
<body>
<div class="container">
    <t:generic_navbar>
            <jsp:attribute name="top_nav">
            </jsp:attribute>
    </t:generic_navbar>

    <div class="foreground">

    <h3>Submit a new song!</h3>
    <br/>

    <form:form method="POST" action="/songs/new" modelAttribute="song">
        <form:label path="title"> Song title
            <%--<br/>--%>
            <form:errors path="title" cssClass="error"/>
            <br/>
            <form:input path="title"/>
        </form:label>

        <br/>

        <form:label path="artist"> Song artist

            <form:errors path="artist" cssClass="error"/>
            <br/>
            <form:input path="artist"/>
        </form:label>
        <br/>

        <form:label path="rating"> Song rating
            <%--<br/>--%>
            <form:errors path="rating" cssClass="error"/>
            <br/>
            <form:input path="rating"/>
        </form:label>

        <form:hidden path="id"/>
        <input type="submit">

    </form:form>
    </div>
</div>

</body>
</html>