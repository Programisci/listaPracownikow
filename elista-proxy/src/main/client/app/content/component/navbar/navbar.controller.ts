/**
 * Created by Damian on 11.05.2017.
 */
/// <reference path="../../app.module.ts" />

module employees {
  'use strict';

  export class NavbarCtrl {

    user: IUser = {};
    inputContainerVisible = false;
    public refreshListAfterAdd: ($event) => void;
    public employeDetail: IEmployee;
    public showAdminFunction: boolean = false;

      // @ngInject
    constructor(private EmployeeBackService: IEmployeeBackService,
                private $state: ng.ui.IStateService,
              private $translatePartialLoader: ng.translate.ITranslatePartialLoaderService) {
      this.$translatePartialLoader.addPart('main');
      this.$translatePartialLoader.addPart('icons');
        this.EmployeeBackService.getEmployeeDetail(localStorage.getItem("token")).then(this.getEmployeeCallBack)
    }

    private getEmployeeCallBack = (res: IEmployee) => {
        this.employeDetail = res;
        if(this.employeDetail.role == "Admin"){
          this.showAdminFunction = true;
        } else {
          this.showAdminFunction = false;
        }
    };

    private formVisibleAfterAdd(hideVariable) {
      this.inputContainerVisible = hideVariable;
      this.refreshListAfterAdd({$event: angular.copy(true)});
    }

    public slide() {

      this.inputContainerVisible = !this.inputContainerVisible;
    };

    public logout(){
      localStorage.clear();
      this.$state.go('access.signin');
    }

  }

  angular.module('employees').controller('NavbarCtrl', NavbarCtrl);
}
