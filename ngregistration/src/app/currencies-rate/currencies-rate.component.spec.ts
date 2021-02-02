import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CurrenciesRateComponent } from './currencies-rate.component';

describe('CurrenciesRateComponent', () => {
  let component: CurrenciesRateComponent;
  let fixture: ComponentFixture<CurrenciesRateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CurrenciesRateComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CurrenciesRateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
