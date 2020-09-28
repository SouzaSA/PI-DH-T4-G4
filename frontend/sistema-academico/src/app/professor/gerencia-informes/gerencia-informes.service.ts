import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Informe } from './gerencia-informes.model';
import { Observable } from 'rxjs';
import { MatSnackBar } from '@angular/material/snack-bar';

@Injectable({
  providedIn: 'root',
})
export class GerenciaInformesService {
  baseUrl = 'http://localhost:3000/informes';

  constructor(private http: HttpClient, private snackBar: MatSnackBar) {}

  showMessage(msg: string): void {
    this.snackBar.open(msg, 'X', {
      duration: 2000,
      horizontalPosition: 'right',
      verticalPosition: 'top',
    });
  }

  create(informe: Informe): Observable<Informe> {
    return this.http.post<Informe>(this.baseUrl, informe);
  }

  read(): Observable<Informe[]> {
    return this.http.get<Informe[]>(this.baseUrl);
  }

  readById(id: number): Observable<Informe> {
    const url = `${this.baseUrl}/${id}`;
    return this.http.get<Informe>(url);
  }

  update(informe: Informe): Observable<Informe> {
    const url = `${this.baseUrl}/${informe.id}`;
    return this.http.put<Informe>(url, informe);
  }

  delete(id: number): Observable<Informe> {
    const url = `${this.baseUrl}/${id}`;
    return this.http.delete<Informe>(url);
  }
}
