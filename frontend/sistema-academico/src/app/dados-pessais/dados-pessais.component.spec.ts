import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DadosPessaisComponent } from './dados-pessais.component';

describe('DadosPessaisComponent', () => {
  let component: DadosPessaisComponent;
  let fixture: ComponentFixture<DadosPessaisComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DadosPessaisComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DadosPessaisComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
