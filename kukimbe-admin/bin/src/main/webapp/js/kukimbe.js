function saveRace(){
    $.ajax({
        type: "POST",
        data: JSON.stringify({"racename":"Race Name"}),
        contentType: "application/json; charset=utf-8",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        dataType: 'json',
        url: "api/saveRace.htm",
        cache: false,
        processData: false,
        success: function (result) {
            console.log(result)
        }
    });

}

function searchActive(){

    var startDate = $("#start-date-picker").val();
    var endDate = $("#end-date-picker").val();
    var resultsPerPage = $("#results-per-page").val();
    var sortBy = $("#sort-by-select").val();
    //console.log("Values: ", startDate, endDate, resultsPerPage, sortBy);
    var data = {startDate:startDate, endDate: endDate, resultsPerPage:resultsPerPage, sortBy:sortBy};
    // data["startDate"] = startDate;
    // data["endDate"] = endDate;
    // data["resultsPerPage"] = resultsPerPage;
    // data["sortBy"] = sortBy;
    // 'startDate':startDate,
    //     'endDate':endDate,
    //     'resultsPerPage': resultsPerPage,
    //     'sortBy': sortBy
    $.ajax({
        type: "POST",
        data:data,
        dataType: 'json',
        url: "api/loadActive.htm",
        success: function (results) {
            var raceTable = $("#race-table");
            $(raceTable).show();
            var template = document.getElementById('race-row').innerHTML;
            var compiled_template = Handlebars.compile(template);
            $("#results pre").text(JSON.stringify(results.results, null, 2));
            console.log(results);
            _.each(results.results, function(current){
                //console.log("current", current);
                var racetypes = '';
                _.each(current.assetTopics, function(topic){
                    //console.log("topic:", topic.topic.topicName);
                    racetypes = racetypes + " " + topic.topic.topicName;
                });
                var rendered = compiled_template({
                    raceName: current.assetName,
                    city: current.place.cityName,
                    state: current.place.stateProvinceCode,
                    zipcode: current.place.postalCode,
                    raceTypes: racetypes,
                    weekday: "",
                    description: description,
                    geolocation: current.place.geoPoint.lon  + ' , ' + current.place.geoPoint.lat,
                    date: current.activityStartDate,
                    registrationUrl:current.registrationUrlAdr});
                $(raceTable).find('tbody:last').append(rendered);
                console.log(current.assetName);
            });
        }
    });
};


$(document).ready(function() {
    var start = $('#start-date-picker').datepicker({dateFormat: "yy-mm-dd"});
    start.datepicker('setDate', new Date());
    var end = $('#end-date-picker').datepicker({dateFormat: "yy-mm-dd"});
    end.datepicker('setDate', new Date());
});
