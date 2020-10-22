import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GerenciaNotasComponent } from './gerencia-notas.component';

describe('GerenciaNotasComponent', () => {
  let component: GerenciaNotasComponent;
  let fixture: ComponentFixture<GerenciaNotasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GerenciaNotasComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GerenciaNotasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
