/// <reference path="../app.module.ts" />

module employees {
    'use strict';

    export interface IEmployee {
        id: number;
        name: string;
        lastname: string;
        position: string;
        avatarPath: string;
        role: string;
        cashPerHour: number;
        passwd: string;
        login: string;
    }

}
