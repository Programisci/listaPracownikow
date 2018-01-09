/// <reference path="../../app.module.ts" />

module employees {
    'use strict';

    export interface IEmployeeDetail<T> {
        id: number;
        name: string;
        lastname: string;
        position: string;
        avatarPath: string;
        role: string;
        cashPerHour: number;
        passwd: string;
        login: string;
        contacts: Array<T>;
    }

}
