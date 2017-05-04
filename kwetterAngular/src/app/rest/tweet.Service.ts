import { Injectable } from '@angular/core'
import { Http, Response, Headers } from '@angular/http';

import 'rxjs/add/operator/toPromise';

import { Tweet } from './../domain/tweet';

@Injectable()
export class TweetService {
   // private url = "http://192.168.24.46:8080/S61D_RekeningAdministratie/api/Driver/";
    private localurl = "http://localhost:80/kwetterPro2/api/tweet/"
    constructor(private http : Http){}

    tweetSelected : Tweet;


    getAllTweets(): Promise<Tweet[]> {
        return this.http.get(this.localurl + "all")
            .toPromise()
            .then(this.extractData);
    }

    createNewTweet(tweet : Tweet) : Promise<Tweet> {
        //console.log(JSON.stringify(tweet))
        //var header = new Headers();
        //header.append('Content-Type', 'application/json');
        return this.http.get(this.localurl + "createtweet/" + tweet.tweeter.id + "/" + tweet.message)
                        .toPromise()
                        .then(this.extractData);
    }


    private extractData(res: Response) {
        return res.json();
    }
}