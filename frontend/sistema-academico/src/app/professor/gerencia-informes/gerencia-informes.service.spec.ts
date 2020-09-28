import { TestBed } from '@angular/core/testing';

import { GerenciaInformesService } from './gerencia-informes.service';

describe('GerenciaInformesService', () => {
  let service: GerenciaInformesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GerenciaInformesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
