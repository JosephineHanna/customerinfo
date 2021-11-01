import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { REST_LINKS } from '../constants/rest-links';
import { Customer } from '../model/customer';

@Injectable({
  providedIn: 'root',
})
export class CustomerService {
  constructor(protected http: HttpClient) {}

  public findAll(): Observable<Customer[]> {
    return this.http.get<Customer[]>(environment.apiUrl + REST_LINKS.customer);
  }
}
