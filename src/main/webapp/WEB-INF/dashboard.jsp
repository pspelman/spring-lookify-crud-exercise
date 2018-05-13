<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Lookify Dashboard</title>
</head>
<body>
    <div class="container">
        <div class="top_nav">
            Top nav<br/>
            ${top_nav_message}

            <a href="/songs/new">
                New
            </a>
            || <a href="/songs/topTen">top 10 songs</a>
        </div>
    <br/>
        <div class="songlist">
            <h3>Here's a table of the songs</h3>
            <table>
                <tr>
                    <td>TITLE</td>
                    <td>RATING</td>
                    <td>ACTION (delete)</td>
                </tr>
            </table>
        </div>



    </div>

</body>
</html>

