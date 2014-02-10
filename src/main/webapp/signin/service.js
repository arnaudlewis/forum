/**
 * Created by arnaud on 27/01/2014.
 */

angular.module('app.signin', [])

    .service('signinService', ['$rootScope', '$http', function ($rootScope, $http) {

        function create(creationDate, firstname, lastname, username, password, age, email) {
            $http({
                method: 'POST',
                url: "/rest/user/create",
                data: {creationDate: creationDate, firstname: firstname, lastname: lastname, username: username, password: password, age: age, email: email}
            })
                .success(function(data) {
                   if(data.id_user != -1) {
                        $rootScope.$broadcast('successUserCreation');
                    } else {
                        $rootScope.$broadcast('failedUserCreation');
                    }
                })
        }

        return {
            createUser: function(creationDate, firstname, lastname, username, password, age, email) {
                create(creationDate, firstname, lastname, username, password, age, email);
            }
        }
    }]);