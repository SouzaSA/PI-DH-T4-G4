import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CadastroSalasComponent } from './cadastro-salas.component';

describe('CadastroSalasComponent', () => {
  let component: CadastroSalasComponent;
  let fixture: ComponentFixture<CadastroSalasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CadastroSalasComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CadastroSalasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
