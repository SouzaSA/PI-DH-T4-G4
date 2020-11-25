import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuAlunoItensComponent } from './menu-aluno-itens.component';

describe('MenuAlunoItensComponent', () => {
  let component: MenuAlunoItensComponent;
  let fixture: ComponentFixture<MenuAlunoItensComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MenuAlunoItensComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuAlunoItensComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
