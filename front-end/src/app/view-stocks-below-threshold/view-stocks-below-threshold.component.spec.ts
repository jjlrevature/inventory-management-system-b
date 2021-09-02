import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewStocksBelowThresholdComponent } from './view-stocks-below-threshold.component';

describe('ViewStocksBelowThresholdComponent', () => {
  let component: ViewStocksBelowThresholdComponent;
  let fixture: ComponentFixture<ViewStocksBelowThresholdComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewStocksBelowThresholdComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewStocksBelowThresholdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
