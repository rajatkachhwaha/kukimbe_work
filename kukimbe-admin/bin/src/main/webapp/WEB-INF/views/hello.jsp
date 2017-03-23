<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link href='css/bootstrap.css' rel='stylesheet'>
    <link href='css/kukimbe.css' rel='stylesheet'>
    <title>Home</title>
</head>
<body>
<c:set var="activeNav">home</c:set>

<%@ include file="/WEB-INF/includes/nav.jsp" %>
<div class="jumbotron">
    <div class="container">
        <div class="row">
            This page is a template to be used for other pages
        </div>
    </div>
</div>
<%@ include file="/WEB-INF/includes/footer.jsp" %>
</body>
</html>
