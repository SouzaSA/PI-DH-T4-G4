import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DadosAlunoComponent } from './dados-aluno.component';

describe('DadosAlunoComponent', () => {
  let component: DadosAlunoComponent;
  let fixture: ComponentFixture<DadosAlunoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DadosAlunoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DadosAlunoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
