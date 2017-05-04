import { User } from './user';
export class Tweet {
     
        public message: string;
        //public time: number;
        public tweeter: User;
    constructor(){}
       

       setMessage(message: string){
           this.message = message;
       }

       setTweeter(tweeter: User){
           this.tweeter = tweeter;
       }
}