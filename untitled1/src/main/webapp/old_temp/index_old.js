/**
 * Created by user on 11.09.2015.
 */

var app = angular.module('mainApp', []).
        config(['$routeProvider',
            function($routeProvider){
                $routeProvider
                    .when('/profile',{
                        templateUrl:'index.html',
                        controller:'profCntrl'})
                    .otherwise({
                        redirectTo:'/'
                    });
            }
        ]);

app.controller('TestController', function($scope, $http){
    $http.get("http://localhost:8080/api/v1/v1")
        .success(function(responce){$scope.names = responce;});
    //$http.get("http://localhost:8080/api/v1/coins")
    //    .success(function(responce){$scope.coins = responce});
});

var appCategory = angular.module('categoriesApp', ['ui.router', 'ngDialog']);

appCategory.config(function($stateProvider, $urlRouterProvider){
    //$urlRouterProvider.otherwise('/');
    $stateProvider
        .state('view1', {
           url : "/view1",
            templateUrl : "index.html"
        });
});

appCategory.controller('aboutController', function($scope) {
    $scope.message = 'Look! I am an about page.';
});

appCategory.controller('CategoryCntr',function($scope, $http, ngDialog){
    $http.get("http://localhost:8080/api/v1/categories")
        .success(function(responce){$scope.categories = responce});
    $http.get("http://localhost:8080/api/v1/coins")
        .success(function(responce){$scope.coinsForView = responce});
    $scope.forFilter = '';
///////////////////////////////////////////////////////

    $scope.opendia2 = function (message) {
        ngDialog.open({
            template: 'templateId2',
            plain: true
        });
    };

//    $scope.items = ['item1', 'item2', 'item3'];
//
//
//    $scope.open = function (size) {
//
//        var modalInstance = $modal.open({
//            animation: true,
//            templateUrl: 'myModalContent.html',
//            controller: 'ModalInstanceCtrl',
//            size: size,
//            resolve: {
//                items: function () {
//                    return $scope.items;
//                }
//            }
//        });
//
//        modalInstance.result.then(function (selectedItem) {
//            $scope.selected = selectedItem;
//        });
//    };
///////////////////////////////////////////////////////////

});
///////////////////////////////////////////////////////////////////
//appCategory.controller('ModalInstanceCtrl', function ($scope, $modalInstance, items) {
//
//    $scope.items = items;
//    $scope.selected = {
//        item: $scope.items[0]
//    };
//
//    $scope.ok = function () {
//        $modalInstance.close($scope.selected.item);
//    };
//
//    $scope.cancel = function () {
//        $modalInstance.dismiss('cancel');
//    };
//});
///////////////////////////////////////////////////////////////////
function CategCntr($scope, $http, ngDialog) {
    $scope.opendia = function (message) {
        ngDialog.open({
            template: 'templateId',
            plain: true,
            className: 'ngdialog-theme-default dialogwidth550',
            scope: $scope
        });
        //ngDialog.openConfirm({template:'index.html',
        //    scope: $scope
        //}).then(
        //    function(value){
        //    },
        //    function(value){
        //
        //    }
        //);
      //ngDialog.open(message);
      //  ngDialog.open({
      //      scope : $scope,
      //      template : '<div><p>This is templatasdasdasdasdasdase</p></div>',
      //      controller : $controller('CategCntr',{
      //          $scope: $scope,
      //          name: 'wqeqewqeqweqew'
      //      })
      //  });
    };

    $scope.showCategory = function (categoryId, categoryName) {
        $http.get("http://localhost:8080/api/v1/categories/" + categoryId + "/coins")
            .success(function(responce){$scope.coinsForView = responce});
        $scope.forFilter = '';

    };

    $scope.showAll = function(){
        $http.get("http://localhost:8080/api/v1/coins")
            .success(function(responce){$scope.coinsForView = responce});
        $scope.forFilter = '';
    };

    $scope.showSubCategory = function (categoryId, categoryName) {
        //$scope.parentI = categoryId;
        //$http.get("http://localhost:8080/api/v1/coins")
        $http.get("http://localhost:8080/api/v1/categories/" + categoryId + "/coins")
            .success(function(responce){$scope.coinsForView = responce});
        $scope.forFilter = '';

    };

    //$scope.modal = {
    //    "title": "Title",
    //    "content": "Hello Modal<br />This is a multiline message!"
    //};
}





//app.config(['$routeProvider', function($routeProvider){
//    $routeProvider
//        .when('/profile',{
//            templateUrl:'view1/view1.jsp',
//            controller:'profCntrl'
//        })
//        .otherwise();
//}]);

function simoCTRL($scope, $http){
    $scope.someThing = function(){
        $scope.simoleCode = 'Fine';
        $http.get("http://localhost:8080/api/v1/coins")
            .success(function(responce){$scope.coins = responce});
        $scope.coins = 'sdasdas';

    };
    $scope.simoleCode = 'First text';
}

///////////////////////////////////
