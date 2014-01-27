/**
 * Created by arnaud on 19/01/2014.
 */

var app = angular.module('app', ['app.router', 'app.remote', 'app.navigation'])
    .run(['$state', function ($state) {
        $state.go('main.home');
    }]);