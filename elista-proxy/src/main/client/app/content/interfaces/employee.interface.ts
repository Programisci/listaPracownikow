/// <reference path="../app.module.ts" />

module employees {
    'use strict';

    export interface IEmployee {
        id: number;
        name: string;
        lastname: string;
        position: string;
        avatarFilePath: string;
    }

}
