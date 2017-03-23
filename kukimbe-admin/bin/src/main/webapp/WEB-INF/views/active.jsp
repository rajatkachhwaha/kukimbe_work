<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link href='css/bootstrap.css' rel='stylesheet'>
    <link href='css/kukimbe.css' rel='stylesheet'>
    <link href='css/jquery-ui.min.css' rel='stylesheet'>
    <title>Active Data</title>
</head>
<body>
<c:set var="activeNav">active</c:set>

<%@ include file="/WEB-INF/includes/nav.jsp" %>
<div class="container-fluid">
    <section class="row sc-activites ">
        <div class="container">
            <div class="row">
                <div class="col-sm-2">&nbsp;</div>
                <div class="col-sm-4 text-center lsect">
                    <div class="input-group">
                        <span class="input-group-addon input-group-override">Start Date:</span>
                        <input type="text" class="form-control" name="startDate" id="start-date-picker"  >
                    </div>
                    <p>&nbsp;</p>
                    <div class="input-group">
                        <span class="input-group-addon input-group-override">End Date:</span>
                        <input type="text" class="form-control" name="endDate" id="end-date-picker"   >
                    </div>
                </div>
                <div class="col-sm-4 text-center lsect">
                    <div class="input-group">
                        <span class="input-group-addon input-group-override">Results Per Page:</span>
                        <input type="number" class="form-control" name="numPerPage" id="results-per-page" value="10">
                    </div>
                    <p>&nbsp;</p>
                    <div class="input-group">
                        <span class="input-group-addon input-group-override" >Sort By:</span>
                        <select class="form-control" name="sortBy" id="sort-by-select">
                            <option value="distance">distance</option>
                            <option value="date_asc">date_asc</option>
                            <option value="date_desc">date_desc</option>
                        </select>
                    </div>
                    <p>&nbsp;</p>
                    <div class="input-group pull-right">
                        <button name="loadData" class="btn-primary" onclick="searchActive();">Search</button>
                    </div>
                    <button name="saveRace" class="btn-primary" onclick="saveRace()">Save Race</button>
                </div>

                    <!--
                                <div class="buffer"></div>
                                <div class="row col-lg-12">
                                    <table id="race-table" class="table table-hover table-bordered">
                                        <tr>
                                            <th>Race Name</th>
                                            <th>Date</th>
                                            <th>City</th>
                                            <th>State</th>
                                            <th>Zipcode</th>
                                            <th>Race Types</th>
                                            <th>Weekday</th>
                                            <th>Description</th>
                                            <th>Geolocation</th>
                                            <th>Registration Url</th>
                                        </tr>

                                    </table>
                                </div>
                                <div class="row col-lg-12">
                                    <div id="results">
                                        <pre></pre>
                                    </div>

                                </div>
                                -->

            </div>
            <div class="row">
                <table id="race-table" class="table table-hover table-bordered" style="display:none;">
                    <tr>
                        <th>Race Name</th>
                        <th>Date</th>
                        <th>City</th>
                        <th>State</th>
                        <th>Zipcode</th>
                        <th>Race Types</th>
                        <th>Weekday</th>
                        <th>Description</th>
                        <th>Geolocation</th>
                        <th>Registration Url</th>
                    </tr>
                </table>
            </div>
        </div>
    </section>
</div>

<%@ include file="/WEB-INF/includes/footer.jsp" %>
<script id="race-row" type="text/x-handlebars-template">
    <tr>
        <td>{{raceName}}</td>
        <td>{{date}}</td>
        <td>{{city}}</td>
        <td>{{state}}</td>
        <td>{{zipcode}}</td>
        <td>{{raceTypes}}</td>
        <td>{{weekday}}</td>
        <td>{{description}}</td>
        <td>({{geolocation}})</td>
        <td>{{registrationUrl}}</td>
    </tr>
</script>
</body>
</html>
