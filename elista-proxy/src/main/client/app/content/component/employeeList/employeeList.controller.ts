/**
 * Created by Damian on 11.05.2017.
 */
/// <reference path="../../app.module.ts" />

module employees {
    'use strict';


    export class EmployeeListCtrl {

        employees: IEmployee[] = [];
        public onSelectEmployee: ($event) => void;
        public newList: boolean;
        private newEmployee: boolean;
        arrayEmployee: Array<IEmployee>;
        public showList: boolean = true;


        // @ngInject
        constructor(private $translatePartialLoader: ng.translate.ITranslatePartialLoaderService,
                    private EmployeeBackService: IEmployeeBackService,
                    private $timeout: ng.ITimeoutService) {
           // this.init();
            this.$translatePartialLoader.addPart('icons');
            this.$translatePartialLoader.addPart('search');
            this.init();
        }

        public $onChanges(changesObj) {
            /*przy zmianie onChange wyłapuje co się zmienia w current value jest nowa wartość*/
            console.log("z rodzica po bindingu newEmployee usunięcia przychodzi wartość: " + changesObj.newEmployee.currentValue)
            if (changesObj && changesObj.newEmployee && changesObj.newEmployee.currentValue) {
                this.newList = changesObj.newEmployee.currentValue;
                this.$timeout(() => {  /*timeout żeby powracało do wartości wyjściowej*/
                    this.newList = false;
                    this.init();
                });
            }
        };

        public selectEmployeeId(employeeId: number) {
            console.log("wysyłam id z dziecka do rodzica selectEmployeId ", employeeId);
            this.onSelectEmployee({$event: angular.copy(employeeId)});
        };

        private init() {
            this.EmployeeBackService.getEmployee().then(this.getEmployeeCallBack);
        }

        private getEmployeeCallBack = (res: Array<IEmployee>) => {
            this.arrayEmployee = res;
        };

    }

    angular.module('employees').controller('EmployeeListCtrl', EmployeeListCtrl);
}
