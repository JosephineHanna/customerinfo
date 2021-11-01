import { Component, Injector, OnInit, ViewChild } from '@angular/core';
import { FormControl } from '@angular/forms';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { UntilDestroy, untilDestroyed } from '@ngneat/until-destroy';
import { Customer } from 'src/app/model/customer';
import { CustomerService } from 'src/app/services/customer.service';

@UntilDestroy()
@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css'],
})
export class CustomerListComponent implements OnInit {
  protected router: Router;
  readonly columnPhone = 'phone';
  readonly columnName = 'name';
  readonly columnCountry = 'country';
  readonly columnState = 'state';

  dataSource = new MatTableDataSource<Customer>();

  pageSize = [10, 20, 50, 100];

  totalCount: number;

  @ViewChild(MatSort, { static: true })
  protected sort: MatSort;

  @ViewChild(MatPaginator, { static: true })
  protected paginator: MatPaginator;

  readonly displayedColumns: string[] = ['name', 'phone', 'country', 'state'];

  countryFilter = new FormControl();
  stateFilter = new FormControl();

  filteredValues = { country: '', state: '' };

  constructor(private customerService: CustomerService, protected injector: Injector) {
    this.router = injector.get(Router);
  }

  ngOnInit(): void {
    this.dataSource.sortingDataAccessor = (obj: any, property: string) => this.getProperty(obj, property);
    this.dataSource.sort = this.sort;
    if (this.paginator !== undefined) {
      this.dataSource.paginator = this.paginator;
    }
    this.loadList();
    this.countryFilter.valueChanges.subscribe((countryFilterValue) => {
      this.filteredValues.country = countryFilterValue;
      this.dataSource.filter = JSON.stringify(this.filteredValues);
    });

    this.stateFilter.valueChanges.subscribe((stateFilterValue) => {
      this.filteredValues.state = stateFilterValue;
      this.dataSource.filter = JSON.stringify(this.filteredValues);
    });

    this.dataSource.filterPredicate = this.customFilterPredicate();
  }

  customFilterPredicate() {
    const myFilterPredicate = function (data: Customer, filter: string): boolean {
      const searchString = JSON.parse(filter);
      return (
        data.country.toString().trim().indexOf(searchString.country) !== -1 &&
        (data.state.toString().trim().toLowerCase() === searchString.state.toLowerCase() || searchString.state.toLowerCase() === '')
      );
    };
    return myFilterPredicate;
  }

  getProperty = (obj: any, path: string) => path.split('.').reduce((o, p) => o[p], obj);

  loadList(): void {
    this.customerService
      .findAll()
      .pipe(untilDestroyed(this))
      .subscribe((data: Customer[]) => {
        this.dataSource.data = data;
        this.totalCount = data.length;
      });
  }
}
