/// <reference path="../../app.module.ts" />

module employees {
    'use strict';



    export class UserCtrl {

        private refreshEmployee: boolean = false;
        public employeDetail: IEmployee;
        public showList: boolean = true;

        // @ngInject
        constructor(private EmployeeBackService: IEmployeeBackService,
                    private $timeout: ng.ITimeoutService) {
            this.EmployeeBackService.getEmployeeDetail(localStorage.getItem("token")).then(this.getEmployeeCallBack)
            console.log("Token:     " + localStorage.getItem("token"));
        }

        private getEmployeeCallBack = (res: IEmployee) => {
            this.employeDetail = res;
        };

        public toggleShow(){
            console.log("czesc");
            this.showList = !this.showList
        }

        private refreshAfterAdd(hideVariable) {
            this.refreshEmployee = true;
        }


        private refreshEmployeeList(employee: number) {
            this.refreshEmployee = true;
            this.$timeout(() => {  /*timeout żeby powracało do wartości wyjściowej*/
                this.refreshEmployee = false;

            });


        }

    }

    angular.module('employees').controller('UserCtrl', UserCtrl);
}
