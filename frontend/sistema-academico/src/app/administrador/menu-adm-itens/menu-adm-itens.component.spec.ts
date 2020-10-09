import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuAdmItensComponent } from './menu-adm-itens.component';

describe('MenuAdmItensComponent', () => {
  let component: MenuAdmItensComponent;
  let fixture: ComponentFixture<MenuAdmItensComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MenuAdmItensComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuAdmItensComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
