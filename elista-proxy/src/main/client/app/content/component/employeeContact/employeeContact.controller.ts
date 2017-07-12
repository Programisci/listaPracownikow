/**
 * Created by Damian on 11.05.2017.
 */
/// <reference path="../../app.module.ts" />

module employees {
    'use strict';

    export class EmployeeContactCtrl {

        employeeId = this.$stateParams.id;
        contact: IContact;
        allContacts: Array<IContact> = [];
        employeeContact: Array<IContact> = [];
        formContainerVisible = false;


        // @ngInject
        constructor(private $translatePartialLoader: ng.translate.ITranslatePartialLoaderService,
                    private EmployeeBackService: IEmployeeBackService,
                    private ContactTypeService: IContactTypeService,
                    private $stateParams: ActorsStateParams,
                    private $timeout: ng.ITimeoutService
        ) {
            this.init();
            this.$translatePartialLoader.addPart('contact');
            this.$translatePartialLoader.addPart('icons');
        }

        private init() {
            this.allContacts = [];
            this.employeeContact = [];
                this.ContactTypeService.getContact().then(this.getContactsCallBack);
        }

        private getContactsCallBack = (res: Array<IContact>) => {
            this.allContacts = res;

            for (var i = 0; i< this.allContacts.length; i++){
                if (this.allContacts[i].employeeId == this.employeeId){
                    this.employeeContact.push(this.allContacts[i]);
                }
            }
        };

        private deleteContactId(id: number) {
            this.ContactTypeService.deleteContactDetail(id).then(this.contactDeleteCallBack);

        };

        private contactDeleteCallBack = (res: IContact) => {
            this.init();
        };

        private saveContact = () => {
            this.contact.employeeId = this.employeeId;
                this.ContactTypeService.saveContact(this.contact).then(this.saveContactCallBack);
        };

        private saveContactCallBack = (response) => {
            this.formContainerVisible = false;
            this.init();
            this.contact.contactValue = defaultStatus;
            this.contact.contactType = defaultStatus;
        };

        private back() {
            this.formContainerVisible = false;
        }

        private formContainer() {
            this.formContainerVisible = !this.formContainerVisible;
        };


    }

    angular.module('employees').controller('EmployeeContactCtrl', EmployeeContactCtrl);
}
