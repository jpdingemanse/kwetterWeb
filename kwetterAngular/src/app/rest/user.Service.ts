import { Injectable } from '@angular/core'
import { Http, Response, Headers } from '@angular/http';

import 'rxjs/add/operator/toPromise';

import { User } from './../domain/user';

@Injectable()
export class UserService {
   // private url = "http://192.168.24.46:8080/S61D_RekeningAdministratie/api/Driver/";
    private localurl = "http://localhost:80/kwetterPro2/api/user/"
    constructor(private http : Http){}


    getAllUsers(): Promise<User[]> {
        return this.http.get(this.localurl + "all")
            .toPromise()
            .then(this.extractData);
    }



    private extractData(res: Response) {
        return res.json();
    }
}