/**
 * Created by arnaud on 27/01/2014.
 */

angular.module('app.message', [])
    .service('messageService', ['$rootScope', '$http', function ($rootScope, $http) {

        function list(idSubject) {
            $http({
                method: 'GET',
                url: "/rest/message/list",
                data: {idSubject: idSubject}
            }).
                success(function (data, status, headers, config) {
                    $rootScope.$broadcast('MessageRefresh', data);
                }).
                error(function (data, status, headers, config) {
                    window.alert('Erreur de recuperation des messages');
                });
        }

        function create(idSubject, title, content, creationDate, author) {
            $http({
                method: 'POST',
                url: "/rest/message/create",
                data: {idSubject: idSubject, title: title, content: content, creationDate: creationDate, id_author: author}
            })
                .success(function(data) {
                    list();
                    $rootScope.$broadcast('MessageRefresh', data);
                    return data != -1;
                })
        }

        return {
           listMessage: function(idSubject) {
               list(idSubject);
           },

            createMessage: function(idSubject, title, content, creationDate, author){
                return create(idSubject, title, content, creationDate, author);
            }
        }
    }]);