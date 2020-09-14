import { TestBed } from '@angular/core/testing';

import { InformesListaService } from './informes-lista.service';

describe('InformesListaService', () => {
  let service: InformesListaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(InformesListaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
