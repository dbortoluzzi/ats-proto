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

  search(query: string) {
    const params = new HttpParams().append('query', query);
    return this.http.get<any>(environment.api.atm.search, {params: params});
  }
}
