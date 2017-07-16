export class RoutineDto {
    idOrigin: number; // database distinct id
    id: number; // can by duplicated in DB
    workfrom: string;
    workto: string;
    intervalfrom: string;
    intervalto: string;
    pnDaynamesByDayofweek: PnDaynamesDto; // convert to DTO !
    pnDaynamesPeriodTo?: PnDaynamesDto; // empty by default

    intervalActive: boolean; // aditional variable
}

export class PnDaynamesDto {
    id: number;
    name: string;
    countday: number;
    orderby: number;
    shortName: string;
    days: string;

}

/*export class RoutineListsDto{
    lists: RoutineDto[];

}*/

export class RsHolder{
    id : number;
    str : string;

    constructor(id: number, str: string) {
        this.id = id;
        this.str = str;
    }
}

