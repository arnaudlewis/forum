/**
 * Created by arnaud on 27/01/2014.
 */

angular.module('app.signin')

    .controller('signinCtrl', ['md5', 'signinService', '$state', '$timeout', '$scope', function (md5, signinService, $state, $timeout, $scope) {

        $scope.submit = function() {
            var creationDate = new Date();

            signinService.createUser(creationDate, $scope.firstname, $scope.lastname, $scope.username, md5.createHash($scope.password), $scope.age, $scope.email);
        }

        $scope.$on('failedUserCreation', function(event) {
            $('.alert').remove();
            $('#signin').prepend('<div class="alert alert-warning fade in">' +
                '<strong>Erreur !</strong><br />Une erreur est survenue lors de la cr&eacute;ation de votre compte.'+
            '</div>');
        });

        $scope.$on('successUserCreation', function(event) {
            $('.alert').remove();
            $('#signin').prepend('<div class="alert alert-success fade in">' +
                '<strong>Compte enregistr&eacute; !</strong><br />Vous allez etre redirig&eacute; vers l\'accueil.'+
                '</div>', content.childNodes[0]);

            $timeout(function() {
                $state.go('main.home');
            }, 3000);
        })
    }]);