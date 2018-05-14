<%@tag description="Overall Page template" pageEncoding="UTF-8" %>
<%@attribute name="top_nav" fragment="true" %>
<%@attribute name="song_header" fragment="true" %>

<HTML>

<body>
<div class="top_nav">
    <jsp:invoke fragment="top_nav" />
    <a href="/songs/new" class="navbar-link">Add new song</a>
    <a href="/songs/topTen" class="navbar-link">top 10 songs</a>
    <form name="artist_search_form" action="/songs/search/artist" method="get" class="form-inline nav_artist_search">
        <input type="text" name="artist_name">
        <input type="submit" class="btn-inverse" value="search">
    </form>
    <%--${dashboard_message}--%>
</div>
</body>
</HTML>