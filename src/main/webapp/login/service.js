/**
 * Created by arnaud on 21/01/2014.
 */

angular.module('app.login', [])
    .service('loginService', ['$rootScope', '$http', function ($rootScope, $http) {
        var login;
        var password;


        function logUser(username, password) {
            $http({
                method: 'POST',
                url: "/rest/login/connect",
                data: {username: username, password: password}
            }).
                success(function (data) {
                    $rootScope.connect = data.connect;
                    if (data.connect === 1) {
                        window.localStorage.setItem('user', JSON.stringify(data.user));
                        $rootScope.$broadcast('loggedUser', data.user);
                    } else {
                        $rootScope.$broadcast('loginFailed');
                    }
                }).
                error(function (data, status, headers, config) {
                });
        }

        return {
            login: function (username, password) {
                logUser(username, password);
            }
        }
    }])