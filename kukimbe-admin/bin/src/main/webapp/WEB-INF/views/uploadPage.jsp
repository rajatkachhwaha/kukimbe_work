<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link href='css/bootstrap.css' rel='stylesheet'>
    <link href='css/kukimbe.css' rel='stylesheet'>
    <title>Upload Excel</title>
</head>
<body>
<c:set var="activeNav">upload</c:set>

<%@ include file="/WEB-INF/includes/nav.jsp" %>
<div class="jumbotron">
    <div class="container">
        <form method="POST" enctype="multipart/form-data" action="uploadFile.htm" class="form-horizontal"
              id="upload-form">

                <c:if test="${not empty error}">
                    <div class="row">
                        <div class="alert alert-danger">
                            <ul>
                                <li>${error}</li>
                            </ul>
                        </div>
                    </div>
                </c:if>

            <div class="row">
                <div class="col-lg-3"></div>
                    <div class="form-group col-lg-6">
                        <label for="file-input" class="col-xs-2 col-form-label">File</label>
                        <div class="col-xs-10">
                            <input class="form-control" type="file"  name="file" id="file-input">
                        </div>
                    </div>
                <div class="col-lg-3"></div>
            </div>
            <div class="row">
                <div class="col-lg-3"></div>
                <input type="submit" value="Upload" class="btn btn-primary btn-group-sm"
                       />
                <div class="col-lg-3"></div>
            </div>
        </form>
    </div>
</div>
<%@ include file="/WEB-INF/includes/footer.jsp" %>
</body>
</html>
