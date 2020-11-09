import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DadosProfesssorComponent } from './dados-professsor.component';

describe('DadosProfesssorComponent', () => {
  let component: DadosProfesssorComponent;
  let fixture: ComponentFixture<DadosProfesssorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DadosProfesssorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DadosProfesssorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
