import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CadastroDisciplinaOferecidaComponent } from './cadastro-disciplina-oferecida.component';

describe('CadastroDisciplinaOferecidaComponent', () => {
  let component: CadastroDisciplinaOferecidaComponent;
  let fixture: ComponentFixture<CadastroDisciplinaOferecidaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CadastroDisciplinaOferecidaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CadastroDisciplinaOferecidaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
