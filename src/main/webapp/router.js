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
                    "navigationView@": {
                        templateUrl: "/common/navigation/index.html"
                    }
                }
            })
            .state('main.home', {
                url: "/home",
                views: {
                    "contentView@": {
                        templateUrl: "/home/index.html"
                    }
                }
            })

            .state('main.message', {
                url: "/messages",
                views: {
                    "contentView@": {
                        templateUrl: "/message/index.html"
                    }
                }
            })

            .state('main.signin', {
                url: "/signIn",
                views: {
                    "contentView@": {
                        templateUrl: "/signin/index.html"
                    }
                }
            })
    });