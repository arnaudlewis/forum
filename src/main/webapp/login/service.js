/**
 * Created by arnaud on 21/01/2014.
 */

angular.module('app.login', ['angular-md5'])
    .service('loginService', ['md5', '$rootScope', '$http', function (md5, $rootScope, $http) {
        var login;
        var password;


        function logUser(username, password) {
            $http({
                method: 'POST',
                url: "/rest/login/connect",
                data: {username: username, password: md5.createHash(password)}
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