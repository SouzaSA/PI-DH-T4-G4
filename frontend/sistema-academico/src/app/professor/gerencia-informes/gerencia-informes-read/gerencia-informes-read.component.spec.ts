import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GerenciaInformesReadComponent } from './gerencia-informes-read.component';

describe('GerenciaInformesReadComponent', () => {
  let component: GerenciaInformesReadComponent;
  let fixture: ComponentFixture<GerenciaInformesReadComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GerenciaInformesReadComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GerenciaInformesReadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
