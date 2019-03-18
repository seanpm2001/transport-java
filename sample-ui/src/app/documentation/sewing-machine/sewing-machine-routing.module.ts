import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';


const sewingMachineRoutes: Routes = [
    {path: '', component: HomeComponent, pathMatch: 'true'},
    // {path: 'ts/importing', component: TsImportingComponent, pathMatch: 'true'},
];

@NgModule({
    imports: [RouterModule.forChild(sewingMachineRoutes)],
    exports: [RouterModule]
})
export class SewingMachineRoutingModule {
}