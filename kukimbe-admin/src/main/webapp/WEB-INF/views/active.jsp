<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link href='css/bootstrap.css' rel='stylesheet'>
    <link href='css/kukimbe.css' rel='stylesheet'>
    <link href='css/jquery-ui.min.css' rel='stylesheet'>
    <link href='css/select2.min.css' rel='stylesheet'>

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
                    <!--
                    <button name="saveRace" class="btn-primary" onclick="saveRace()">Save Race</button>
                    <button name="saveRace" class="btn-primary" onclick="saveRaces()">Save Races</button>
                    -->
                </div>
            </div>

            <div class="row">
                <table id="race-table" class="table table-hover table-bordered" style="display:none;">
                    <tr>
                        <th>Title</th>
                        <th>Description</th>
                        <th>Date</th>
                        <th>Updated Date</th>
                        <th>City</th>
                        <th>State</th>
                        <th>Zipcode</th>
                        <th>Race Types</th>
                        <th style="min-width:100px;">K Race Types</th>
                        <th>Geolocation</th>
                        <th>Registration Url</th>
                        <th>Url</th>
                        <th>Select</th>
                    </tr>
                </table>
            </div>
            <div class="row">
                <div class="col-sm-2">&nbsp;</div>
                <div class="col-sm-10"><button name="saveForms" class="btn-primary pull-right" onclick="saveRaceForms();">Save</button></div>
                <div class="col-sm-2"></div>
            </div>
        </div>
        <div id="race-forms" style="display:none;">

        </div>
    </section>
</div>

<%@ include file="/WEB-INF/includes/footer.jsp" %>
<script id="race-row" type="text/x-handlebars-template">
    <tr>
        <td>{{raceName}}</td>
        <td>{{description}}</td>
        <td>{{date}}</td>
        <td>{{updateDate}}</td>
        <td>{{city}}</td>
        <td>{{state}}</td>
        <td>{{zipcode}}</td>
        <td>{{raceTypes}}</td>
        <td style="min-width:100px;"><select class="select2" id="{{raceId}}-select" style="min-width:100px;"></select></td>
        <td>({{geolocation}})</td>
        <td>{{registrationUrl}}</td>
        <td>{{url}}</td>
        <td id="{{raceId}}"><input type="checkbox" class="save-check" /></td>
    </tr>
</script>

<script id="race-form" type="text/x-handlebars-template">
    <form action="api/saveRace" method="post" id="{{raceId}}-form">
        <input type="hidden" name="title" id="race-title" value="{{raceName}}"/>
        <input type="hidden" name="description" id="race-description" value="{{description}}"/>
        <input type="hidden" name="city" id="race-city"  value="{{city}}"/>
        <input type="hidden" name="state" id="race-state" value="{{state}}" />
        <input type="hidden" name="zipcode" id="race-zipcode"  value="{{zipcode}}"/>
        <input type="hidden" name="raceType" id="race-type"  value="{{raceTypes}}"/>
        <input type="hidden" name="raceId" id="race-id"  value="{{raceId}}"/>
        <input type="hidden" name="geoloc" id="race-geo"  value="{{geolocation}}" />
        <input type="hidden" name="url" id="race-url"  value="{{url}}"/>
        <input type="hidden" name="registrationUrl" id="race-registrationUrl"  value="{{registrationUrl}}"/>
        <input type="hidden" name="date" id="race-date"  value="{{date}}"/>
        <input type="hidden" name="updateDate" id="race-updateDate"  value="{{updateDate}}"/>
    </form>

</script>
</body>
</html>
