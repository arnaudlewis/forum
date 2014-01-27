/**
 * Created by arnaud on 21/01/2014.
 */

angular.module('app.navigation', [])

    .controller('navigationCtrl', ['$scope', '$state', function ($scope, $state) {
        $scope.goState = function (stateParam) {
            $state.go(stateParam);
        }
    }]);