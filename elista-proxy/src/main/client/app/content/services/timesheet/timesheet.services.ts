/// <reference path="../../app.module.ts" />

module employees {
    'use strict';

    export interface ITimesheetService {
        getTimesheet (): ng.IHttpPromise<Array<ITimesheet>>;
        getTimesheetDetail(timesheetId: number): ng.IHttpPromise<ITimesheet>;
        deleteTimesheetDetail (id: number): ng.IHttpPromise<ITimesheet>;
        saveTimesheet(timesheet: ITimesheet): ng.IHttpPromise<ITimesheet>;

    }

    export class TimesheetService
        implements ITimesheetService {



        // @ngInject
        constructor(private ConfigService: employees.IConfigService,
                    private $resource: ng.resource.IResourceService,
                    private $q: ng.IQService) {

        }

        public getTimesheet (): ng.IHttpPromise<Array<ITimesheet>> {
            return this.$resource(`${this.ConfigService.getHost()}/employee/timesheet/findAll`, {}, {
                'query': {
                    method: 'GET',
                    isArray: true
                }
            }).query({}).$promise

        };

        public getTimesheetDetail (id: number): ng.IHttpPromise<ITimesheet> {
            return this.$resource(`${this.ConfigService.getHost()}/employee/timesheet/findOne?id=:id`, {
                id: id,
            }, {
                'query': {
                    method: 'GET'
                }
            }).query({}).$promise

        };

        public deleteTimesheetDetail (id: number): ng.IHttpPromise<ITimesheet> {
            return this.$resource(`${this.ConfigService.getHost()}/employee/timesheet/deleteOne?id=:id`, {
                id: id,
            }, {
                'query': {
                    method: 'DELETE'
                }
            }).query({}).$promise

        };

        public saveTimesheet(timesheet: ITimesheet): ng.IHttpPromise<ITimesheet> {
            return this.$resource(`${this.ConfigService.getHost()}/employee/timesheet/save`, {
            }, {
                'query': {
                    method: 'POST'
                }
            }).query(timesheet).$promise;
        };


    }

    angular.module('employees').service('TimesheetService', TimesheetService);
}
