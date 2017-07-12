/// <reference path="../../app.module.ts" />

module employees {
    'use strict';

    export interface IEmployeeBackService {
        getEmployee (): ng.IHttpPromise<Array<IEmployee>>;
        getEmployeeDetail(employeeId: number): ng.IHttpPromise<IEmployee>;
        deleteEmployeeDetail (id: number): ng.IHttpPromise<IEmployee>;
        saveEmployee(employee: IEmployee): ng.IHttpPromise<IEmployee>;
        getInit ();

    }

    export class EmployeeBackService
        implements IEmployeeBackService {



        // @ngInject
        constructor(private ConfigService: employees.IConfigService,
                    private $resource: ng.resource.IResourceService,
                    private $q: ng.IQService) {

        }

        public getInit () {
            return this.$resource(`${this.ConfigService.getHost()}/employee/init`, {}, {
                'query': {
                    method: 'GET',
                    isArray: true
                }
            }).query({}).$promise

        };
        public getEmployee (): ng.IHttpPromise<Array<IEmployee>> {
            return this.$resource(`${this.ConfigService.getHost()}/employee/findAll`, {}, {
                'query': {
                    method: 'GET',
                    isArray: true
                }
            }).query({}).$promise

        };

        public getEmployeeDetail (id: number): ng.IHttpPromise<IEmployee> {
            return this.$resource(`${this.ConfigService.getHost()}/employee/findOne?id=:id`, {
                id: id,
            }, {
                'query': {
                    method: 'GET'
                }
            }).query({}).$promise

        };

        public deleteEmployeeDetail (id: number): ng.IHttpPromise<IEmployee> {
            return this.$resource(`${this.ConfigService.getHost()}/employee/deleteOne?id=:id`, {
                id: id,
            }, {
                'query': {
                    method: 'DELETE'
                }
            }).query({}).$promise

        };

        public saveEmployee(employee: IEmployee): ng.IHttpPromise<IEmployee> {
            return this.$resource(`${this.ConfigService.getHost()}/employee/save`, {
            }, {
                'query': {
                    method: 'POST'
                }
            }).query(employee).$promise;
        };


    }

    angular.module('employees').service('EmployeeBackService', EmployeeBackService);
}
