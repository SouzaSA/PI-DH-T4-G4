import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CadastroProfessoresComponent } from './cadastro-professores.component';

describe('CadastroProfessoresComponent', () => {
  let component: CadastroProfessoresComponent;
  let fixture: ComponentFixture<CadastroProfessoresComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CadastroProfessoresComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CadastroProfessoresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
