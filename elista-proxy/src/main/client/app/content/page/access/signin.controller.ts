/// <reference path="../../app.module.ts" />

module employees {
  'use strict';

  export class SigninCtrl {

    user: IUser = {};
    addDataBase: boolean = true;
    arrayEmployee: Array<IEmployee>;
    id: string;



      // @ngInject
    constructor(private $translatePartialLoader: ng.translate.ITranslatePartialLoaderService,
                private $cookies: ng.cookies.ICookiesService,
                private $state: ng.ui.IStateService,
                private EmployeeBackService: IEmployeeBackService,
                private AuthService: IAuthService,
                private DataService: IDataService) {
      this.AuthService.endSession();
      this.$translatePartialLoader.addPart('signin');
        this.EmployeeBackService.getEmployee().then(this.getEmployeeCallBack);

    }

    private init(){
     if(this.addDataBase == true){
       this.EmployeeBackService.getInit();
       this.EmployeeBackService.getInitContact();
       this.EmployeeBackService.getInitProject();
       this.EmployeeBackService.getInitSkill();
       this.EmployeeBackService.getInitTimesheet();
       this.EmployeeBackService.getInitTopic();
       this.addDataBase == false;

     };

    }

      private getEmployeeCallBack = (res: Array<IEmployee>) => {
          this.arrayEmployee = res;
      };


    public login(user: IUser) {
        for(var i =0; i < this.arrayEmployee.length; i++){
            if ( this.arrayEmployee[i].login == user.login){
                if(this.arrayEmployee[i].passwd == user.passwd){
                    var token = this.arrayEmployee[i].id;
                    this.id = this.arrayEmployee[i].id.toString();
                    localStorage.setItem("token", this.id);
                    this.$state.go('access.userPage');
                } else {
                    console.log("Błędny login lub hasło");
                    this.user = {};
                }
            } else {
                console.log("Błędny login lub hasło");
                this.user = {};
            }
        }
    }



    private loginResponseCallback = (response: IToken)=> {
      this.$cookies.putObject('authToken', response);
      this.DataService.setAuthToken(response);
      this.$state.go('app.myOrdersPage');
    }
  }

  angular.module('employees').controller('SigninCtrl', SigninCtrl);
}
