/**
 * Created by arnaud on 19/01/2014.
 */

var app = angular.module('app', ['angular-md5', 'app.router', 'app.remote', 'app.navigation', 'app.home', 'app.signin', 'app.message'])
    .run(['$http', '$rootScope', '$state', function ($http, $rootScope, $state) {
        if(localStorage.getItem('user')) {
            localStorage.removeItem('user');
        }
        $state.go('main.home');
    }]);