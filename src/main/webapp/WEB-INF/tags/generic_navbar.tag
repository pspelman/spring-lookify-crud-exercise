<%@tag description="Overall Page template" pageEncoding="UTF-8" %>
<%@attribute name="top_nav" fragment="true" %>
<%@attribute name="song_header" fragment="true" %>

<HTML>

<body>
<div class="top_nav">
    <jsp:invoke fragment="top_nav" />
    <button name="home" class="btn-inverse" value="Dashboard" onclick="location.href='/dashboard';">Dashboard</button>
    <button name="new" class="btn-inverse" value="Add New" onclick="location.href='/songs/new';">Add New</button>
    <button name="top10" class="btn-inverse" value="Top 10" onclick="location.href='/songs/topTen';">Top 10</button>
    <%--<a href="/songs/new" class="navbar-link">Add new song</a>--%>
    <%--<a href="/songs/topTen" class="navbar-link">top 10 songs</a>--%>
    <form name="artist_search_form" action="/songs/search/artist" method="get" class="form-inline nav_artist_search">
        <input type="text" name="artistNameString">
        <input type="submit" class="btn-inverse" value="search">
        <span class="alert-danger">${artist_search_error}</span>
    </form>
    <%--${dashboard_message}--%>
</div>
</body>
</HTML>