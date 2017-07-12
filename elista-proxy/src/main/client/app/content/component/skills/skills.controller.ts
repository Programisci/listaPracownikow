// /**
//  * Created by Damian on 11.05.2017.
//  */
// /// <reference path="../../app.module.ts" />
//
// module employees {
//     'use strict';
//
//     export class SkillCtrl {
//
//         employeeId = this.$stateParams.id;
//         skillsArray: Array<ISkills>;
//         skillsByName: Array<ISkillsFindByName> = [];
//         skillsByDesc: Array<ISkillsFindByDesc> = [];
//         addNewSkill: ISkills;
//         public hideThis: boolean;
//         public hideThisDesc: boolean;
//         formContainerVisible = false;
//
//         // @ngInject
//         constructor(private $translatePartialLoader: ng.translate.ITranslatePartialLoaderService,
//                     private SkillsService: ISkillsService,
//                     private $stateParams: ActorsStateParams
//         ) {
//             this.init();
//             this.$translatePartialLoader.addPart('icons');
//             this.$translatePartialLoader.addPart('skills');
//         }
//         private init() {
//             this.SkillsService.getSkills(this.employeeId).then(this.getSkillsCallBack);
//         };
//
//         private getSkillsCallBack = (res: Array<ISkills>) => {
//             this.skillsArray = res;
//         };
//
//         private deleteSkillsId(skillId: number) {
//             this.SkillsService.deleteSkills(this.employeeId, skillId).then(this.deleteSkillsCallBack);
//
//         };
//
//         private deleteSkillsCallBack = (res: IEmployee) => {
//             this.init();
//         };
//
//         private saveSkills = () => {
//             if (this.addNewSkill != null) {
//                 this.SkillsService.saveSkills(this.employeeId, this.addNewSkill).then(this.saveSkillCallBack);
//             }
//         };
//
//         private saveSkillCallBack = (response) => {
//             this.formContainerVisible = false;
//             this.init();
//             this.addNewSkill.skillName = defaultStatus;
//             this.addNewSkill.description = defaultStatus;
//         };
//
//         private registerKeyPressForSearchName(){
//             this.SkillsService.getSkillsByName(this.addNewSkill.skillName).then(this.getSkillsByNameCallBack);
//             console.log(this.addNewSkill.skillName);
//             this.hideThis = false;
//         };
//
//         private getSkillsByNameCallBack = (res: Array<ISkillsFindByName>) => {
//             this.skillsByName = res;
//         };
//
//         private fillTextBoxName(name: string){
//             this.addNewSkill.skillName = name;
//             this.hideThis = true;
//         };
//
//         private registerKeyPressForSearchDesc(){
//             this.SkillsService.getSkillsByDescription(this.addNewSkill.description).then(this.getSkillsByDescCallBack);
//             console.log(this.addNewSkill.skillName);
//             this.hideThisDesc = false;
//         };
//
//         private getSkillsByDescCallBack = (res: Array<ISkillsFindByDesc>) => {
//             this.skillsByDesc = res;
//         };
//
//         private fillTextBoxDesc(name: string){
//             this.addNewSkill.description = name;
//             this.hideThisDesc = true;
//         };
//
//         private back() {
//             this.formContainerVisible = false;
//             this.addNewSkill.skillName = defaultStatus;
//             this.addNewSkill.description = defaultStatus;
//         };
//
//         private formcontainer() {
//
//             this.formContainerVisible = !this.formContainerVisible;
//             this.addNewSkill.skillName = defaultStatus;
//             this.addNewSkill.description = defaultStatus;
//         };
//
//     }
//
//     angular.module('employees').controller('SkillCtrl', SkillCtrl);
// }
/**
 * Created by Damian on 11.05.2017.
 */
/// <reference path="../../app.module.ts" />

module employees {
    'use strict';

    export class SkillCtrl {

        user: IUser = {};

        // @ngInject
        constructor() {


        }

    }

    angular.module('employees').controller('SkillCtrl', SkillCtrl);
}