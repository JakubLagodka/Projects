'use strict';

angular.module('webappApp')
    .controller('UserManagementDetailController', function ($scope, $stateParams, User) {
        $scope.user = {};
        $scope.load = function (login) {
            User.get({login: login}, function(result) {
                $scope.user = result;
            });
        };
        $scope.load($stateParams.login);
    });
