/**
 * Created by Damian on 11.05.2017.
 */
/// <reference path="../../app.module.ts" />

module employees {
    'use strict';

    export class TimesheetCtrl {

        user: IUser = {};
        myDate: any;
        employeeId = this.$stateParams.id;
        timesheetArray: Array<ITimesheet> = [];
        timesheetEmployeeArray: Array<ITimesheet> = [];
        formContainerVisible = false;
        timesheetNew: ITimesheet;


        // @ngInject
        constructor(private $translatePartialLoader: ng.translate.ITranslatePartialLoaderService,
                    private TimesheetService: ITimesheetService,
                    private $stateParams: ActorsStateParams) {
            this.$translatePartialLoader.addPart('timesheet');
            this.$translatePartialLoader.addPart('icons');
            this.init();

        }
        private init() {
            this.timesheetArray = [];
            this.timesheetEmployeeArray = [];
            this.TimesheetService.getTimesheet().then(this.getTimesheetCallBack);

        };
        private getTimesheetCallBack = (res: Array<ITimesheet>) => {
            this.timesheetArray = res;

            for (var i = 0; i < this.timesheetArray.length; i++){
                if (this.timesheetArray[i].employeeId == this.employeeId){
                    this.timesheetArray[i].startDate =  this.timesheetArray[i].startDate * 1000;
                    this.timesheetArray[i].endDate =  this.timesheetArray[i].endDate * 1000;
                    this.timesheetArray[i].workDate =  this.timesheetArray[i].workDate * 1000;
                    this.timesheetEmployeeArray.push(this.timesheetArray[i]);
                }
            }

        };

        private saveTimesheet = () => {
            this.timesheetNew.employeeId = this.employeeId;
            this.timesheetNew.startDate = this.timesheetNew.startDate / 1000;
            this.timesheetNew.endDate = this.timesheetNew.endDate / 1000;
            this.timesheetNew.workDate = this.timesheetNew.workDate / 1000;
            this.TimesheetService.saveTimesheet(this.timesheetNew).then(this.saveTimesheetCallBack);
        };

        private saveTimesheetCallBack = (response) => {
            this.formContainerVisible = false;
            this.timesheetNew.workDate = null;
            this.timesheetNew.startDate = null;
            this.timesheetNew.endDate = null;
            this.timesheetNew.workplace = defaultStatus;
            this.init();
        };

        private deleteTimesheetId(id: number) {
            this.TimesheetService.deleteTimesheetDetail(id).then(this.timesheetDeleteCallBack);

        };

        private timesheetDeleteCallBack = (res) => {
            this.init();
        };

        private back() {
            this.formContainerVisible = false;
            this.timesheetNew.workDate = null;
            this.timesheetNew.startDate = null;
            this.timesheetNew.endDate = null;
            this.timesheetNew.workplace = defaultStatus;
        };

        private formContainer() {

            this.formContainerVisible = !this.formContainerVisible;

        };

    }

    angular.module('employees').controller('TimesheetCtrl', TimesheetCtrl);
}
