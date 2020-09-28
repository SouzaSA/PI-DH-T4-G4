import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GerenciaInformesDeleteComponent } from './gerencia-informes-delete.component';

describe('GerenciaInformesDeleteComponent', () => {
  let component: GerenciaInformesDeleteComponent;
  let fixture: ComponentFixture<GerenciaInformesDeleteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GerenciaInformesDeleteComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GerenciaInformesDeleteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
