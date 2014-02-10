/**
 * Created by arnaud on 27/01/2014.
 */


angular.module('app.home')
    .controller('homeCtrl', ['homeService', '$scope', '$rootScope', '$state', function (homeService, $scope, $rootScope, $state) {

        $scope.title = '';
        homeService.listSubject();

        $scope.submit = function() {
            var titleSelector = $('#title');

            var creationDate = new Date();
            var title = titleSelector.val();
            var author = JSON.parse(localStorage.getItem('user')).id_user;
            homeService.createSubject(title, creationDate, author);
            titleSelector.val('');
        }

        $scope.$on('SubjectRefresh', function(event, data) {
            $scope.subjects = data.listSubject;
        });

        $scope.selectSubject = function(sub) {
            $rootScope.$broadcast('SubjectSelected', sub);
            $state.go('main.home.message');
        }

    }]);