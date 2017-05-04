import { Component, OnInit } from '@angular/core'

import { TweetService } from './../rest/tweet.Service';
import { Tweet } from './../domain/tweet';
import { UserService } from './../rest/user.Service';
import { User } from './../domain/user';

@Component({
    selector : 'timeline-page',
    templateUrl : './timeline.html',
    styleUrls: ['./../app.component.css']
})
export class TimelinePageComponent implements OnInit {
    tweetValue:string = '';
    private tweetList : Tweet[];
    private selectedTweet : Tweet;
    private userList : User[];
    private ownTweetList : Tweet[];
    private timelineTweetList : Tweet[];
    private idList : number[];
    private user : User;
    private tweet : Tweet;
    private username: string;
    private bio: string;
    private email: string;
    private location: string;
    private website: string;
    //private : string;
    private following: number;
    private tweetsCount: number;
    private selectedUser : User;
        ngOnInit(): void {
         
            this.userService.getAllUsers()
                            .then(value => this.userList = value)
                            .then(value => this.user = value[0])
                            .then(user => this.username = this.user.name)
                             .then(user => this.bio = this.user.bio)
                              .then(user => this.website = this.user.website)
                            .then(user => this.email = this.user.email)
                            .then(user => this.location = this.user.location)
                            .then(user => this.following = this.user.following.length)
                            .then(user => this.tweetsCount = this.user.tweets.length)
                            .then (
                                
                            )
                            .then(() => console.log(this.userList))

                            this.tweetService.getAllTweets()
                                .then(value => this.timelineTweetList = value)
                            .then(() => console.log(this.timelineTweetList));
    for (var key in this.timelineTweetList) {
        if (this.tweetList[key].tweeter.id == this.user.id) {
            this.ownTweetList.push(this.tweetList[key])
        }
        this.tweetsCount = this.ownTweetList.length
    }

   
    
    
        }
     constructor(private tweetService : TweetService, private userService: UserService){}
     
     onclickNewTweet(tbNieuw : string){
            //this.selectedTweet = value;
            this.selectedTweet = new Tweet();
            this.tweetsCount = this.user.tweets.length
            this.selectedTweet.message = tbNieuw;
            this.selectedTweet.tweeter = this.user;
            
            this.tweetService.createNewTweet(this.selectedTweet)
            .then(value => {console.log(value)})
            // this.timelineTweetList.push(this.selectedTweet)
            // this.tweetValue = null;
            
    }             
     
     
    
        // ngOnInit(): void {
        //     this.tweetService.getAllTweets()
        //                     .then(value => this.tweetList = value)
        //                     .then(() => console.log(this.tweetList))
        // }

   

     


}
