/// <reference path="../../app.module.ts" />

module employees {
    'use strict';

    export interface ISkillsService {
        getSkill (): ng.IHttpPromise<Array<ISkills>>;
        getSkillDetail(employeeId: number): ng.IHttpPromise<ISkills>;
        deleteSkillDetail (id: number): ng.IHttpPromise<ISkills>;
        saveSkill(employee: ISkills): ng.IHttpPromise<ISkills>;
    }

    export class SkillsService
        implements ISkillsService {

        // @ngInject
        constructor(private ConfigService: employees.IConfigService,
                    private $resource: ng.resource.IResourceService,
                    private $q: ng.IQService) {

        }


        public getSkill (): ng.IHttpPromise<Array<ISkills>> {
            return this.$resource(`${this.ConfigService.getHost()}/employee/skill/findAll`, {}, {
                'query': {
                    method: 'GET',
                    isArray: true
                }
            }).query({}).$promise

        };

        public getSkillDetail (id: number): ng.IHttpPromise<ISkills> {
            return this.$resource(`${this.ConfigService.getHost()}/employee/skill/findOne?id=:id`, {
                id: id,
            }, {
                'query': {
                    method: 'GET'
                }
            }).query({}).$promise

        };

        public deleteSkillDetail (id: number): ng.IHttpPromise<ISkills> {
            return this.$resource(`${this.ConfigService.getHost()}/employee/skill/deleteOne?id=:id`, {
                id: id,
            }, {
                'query': {
                    method: 'DELETE'
                }
            }).query({}).$promise

        };

        public saveSkill(skill: ISkills): ng.IHttpPromise<ISkills> {
            return this.$resource(`${this.ConfigService.getHost()}/employee/skill/save`, {
            }, {
                'query': {
                    method: 'POST'
                }
            }).query(skill).$promise;
        };



    }

    angular.module('employees').service('SkillsService', SkillsService);
}
