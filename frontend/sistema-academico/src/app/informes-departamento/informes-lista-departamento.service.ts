import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { tap } from 'rxjs/operators';

import { Informe } from '../informes-geral/informes';

@Injectable({
  providedIn: 'root'
})
export class InformesListaDepartamentoService {

  private readonly API = 'http://localhost:3000/informes';
  departamento: string = '';

  constructor( private http: HttpClient) { }

  listar() {
    return this.http.get<Informe[]>(this.API)
    .pipe(
      tap()
    );
  }

  changeDepartamento(dpto: string) {
    this.departamento = dpto;
  }
}
