/// <reference path="../../app.module.ts" />

module employees {
    'use strict';

    export interface IEmployeeDetail<T> {
        id: number;
        name: string;
        lastname: string;
        avatarPath: string;
        position: string;
        contacts: Array<T>;
    }

}
