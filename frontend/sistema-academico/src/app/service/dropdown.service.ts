import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { EstadoBr } from './../shared/model/estado-br.model';
import { Cidade } from '../shared/model/cidade';
import { map } from '../../../node_modules/rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class DropdownService {
  constructor(private http: HttpClient) {}

  getEstadosBr() {
    return this.http.get<EstadoBr[]>('https://servicodados.ibge.gov.br/api/v1/localidades/estados');
  }

  getCidades(idEstado: number) {
    return this.http.get<Cidade[]>(`https://servicodados.ibge.gov.br/api/v1/localidades/estados/${idEstado}/municipios`);
    // .pipe(
    //   // tslint:disable-next-line:triple-equals
    //   map((cidades: Cidade[]) => cidades.filter(c => c.estado == idEstado))
    // );
  }
}
