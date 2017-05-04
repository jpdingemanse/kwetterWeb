import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { Routing } from './routes/routing.component';
import { Ng2Bs3ModalModule } from 'ng2-bs3-modal/ng2-bs3-modal';

import { UserService } from './rest/user.Service';
import { TweetService } from './rest/tweet.Service';

import { AppComponent } from './app.component';
import { NavbarTopComponent } from './navbar/navbarTop.component';
import { NavbarLeftComponent } from './navbar/navbarLeft.component';
import { ProfilePageComponent } from "app/profileView/profile.component";
import { TimelinePageComponent } from "app/timelineView/timeline.component";

@NgModule({
  declarations: [
    AppComponent,
    NavbarTopComponent,
    NavbarLeftComponent,
    ProfilePageComponent,
    TimelinePageComponent
   
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    Routing,
    Ng2Bs3ModalModule
    
  ],
  providers: [ 
    UserService,
   TweetService],
  bootstrap: [AppComponent],
 
})
export class AppModule { }
