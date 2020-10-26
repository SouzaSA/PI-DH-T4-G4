import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SalaFormComponent } from './sala-form.component';

describe('SalaFormComponent', () => {
  let component: SalaFormComponent;
  let fixture: ComponentFixture<SalaFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SalaFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SalaFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
