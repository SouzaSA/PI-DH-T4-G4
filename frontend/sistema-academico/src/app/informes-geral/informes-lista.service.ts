import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { tap } from 'rxjs/operators';

import { Informe } from './informes';

@Injectable({
  providedIn: 'root'
})
export class InformesListaService {

  private readonly API = 'http://localhost:3000/informes';

  constructor( private http: HttpClient) { }

  listar() {
    return this.http.get<Informe[]>(this.API)
    .pipe(
      tap(console.log)
    );
  }
}
