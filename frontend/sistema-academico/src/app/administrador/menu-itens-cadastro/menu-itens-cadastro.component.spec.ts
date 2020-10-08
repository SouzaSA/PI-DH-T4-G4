import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuItensCadastroComponent } from './menu-itens-cadastro.component';

describe('MenuItensCadastroComponent', () => {
  let component: MenuItensCadastroComponent;
  let fixture: ComponentFixture<MenuItensCadastroComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MenuItensCadastroComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuItensCadastroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
