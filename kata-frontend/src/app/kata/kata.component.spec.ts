import { ComponentFixture, TestBed } from '@angular/core/testing';
import { KataComponent } from './kata.component';

describe('FooBarQuixComponent', () => {
  let component: KataComponent;
  let fixture: ComponentFixture<KataComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [KataComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(KataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
