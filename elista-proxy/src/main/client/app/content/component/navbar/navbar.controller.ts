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

    // @ngInject
    constructor(private $translatePartialLoader: ng.translate.ITranslatePartialLoaderService) {
      this.$translatePartialLoader.addPart('main');
      this.$translatePartialLoader.addPart('icons');

    }

    private formVisibleAfterAdd(hideVariable) {
      this.inputContainerVisible = hideVariable;
      this.refreshListAfterAdd({$event: angular.copy(true)});
    }

    public slide() {

      this.inputContainerVisible = !this.inputContainerVisible;
    };

  }

  angular.module('employees').controller('NavbarCtrl', NavbarCtrl);
}
