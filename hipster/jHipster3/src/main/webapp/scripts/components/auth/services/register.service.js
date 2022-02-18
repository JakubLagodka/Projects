'use strict';

angular.module('webappApp')
    .factory('Register', function ($resource) {
        return $resource('api/register', {}, {
        });
    });


