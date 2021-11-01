import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import { MatTableModule } from '@angular/material/table';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CustomerListComponent } from './overviews/customer-list/customer-list.component';
@NgModule({
  declarations: [AppComponent, CustomerListComponent],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    MatIconModule,
    MatFormFieldModule,
    MatInputModule,
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
