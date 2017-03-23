
var app=angular.module('myApp', [])
           .controller('MyController', function ($scope, $http) {
              $http({
                method :'GET',
                url:'ExcelFileReader'
            	  
              })
              .success(function (data, status, headers, config) {
                $scope.resultData = data;
             });
              
              $scope.checkAll = function () {

                  if ($scope.selectedAll) {
                      $scope.selectedAll = true;
                  } else {
                      $scope.selectedAll = false;
                  }
                  angular.forEach($scope.resultData, function (row) {
                      row.Selected = $scope.selectedAll;
                  });




              };
              
              
         });





  




