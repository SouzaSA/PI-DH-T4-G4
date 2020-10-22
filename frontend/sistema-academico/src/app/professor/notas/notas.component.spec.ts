import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NotasComponent } from './notas.component';

describe('GerenciaNotasComponent', () => {
  let component: NotasComponent;
  let fixture: ComponentFixture<NotasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NotasComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NotasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
