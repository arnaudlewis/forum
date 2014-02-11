/**
 * Created by arnaud on 27/01/2014.
 */


angular.module('app.message')
    .controller('messageCtrl', ['messageService', '$scope', '$state', function (messageService, $scope, $state) {

        $scope.title = '';
        if (messageService.getSubjectSelected()) {
            $scope.subjectSelected = messageService.getSubjectSelected();
        }
        else {
            $state.go('main.home');
        }

        $scope.submit = function () {
            var creationDate = new Date();
            var title = $('#title').val();
            var content = $('#msg-content').val();
            var author = JSON.parse(localStorage.getItem('user')).id_user;
            var subject = $scope.subjectSelected;
            messageService.createMessage(subject, title, content, creationDate, author);
        }

        $scope.$on('MessageRefresh', function (event, data) {
            var d = new Date(data.subject.messageList[0].creation_date);
            var curr_date = d.getDate();
            var curr_month = d.getMonth() + 1; //Months are zero based
            var curr_year = d.getFullYear();

            data.subject.messageList[0].creation_date = curr_year+'-'+curr_month+'-'+curr_date;
                $scope.subjectSelected.messageList.push(data.subject.messageList[0]);
            $('#title').val('');
            $('#msg-content').val('');
        });

        $scope.answer = function () {
            $('#title').focus();
        };

    }]);