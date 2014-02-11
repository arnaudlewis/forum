/**
 * Created by arnaud on 27/01/2014.
 */

angular.module('app.message', [])
    .service('messageService', ['$rootScope', '$http', function ($rootScope, $http) {

        var subjectSelected;


        function create(subject, title, content, creationDate, author) {
            $http({
                method: 'POST',
                url: "/rest/message/create",
                data: {subject: subject, title: title, content: content, creationDate: creationDate, id_author: author}
            })
                .success(function (data) {
                    $rootScope.$broadcast('MessageRefresh', data);
                    return data != -1;
                })
        }

        return {

            createMessage: function (subject, title, content, creationDate, author) {
                return create(subject, title, content, creationDate, author);
            },

            setSubjectSelected: function (subject) {
                subjectSelected = subject;
            },

            getSubjectSelected: function() {
                return subjectSelected;
            }
        };
    }
    ])
;