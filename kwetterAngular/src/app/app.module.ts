import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { NavbarTopComponent } from './navbar/navbarTop.component';
import { NavbarLeftComponent } from './navbar/navbarLeft.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarTopComponent,
    NavbarLeftComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
