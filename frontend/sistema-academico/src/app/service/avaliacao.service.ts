import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { environment } from './../../environments/environment';

@Injectable({
  providedIn: 'root',
})
export class AvaliacaoService {
  apiUrl = `${environment.URLSERVIDOR}`+'avaliacao';
  constructor(private httpClient: HttpClient) {}

  listar() {
    return this.httpClient.get(this.apiUrl);
  }

  adicionar(avaliacao: any) {
    return this.httpClient.post(this.apiUrl, avaliacao);
  }

  excluir(id: number) {
    return this.httpClient.delete(this.apiUrl + '/' + id);
  }

  atualizar(avaliacao: any) {
    return this.httpClient.put(this.apiUrl + '/' + avaliacao.id, avaliacao);
  }
}
