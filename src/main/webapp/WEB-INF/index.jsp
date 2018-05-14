<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <title>Lookify Project</title>
</head>
<body>
<div class="home_container">
    <div class="foreground">
        <h1>Welcome to the Lookify thing</h1>
        <br/>
        <a href="/dashboard">Start Looking?</a>
        <br/>
        Or <a href="/songs/new">Add a new song</a>
        <br/>
        <br/>
        <br/>
        <br/>
        Message: ${message}
        <br/>

    </div>


    <br/>
</div>

</body>
</html>