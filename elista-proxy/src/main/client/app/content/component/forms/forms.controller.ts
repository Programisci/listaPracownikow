/**
 * Created by Damian on 11.05.2017.
 */
/// <reference path="../../app.module.ts" />

module employees {
  'use strict';

  export class FormsCtrl {

    user: IUser = {};
    employee: IEmployee;
    public addNewEmployee: ($event) => void;

    // @ngInject
    constructor(private $translatePartialLoader: ng.translate.ITranslatePartialLoaderService,
                private EmployeeBackService: IEmployeeBackService,
                private $stateParams: ActorsStateParams,
                private $state: ng.ui.IStateService) {
      this.$translatePartialLoader.addPart('detail');
      this.$translatePartialLoader.addPart('icons');

    }


    public saveEmployee = () => {
      this.EmployeeBackService.saveEmployee(this.employee).then(this.saveEmployeeCallBack);

    };

    private saveEmployeeCallBack = (response) => {
      this.addNewEmployee({$event: angular.copy(false)});
      this.$state.go('access.userPage');
    };

  }

  angular.module('employees').controller('FormsCtrl', FormsCtrl);
}
