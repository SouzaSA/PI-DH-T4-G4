import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GerenciaInformesCreateComponent } from './gerencia-informes-create.component';

describe('GerenciaInformesCreateComponent', () => {
  let component: GerenciaInformesCreateComponent;
  let fixture: ComponentFixture<GerenciaInformesCreateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GerenciaInformesCreateComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GerenciaInformesCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
