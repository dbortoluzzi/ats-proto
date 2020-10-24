import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable, throwError} from 'rxjs';
import {catchError, retry} from 'rxjs/operators';
import {environment} from './../environments/environment';
import {Atm} from "./model/atm";

@Injectable({
  providedIn: 'root'
})
export class AtmService {
  constructor(private http: HttpClient) {
  }

  search(query: string, page: number, size: number) {
    const params = new HttpParams()
      .append('query', query)
      .append('page', page.toString())
      .append('size', size.toString());
    return this.http.get<any>(environment.api.atm.search, {params: params});
  }
}
