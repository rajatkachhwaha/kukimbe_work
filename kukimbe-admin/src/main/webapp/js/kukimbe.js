function saveRace(){
    $.ajax({
        type: "POST",
        data: JSON.stringify({"name":"Race Name"}),
        contentType: "application/json; charset=utf-8",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        dataType: 'json',
        url: "api/saveRace",
        cache: false,
        processData: false,
        success: function (result) {
            console.log(result)
        }
    });

}

function saveRaces(){
    $.ajax({
        type: "POST",
        data: JSON.stringify([{"name":"Race Name"}, {"name":"Race Two"}]),
        contentType: "application/json; charset=utf-8",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        dataType: 'json',
        url: "api/saveRaces",
        cache: false,
        processData: false,
        success: function (result) {
            console.log(result)
        }
    });

}
var raceTypes = [];
var select2data = [];
function getRaceTypes(){
    if(_.isNull(raceTypes) || _.isUndefined(raceTypes) || !raceTypes.length >0){
        //     'sortBy': sortBy
        $.get( "api/raceTypes", function( data ) {
            console.log("RACE TYPES:", data);
            _.each(data, function(current){
                console.log("Pushing: ", current);
                raceTypes.push(current);

                select2data.push({id: current._id, text: current.race_name, image:current.race_image});
            });
        });
    }
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
            var raceForms = $("#race-forms");
            var formTemplate = document.getElementById('race-form').innerHTML;
            var formCompiledTemplate = Handlebars.compile(formTemplate);
            $("#results pre").text(JSON.stringify(results.results, null, 2));
            console.log(results);
            _.each(results.results, function(current){
                //console.log("current", current);
                var racetypes = '';
                _.each(current.assetTopics, function(topic){
                    //console.log("topic:", topic.topic.topicName);
                    racetypes = racetypes + " " + topic.topic.topicName;
                });
                var description;
                _.each(current.assetDescriptions, function(descrip){
                    console.log(descrip.description);
                    description = descrip.description;
                });
                var rendered = compiled_template({
                    raceName: current.assetName,
                    city: current.place.cityName,
                    state: current.place.stateProvinceCode,
                    zipcode: current.place.postalCode,
                    raceTypes: racetypes,
                    description: description,
                    url: current.urlAdr,
                    geolocation: current.place.geoPoint.lon  + ' , ' + current.place.geoPoint.lat,
                    date: current.activityStartDate,
                    updateDate: current.modifiedDate,
                    registrationUrl:current.registrationUrlAdr,
                    raceId:current.assetGuid});
                $(raceTable).find('tbody:last').append(rendered);
                console.log(current.assetName);

                var renderedForm = formCompiledTemplate({
                    raceName: current.assetName,
                    city: current.place.cityName,
                    state: current.place.stateProvinceCode,
                    zipcode: current.place.postalCode,
                    raceTypes: racetypes,
                    description: description,
                    url: current.urlAdr,
                    geolocation: current.place.geoPoint.lon  + ' , ' + current.place.geoPoint.lat,
                    date: current.activityStartDate,
                    updateDate: current.modifiedDate,
                    registrationUrl:current.registrationUrlAdr,
                    raceId:current.assetGuid});

                $(raceTable).append(renderedForm);

            });
            initSelect2s();//TODO add a loading image
        }
    });
};

function initSelect2s(){
    $(".select2").each(function(index){
        console.log("Loading data for id: ", $(this).id);
        console.log("Data size", select2data.length);
        //select2 onchange will need to update the embedded race image and race type
       $(this).select2({data:select2data});
    });
}

function saveRaceForms(){
    var checkedNum = $(".save-check:checked").length;
    console.log("Checked: ", checkedNum);
}

$(document).ready(function() {
    getRaceTypes();
    var start = $('#start-date-picker').datepicker({dateFormat: "yy-mm-dd"});
    start.datepicker('setDate', new Date());
    var end = $('#end-date-picker').datepicker({dateFormat: "yy-mm-dd"});
    end.datepicker('setDate', new Date());
});
