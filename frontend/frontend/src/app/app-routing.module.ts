import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CustomerListComponent } from './overviews/customer-list/customer-list.component';

const routes: Routes = [
  {
    path: '',
    component: CustomerListComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { relativeLinkResolution: 'legacy', useHash: true })],
  exports: [RouterModule],
})
export class AppRoutingModule {}
