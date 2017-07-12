/// <reference path="../../app.module.ts" />

module employees {
    'use strict';

    export interface IContactTypeService {
        getContact (): ng.IHttpPromise<Array<IContact>>;
        getContactDetail(employeeId: number): ng.IHttpPromise<IContact>;
        deleteContactDetail (id: number): ng.IHttpPromise<IContact>;
        saveContact(employee: IContact): ng.IHttpPromise<IContact>;
    }
    /*obiekt*/

    export class ContactTypeService
        implements IContactTypeService {


        // @ngInject
        constructor(private ConfigService: employees.IConfigService,
                    private $resource: ng.resource.IResourceService,
                    private $q: ng.IQService) {

        }

        public getContact (): ng.IHttpPromise<Array<IContact>> {
            return this.$resource(`${this.ConfigService.getHost()}/employee/contact/findAll`, {}, {
                'query': {
                    method: 'GET',
                    isArray: true
                }
            }).query({}).$promise

        };

        public getContactDetail (id: number): ng.IHttpPromise<IContact> {
            return this.$resource(`${this.ConfigService.getHost()}/employee/contact/findOne?id=:id`, {
                id: id,
            }, {
                'query': {
                    method: 'GET'
                }
            }).query({}).$promise

        };

        public deleteContactDetail (id: number): ng.IHttpPromise<IContact> {
            return this.$resource(`${this.ConfigService.getHost()}/employee/contact/delete?id=:id`, {
                id: id,
            }, {
                'query': {
                    method: 'DELETE'
                }
            }).query({}).$promise

        };

        public saveContact(contact: IContact): ng.IHttpPromise<IContact> {
            return this.$resource(`${this.ConfigService.getHost()}/employee/contact/save`, {
            }, {
                'query': {
                    method: 'POST'
                }
            }).query(contact).$promise;
        };


    }

    angular.module('employees').service('ContactTypeService', ContactTypeService);
}
