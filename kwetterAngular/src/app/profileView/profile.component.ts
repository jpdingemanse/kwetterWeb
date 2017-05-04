import { Component, OnInit } from '@angular/core'

import { UserService } from './../rest/user.Service';
import { TweetService } from './../rest/tweet.Service';
import { User } from './../domain/user';
import { Tweet } from './../domain/tweet';
import { Ng2Bs3ModalModule } from 'ng2-bs3-modal/ng2-bs3-modal';

@Component({
    selector: 'profile-page',
    templateUrl: './profile.html',
    styleUrls: ['./../app.component.css']
})
export class ProfilePageComponent implements OnInit {
    //getTweets: any;
    private userList: User[];
    private followings: User[];
    private tweetList: Tweet[];
    private ownTweetList: Tweet[];
    private timelineTweetList: Tweet[];
    private idList: number[];
    private user: User;
    private tweet: Tweet;
    private username: string;
    private bio: string;
    private email: string;
    private location: string;
    private website: string;
    private: string;
    private selectedUser: User;
    ngOnInit(): void {
        this.userService.getAllUsers()
            .then(value => this.userList = value)
            .then(value => this.user = value[0])
            .then(user => this.username = this.user.name)
            .then(user => this.bio = this.user.bio)
            .then(user => this.website = this.user.website)
            .then(user => this.email = this.user.email)
            .then(user => this.location = this.user.location)
            .then(user => this.followings = this.user.following)
            .then(() => console.log(this.userList))
            .then(user => this.ownTweetList = this.user.tweets);

        this.tweetService.getAllTweets()
            .then(value => this.tweetList = value)
        for (var key in this.tweetList) {
            if (this.tweetList[key].tweeter.id == this.user.id) {
                this.ownTweetList.push(this.tweetList[key])
            }
        }


        // for (var key1 in this.selectedUser.following){
        //     for (var key2 in this.selectedUser.following[key1].tweets){
        //         this.timelineTweetList.push(this.selectedUser.following[key1].tweets[key2])
        //     }
        // }

        // for (var key in this.tweetList) {
        //     if (this.tweetList[key].tweeter.id == this.user.id) {
        //         this.ownTweetList.push(this.tweetList[key])
        //     }
        // }

    }

    constructor(private userService: UserService, private tweetService: TweetService) { }

    onclickProfile(tbNieuw: User) {
       


}             
  
 

}

