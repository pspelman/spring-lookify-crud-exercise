<%@tag description="Overall Page template" pageEncoding="UTF-8" %>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<%@attribute name="top_nav" fragment="true" %>
<HTML>
    <body>
        <div id="top_nav">
            <h4>This is the top navbar</h4>
            <jsp:invoke fragment="top_nav" />

        </div>
        <div id="pageheader">
            <jsp:invoke fragment="header" />
        </div>
        <div>
            <h3>NEW THING HERE</h3>
        </div>
    <div id="body">
        <jsp:doBody/>
    </div>
    <div id="pagefooter">
        <jsp:invoke fragment="footer" />
    </div>
    </body>
</HTML>