/// <reference path="../../app.module.ts" />

module employees {
  'use strict';

  export class SigninCtrl {

    user: IUser = {};

    // @ngInject
    constructor(private $translatePartialLoader: ng.translate.ITranslatePartialLoaderService,
                private $cookies: ng.cookies.ICookiesService,
                private $state: ng.ui.IStateService,
                private EmployeeBackService: IEmployeeBackService,
                private AuthService: IAuthService,
                private DataService: IDataService) {
      this.AuthService.endSession();
      this.$translatePartialLoader.addPart('signin');
      this.init();

    }

    private init(){
      this.EmployeeBackService.getInit().then(this.getEmployeeInitCallBack);

    }


    private getEmployeeInitCallBack = () => {
    };


    public login() {
      this.AuthService.login(this.user).then(this.loginResponseCallback);
    }

    private loginResponseCallback = (response: IToken)=> {
      this.$cookies.putObject('authToken', response);
      this.DataService.setAuthToken(response);
      this.$state.go('app.myOrdersPage');
    }
  }

  angular.module('employees').controller('SigninCtrl', SigninCtrl);
}
