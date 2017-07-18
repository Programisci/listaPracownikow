/// <reference path="../../app.module.ts" />

module employees {
    'use strict';

    export interface ITimesheet {
        id: number;
        workplace: string;
        workDate: number;
        startDate: number;
        endDate: number;
        employeeId: number;
    }

}
