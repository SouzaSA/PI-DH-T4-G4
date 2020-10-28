import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DisciplinaOferecidaFormComponent } from './disciplina-oferecida-form.component';

describe('DisciplinaOferecidaFormComponent', () => {
  let component: DisciplinaOferecidaFormComponent;
  let fixture: ComponentFixture<DisciplinaOferecidaFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DisciplinaOferecidaFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DisciplinaOferecidaFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
