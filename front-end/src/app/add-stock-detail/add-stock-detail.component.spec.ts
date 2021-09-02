import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddStockDetailComponent } from './add-stock-detail.component';

describe('AddStockDetailComponent', () => {
  let component: AddStockDetailComponent;
  let fixture: ComponentFixture<AddStockDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddStockDetailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddStockDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
