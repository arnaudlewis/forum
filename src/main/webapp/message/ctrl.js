/**
 * Created by arnaud on 27/01/2014.
 */


angular.module('app.message')
    .controller('messageCtrl', ['messageService', '$scope', '$state', function (messageService, $scope, $state) {

        $scope.title = '';
        messageService.listMessage($scope.subjectSelected.id_subject);

        $scope.submit = function() {
            var creationDate = new Date();
            var title = $('#title').val();
            var content = $('#content').val();
            var author = JSON.parse(localStorage.getItem('user')).id_user;
            var idSubject = $scope.subjectSelected.id_subject;
            messageService.createMessage(idSubject, title, content, creationDate, author);
        }

        $scope.$on('MessageRefresh', function(event, data) {
            $scope.messages = data.listMessage;
        });

        $scope.$on('SubjectSelected', function(event, subject) {
            $scope.subjectSelected = subject;
        });

        $scope.answer = function() {
            $('#title').focus();
        };

    }]);