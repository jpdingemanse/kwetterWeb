import { Tweet } from "app/domain/tweet";


export class User {


    constructor(
            public id: number,
            public name: string,
            public email: string,
            public location: string,
            public bio: string,
            public website: string,
            public tweets: Tweet[],
           public following: User[]
    ) {

    }

    setTweets(tweets: Tweet[]) {
        this.tweets = tweets;
    }
    
}