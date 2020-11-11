import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DadosProfessorComponent } from './dados-professor.component';

describe('DadosProfesssorComponent', () => {
  let component: DadosProfessorComponent;
  let fixture: ComponentFixture<DadosProfessorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DadosProfessorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DadosProfessorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
