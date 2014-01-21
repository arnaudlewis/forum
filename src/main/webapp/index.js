/**
 * Created by arnaud on 19/01/2014.
 */

angular.module('app', ['app.remote'])

    .service('LoginService', ['$rootScope', '$http', function ($rootScope, $http) {
        var login;
        var password;

        function logUser(username, password) {
            $http({
                method: 'POST',
                url: "/rest/login/connect",
                data: {username: username, password: password}
                }).
                success(function(data, status, headers, config) {
                    window.alert(data);
                }).
                error(function(data, status, headers, config) {
                    window.alert(data);
                });
        }

        return {
            login: function(username, password) {
                logUser(username, password);
            }
        }
    }])

    .controller('MainCtrl', ['$scope', 'LoginService', function ($scope, LoginService) {
        $scope.username = "test";

        $scope.login = function () {
            LoginService.login(this.username, this.password);
            return false;
        };

    }]);