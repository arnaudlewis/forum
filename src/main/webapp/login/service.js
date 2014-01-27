/**
 * Created by arnaud on 21/01/2014.
 */

angular.module('app.login', [])
    .service('LoginService', ['$rootScope', '$http', function ($rootScope, $http) {
        var login;
        var password;

        function logUser(username, password) {
            $http({
                method: 'POST',
                url: "/rest/login/connect",
                data: {username: username, password: password}
            }).
                success(function (data, status, headers, config) {
                    window.alert(data);
                }).
                error(function (data, status, headers, config) {
                    window.alert(data);
                });
        }

        return {
            login: function (username, password) {
                logUser(username, password);
            }
        }
    }])