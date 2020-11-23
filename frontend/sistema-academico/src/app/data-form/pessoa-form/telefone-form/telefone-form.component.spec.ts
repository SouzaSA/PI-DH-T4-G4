import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TelefoneFormComponent } from './telefone-form.component';

describe('TelefoneFormComponent', () => {
  let component: TelefoneFormComponent;
  let fixture: ComponentFixture<TelefoneFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TelefoneFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TelefoneFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
