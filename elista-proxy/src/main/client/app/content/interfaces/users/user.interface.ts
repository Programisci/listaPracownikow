/// <reference path="../../app.module.ts" />
module employees {
  export interface IUser extends ISlimUser {
    passwd?: string;
    login?: string;
    employeeId?: number;
  }
}