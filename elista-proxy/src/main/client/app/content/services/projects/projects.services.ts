/// <reference path="../../app.module.ts" />

module employees {
    'use strict';

    export interface IProjectService {
        getProject (): ng.IHttpPromise<Array<IProjects>>;
        getProjectStatus (): ng.IHttpPromise<Array<String>>;
        getProjectDetail(employeeId: number): ng.IHttpPromise<IProjects>;
        deleteProjectDetail (id: number): ng.IHttpPromise<IProjects>;
        saveProject(employee: IProjects): ng.IHttpPromise<IProjects>;
    }
    /*obiekt*/

    export class ProjectService
    implements IProjectService {


        // @ngInject
        constructor(private ConfigService: employees.IConfigService,
                    private $resource: ng.resource.IResourceService,
                    private $q: ng.IQService) {

        }

        public getProject (): ng.IHttpPromise<Array<IProjects>> {
            return this.$resource(`${this.ConfigService.getHost()}/employee/project/findAll`, {}, {
                'query': {
                    method: 'GET',
                    isArray: true
                }
            }).query({}).$promise

        };
        public getProjectStatus (): ng.IHttpPromise<Array<String>> {
            return this.$resource(`${this.ConfigService.getHost()}/employee/project/getStatus`, {}, {
                'query': {
                    method: 'GET',
                    isArray: true
                }
            }).query({}).$promise

        };

        public getProjectDetail (id: number): ng.IHttpPromise<IProjects> {
            return this.$resource(`${this.ConfigService.getHost()}/employee/project/findOne?id=:id`, {
                id: id,
            }, {
                'query': {
                    method: 'GET'
                }
            }).query({}).$promise

        };

        public deleteProjectDetail (id: number): ng.IHttpPromise<IProjects> {
            return this.$resource(`${this.ConfigService.getHost()}/employee/project/deleteOne?id=:id`, {
                id: id,
            }, {
                'query': {
                    method: 'DELETE'
                }
            }).query({}).$promise

        };

        public saveProject(project: IProjects): ng.IHttpPromise<IProjects> {
            return this.$resource(`${this.ConfigService.getHost()}/employee/project/save`, {
            }, {
                'query': {
                    method: 'POST'
                }
            }).query(project).$promise;
        };


    }

    angular.module('employees').service('ProjectService', ProjectService);
}
