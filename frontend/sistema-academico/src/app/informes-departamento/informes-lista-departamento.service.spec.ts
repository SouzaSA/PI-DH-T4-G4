import { TestBed } from '@angular/core/testing';

import { InformesListaDepartamentoService } from './informes-lista-departamento.service';

describe('InformesListaDepartamentoService', () => {
  let service: InformesListaDepartamentoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(InformesListaDepartamentoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
