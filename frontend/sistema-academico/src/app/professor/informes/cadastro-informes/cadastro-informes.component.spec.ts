import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CadastroInformesComponent } from './cadastro-informes.component';

describe('CadastroInformesComponent', () => {
  let component: CadastroInformesComponent;
  let fixture: ComponentFixture<CadastroInformesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CadastroInformesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CadastroInformesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
