
var mainApp = angular.module('mainApp', ['ngAnimate', 'ui.bootstrap']);

mainApp.directive("fileread", [function () {
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

var INTEGER_REGEXP = /^\-?\d+$/;
mainApp.directive('integer', function() {
    return {
        require: 'ngModel',
        link: function(scope, elm, attrs, ctrl) {
            ctrl.$validators.integer = function(modelValue, viewValue) {
                if (ctrl.$isEmpty(modelValue)) {
                    // consider empty models to be valid
                    return true;
                }

                if (INTEGER_REGEXP.test(viewValue)) {
                    // it is valid
                    return true;
                }

                // it is invalid
                return false;
            };
        }
    };
});

mainApp.controller('MenuCntr', function($scope, $http, $modal, $rootScope){
    $http.get("http://localhost:8080/api/v1/user")
        .success(function(responce){$rootScope.curUser = responce});

    $scope.openModalForAddCoin = function (size) {

        var modalInstance = $modal.open({
            animation: true,
            templateUrl: 'addCoin.html',
            controller: 'ModalInstanceCtrl',
            size: size,
            resolve: {
                items: function () {
                    return $scope;
                },
                controllerscope:function(){
                    return $scope;
                }
            }
        });

    };

    $scope.openModalForRegUser = function (size) {
        var modalInstance = $modal.open({
            animation: true,
            templateUrl: 'addUser.html',
            controller: 'ModalInstanceRegUserCtrl',
            size: size,
            resolve: {
                controllerscope:function(){
                    return $scope;
                }
            }
        });
    };

});

mainApp.controller('CategoryCntr',function($scope, $http, $modal, $log, $rootScope){
    $http.get("http://localhost:8080/api/v1/categories")
        .success(function(responce){
            //$scope.categories = responce;
            $rootScope.categories = responce
        });
    $http.get("http://localhost:8080/api/v1/coins")
        .success(function(responce){
            //$scope.coinsForView = responce;
            $rootScope.coinsForView = responce
        });
    $scope.forFilter = '';
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    $scope.items = ['item1', 'item2', 'item3'];

    //$scope.open = function (size) {
    //
    //    var modalInstance = $modal.open({
    //        animation: true,
    //        templateUrl: 'addCoin.html',
    //        controller: 'ModalInstanceCtrl',
    //        size: size,
    //        resolve: {
    //            items: function () {
    //                return $scope.items;
    //            },
    //            controllerscope:function(){
    //                return $scope;
    //            }
    //        }
    //    });

        //modalInstance.result.then(function (selectedItem) {
        //    $scope.selected = selectedItem;
        //}, function () {
        //    $log.info('Modal dismissed at: ' + new Date());
        //});
    //};
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
    $scope.openView = function (size, coin) {

        var modalInstance = $modal.open({
            animation: true,
            templateUrl: 'viewCoin.html',
            controller: 'ModalInstanceViewCtrl',
            size: size,
            resolve: {
                items: function () {
                    return $scope.items;
                },
                currentCoin:function () {
                    return coin;
                },
                controllerscope: function (){
                    return $scope;
                }
            }
        });

        //modalInstance.result.then(function (selectedItem) {
        //    $scope.selected = selectedItem;
        //}, function () {
        //    $log.info('Modal dismissed at: ' + new Date());
        //});
    };
//////////////////////////////////////////////////////////////////////////////////////////////////////////////


    $scope.showCategory = function (categoryId, categoryName) {
        $http.get("http://localhost:8080/api/v1/categories/" + categoryId + "/coins")
            .success(function(responce){$rootScope.coinsForView = responce});
        $scope.forFilter = '';

    };

    $scope.showAll = function(){
        $http.get("http://localhost:8080/api/v1/coins")
            .success(function(responce){$rootScope.coinsForView = responce});
        $scope.forFilter = '';
    };

    $scope.showSubCategory = function (categoryId, categoryName) {
        //$scope.parentI = categoryId;
        //$http.get("http://localhost:8080/api/v1/coins")
        $http.get("http://localhost:8080/api/v1/categories/" + categoryId + "/coins")
            .success(function(responce){$rootScope.coinsForView = responce});
        $scope.forFilter = '';
    };


});

//////////////////////////////////////////////////////////////////////////////////////////////////////////////
mainApp.controller('ModalInstanceCtrl', function ($scope, $http, $modalInstance, items, controllerscope, $rootScope) {
    //$scope.categories = controllerscope.categories;

    $scope.saveCoin = function () {
        var categorySelected = $scope.selectedCategoryId;
        var dataObj = {
            name : $scope.name,
            year : $scope.yearCa,
            description : $scope.description,
            imageAversStr : $scope.fileImg1,
            imageReversStr : $scope.fileImg2
        };


        var res = $http({
            method : 'POST',
            url : 'http://localhost:8080/api/v1/categories/'+categorySelected+'/coins',
            data : dataObj
        });
        res.success(function(data, status, headers, config){
            $http.get("http://localhost:8080/api/v1/coins")
                .success(function(responce){
                    $rootScope.coinsForView = responce;
                });
        });
        res.error(function(data, status, headers, config){
            alert("error : " + status);
        });
        $scope.name = '';
        $scope.yearCa = '';
        $scope.description = '';
        $scope.fileImg1 = {};
        $scope.fileImg2 = {};
        $modalInstance.close();
    };



    $scope.items = items;
    $scope.selected = {
        item: $scope.items[0]
    };

    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };
});
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
mainApp.controller('ModalInstanceRegUserCtrl', function($scope, $http, $modalInstance, controllerscope){
    $scope.userLogin = '';
    $scope.userEmail = '';
    $scope.userPassword = '';

    $scope.saveUser = function() {
        var dataObj = {
            login : $scope.userLogin,
            eMail : $scope.userEmail,
            password : $scope.userPassword
        };
        var res = $http({
            method : 'POST',
            url : 'http://localhost:8080/api/v1/user',
            data : dataObj
        });
        res.success(function(data, status, headers, config){
            alert("success : " + status);
        });
        res.error(function(data, status, headers, config){
            alert("error : " + status);
        });
        $modalInstance.close();
    };

    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };
});
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
mainApp.controller('ModalInstanceViewCtrl', function ($scope, $http, $modalInstance, items, currentCoin, controllerscope, $rootScope) {
    $scope.currentCoin = currentCoin;
    $scope.description = currentCoin.description;
    $scope.name = currentCoin.name;
    $scope.yearCa = currentCoin.year;
    $scope.categories = $rootScope.categories;
    $scope.selectedCategoryId = currentCoin.category;

    $http.get("http://localhost:8080/api/v1/generateCoinsImage/"+currentCoin.id)
        .success(function(responce){$scope.randomCoinsImage = responce});


    $scope.saveCoinEdit = function (){

        var categorySelected = $scope.selectedCategoryId;
        var coinId = $scope.currentCoin.id;

        var dataObj = {
            name : $scope.name,
            year : $scope.yearCa,
            description : $scope.description,
            imageAversStr : $scope.fileImg1,
            imageReversStr : $scope.fileImg2
        };
        var res = $http({
            method : 'PUT',
            url : 'http://localhost:8080/api/v1/categories/'+categorySelected+'/coins/'+coinId,
            data : dataObj
        });
        res.success(function(data, status, headers, config){
            $http.get("http://localhost:8080/api/v1/coins")
                .success(function(responce){
                    $rootScope.coinsForView = responce;
                });

        });
        res.error(function(data, status, headers, config){
            alert("error");
        });



        $modalInstance.close();
    };

    $scope.deleteCoin = function () {
        var coinId = $scope.currentCoin.id;
        var res = $http.delete('http://localhost:8080/api/v1/coins/'+coinId);


        res.success(function(data, status, headers, config){
            $http.get("http://localhost:8080/api/v1/coins")
                .success(function(responce){
                    $rootScope.coinsForView = responce;
                });

        });
        res.error(function(data, status, headers, config){
            alert("error");
        });

        $modalInstance.close($rootScope.coinsForView);

    };


    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };
});