import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DadosAdministradorComponent } from './dados-administrador.component';

describe('DadosAdministradorComponent', () => {
  let component: DadosAdministradorComponent;
  let fixture: ComponentFixture<DadosAdministradorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DadosAdministradorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DadosAdministradorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
