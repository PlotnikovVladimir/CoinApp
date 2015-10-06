var app = angular.module("NewApp", [])
    .directive("fileread", [function () {
        return {
            scope: {
                fileread: "="
            },
            link: function (scope, element, attributes) {
                element.bind("change", function (changeEvent) {
                    var reader = new FileReader();
                    reader.onload = function (loadEvent) {
                        scope.$apply(function () {
                            scope.fileread = loadEvent.target.result;
                        });
                    };
                    reader.readAsDataURL(changeEvent.target.files[0]);
                });
            }
        }
    }]);

    /*;  */

//app.controller('newCoinCntr', function($scope, $http){
//});

app.controller('newCoinCntr', function($scope, $http) {
    $scope.message = 'Look! ';
    $scope.fileImg1 = {};
    $scope.fileImg2 = {};

    $scope.saveCoin2 = function() {
        $scope.message = 'saveCoin() start work ';

        //var dataObj = {
        //    name : $scope.name,
        //    year : $scope.yearCa,
        //    description : $scope.description,
        //    category : 15
        //};
        //dataObj.append("coinsImage", $scope.Img);
        //
        //var res = $http.post({
        //    method : 'POST',
        //    url : 'http://localhost:8080/api/v1/categories/'+15+'/coins',
        //    headers: {'Content-Type': 'undefined'},
        //    data : dataObj
        //});
        var dataObj = {
         name : $scope.name,
         year : $scope.yearCa,
         description : $scope.description,
         category : 15,
         imageAversStr : $scope.fileImg1,
         imageReversStr : $scope.fileImg2
        };

        var res = $http({
                method : 'POST',
                url : 'http://localhost:8080/api/v1/categories/'+15+'/coins',
                data : dataObj
        });

/////////////////////////////////////////////////////////////////////////

//        var res = $http.post('http://localhost:8080/api/v1/categories/'+15+'/coins',dataObj);

        res.success(function(data, status, headers, config){
            $scope.message = 'Success!!!!!';
        });
        res.error(function(data, status, headers, config){
            $scope.message = 'Error!!!!!';
            alert("error");
        });
        $scope.name = '';
        $scope.yearCa = '';
        $scope.description = '';
        $scope.fileImg1 = {};
        $scope.fileImg2 = {};

    }

});

//function newCoinCntr($scope, $http){
//    $scope.saveCoin = function() {
//        $scope.message = 'saveCoin() start work ';
//        var dataObj = {
//            name : $scope.name,
//            year : $scope.yearCa,
//            description : $scope.description,
//            category : 15
//        };
//        var res = $http.post('/categories/'+15+'/coins', dataObj);
//        res.success(function(data, status, headers, config){
//        });
//        res.error(function(data, status, headers, config){
//            alert("error");
//        });
//        $scope.name = '';
//        $scope.yearCa = '';
//        $scope.description = '';
//
//    }
//}
