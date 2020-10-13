import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CadastroAdministradoresComponent } from './cadastro-administradores.component';

describe('CadastroAdministradoresComponent', () => {
  let component: CadastroAdministradoresComponent;
  let fixture: ComponentFixture<CadastroAdministradoresComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CadastroAdministradoresComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CadastroAdministradoresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
