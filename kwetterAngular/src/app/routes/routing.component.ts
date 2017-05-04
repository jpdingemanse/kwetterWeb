import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AppComponent } from './../app.component';
import { ProfilePageComponent } from './../profileView/profile.component';
import { TimelinePageComponent } from './../timelineView/timeline.component';


export const router: Routes = [
    { path: '', redirectTo : 'profile', pathMatch: 'full'},
    { path: 'profile', component: ProfilePageComponent},
    { path: 'timeline', component: TimelinePageComponent}
];

export const Routing: ModuleWithProviders = RouterModule.forRoot(router);