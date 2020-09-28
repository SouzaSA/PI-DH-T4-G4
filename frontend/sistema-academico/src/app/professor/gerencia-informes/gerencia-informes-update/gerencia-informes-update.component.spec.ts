import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GerenciaInformesUpdateComponent } from './gerencia-informes-update.component';

describe('GerenciaInformesUpdateComponent', () => {
  let component: GerenciaInformesUpdateComponent;
  let fixture: ComponentFixture<GerenciaInformesUpdateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GerenciaInformesUpdateComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GerenciaInformesUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
