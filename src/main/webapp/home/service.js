/**
 * Created by arnaud on 27/01/2014.
 */

angular.module('app.home', [])
    .service('homeService', ['$rootScope', '$http', function ($rootScope, $http) {

        function list() {
            $http({
                method: 'GET',
                url: "/rest/subject/list"
            }).
                success(function (data, status, headers, config) {
                    $rootScope.$broadcast('SubjectRefresh', data);
                }).
                error(function (data, status, headers, config) {
                    window.alert('Erreur de récupération des sujets');
                });
        }

        function create(title, creationDate, author) {
            $http({
                method: 'POST',
                url: "/rest/subject/create",
                data: {title: title, creationDate: creationDate, id_author: author}
            })
                .success(function(data) {
                    list();
                    $rootScope.$broadcast('SubjectRefresh', data);
                    return data != -1;
                })
        }

        return {
           listSubject: function() {
               list();
           },

            createSubject: function(title, creationDate, author){
                return create(title, creationDate, author);
            }
        }
    }]);