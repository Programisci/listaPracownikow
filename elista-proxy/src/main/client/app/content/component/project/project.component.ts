/**
 * Created by Damian on 12.05.2017.
 */

/// <reference path="../../app.module.ts" />

module employees {
    'use strict';
    import IComponentController = angular.IComponentController;

    const ProjectComponent: ng.IComponentOptions = {
        bindings: {},
        controller: ProjectCtrl,
        controllerAs: 'projectCtr',
        templateUrl: 'content/component/project/project.template.html'
    };

    angular.module('employees').component('project', ProjectComponent);
}
