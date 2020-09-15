import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GerenciaInformesComponent } from './gerencia-informes.component';

describe('GerenciaInformesComponent', () => {
  let component: GerenciaInformesComponent;
  let fixture: ComponentFixture<GerenciaInformesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GerenciaInformesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GerenciaInformesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
