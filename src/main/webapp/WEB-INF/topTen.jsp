<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="css/style.css">

    <title>Top10 Songs</title>
</head>
<body>
    <div class="container">
        <div class="top_nav">
            Top nav
    <br/>
            ${top_nav_message}

            <a href="/dashboard" class="left">Dashboard</a>
        </div>
        <br/>
        <div class="top10">
            <h3>Here's the TOP 10 SONGS</h3>
            <h4>[rating] - <a href="/songs/id_goes_here">[trackName]</a> - Artist</h4>
        </div>

    </div>

</body>
</html>

