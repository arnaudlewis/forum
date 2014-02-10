/**
 * Created by arnaud on 21/01/2014.
 */

angular.module('app.navigation', ['app.login'])

    .controller('navigationCtrl', ['loginService', '$rootScope', '$scope', '$state', function (loginService, $rootScope, $scope, $state) {
        $scope.goState = function (stateParam) {
            $state.go(stateParam);
        }

        $scope.$on('loggedUser', function(event, user) {
            $rootScope.fullname = user.firstname + user.lastname;
            $rootScope.connect = 1;
        });

        $scope.login = function() {
            var username = document.getElementById('username').value;
            var password = document.getElementById('password').value;
           loginService.login(username, password);
        }

        $scope.signin = function() {
            $state.go('main.signin');
        }

        $scope.$on('loginFailed', function(event) {
            window.alert('Login incorrect ! ');
        })

        $scope.logout = function() {
            window.localStorage.removeItem('user');
            $rootScope.connect = 0;
        }
    }]);