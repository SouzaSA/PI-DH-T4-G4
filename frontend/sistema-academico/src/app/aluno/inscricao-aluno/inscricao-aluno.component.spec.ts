import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InscricaoAlunoComponent } from './inscricao-aluno.component';

describe('InscricaoAlunoComponent', () => {
  let component: InscricaoAlunoComponent;
  let fixture: ComponentFixture<InscricaoAlunoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InscricaoAlunoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InscricaoAlunoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
