/**
 * Created by arnaud on 19/01/2014.
 */

angular.module('app.router', ['ui.router'])

    .config(function ($stateProvider) {
        $stateProvider
            .state('main', {
                abstract: true,
                url: "/main",
                views: {
                    "menuView": {
                        templateUrl: '/common/menu/index.html'
                    },
                    "navigationView": {
                        templateUrl: "/common/navigation/index.html"
                    },
                    "contentView": {
                        templateUrl: "/home/index.html"
                    }
                }
            })
            .state('main.home', {
                url: "/home",
                views: {
                    "contentView": {
                        templateUrl: "/home/index.html"
                    }
                }
            })
    });