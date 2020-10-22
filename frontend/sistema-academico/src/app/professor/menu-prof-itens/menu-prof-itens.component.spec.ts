import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuProfItensComponent } from './menu-prof-itens.component';

describe('MenuProfItensComponent', () => {
  let component: MenuProfItensComponent;
  let fixture: ComponentFixture<MenuProfItensComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MenuProfItensComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuProfItensComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
