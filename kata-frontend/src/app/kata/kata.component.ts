import {Component, ElementRef, ViewChild} from '@angular/core';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import {KataService} from "../services/kata.service";
import {NgIf} from "@angular/common";
import {MatDialog} from "@angular/material/dialog";
import {MatButtonModule} from "@angular/material/button";

declare var bootstrap: any;


@Component({
    selector: 'app-kata',
    templateUrl: './kata.component.html',
    standalone: true,
    imports: [
        ReactiveFormsModule,
        NgIf,
        MatButtonModule
    ],
    styleUrls: ['./kata.component.css']
})
export class KataComponent {

    @ViewChild('myModal') myModal!: ElementRef;

    kataForm: FormGroup;
    result: string | undefined;

    constructor(private fb: FormBuilder, private kataService: KataService) {
        this.kataForm = this.fb.group({
            number: ['', [Validators.required, Validators.min(0), Validators.max(100)]]
        });
    }

    onSubmit() {
        if (this.kataForm.valid) {
            const number = this.kataForm.value.number;
            this.kataService.transformNumber(number).subscribe((data) => {
                this.result = data;
            });
        }
    }

    openModal() {
        const modal = bootstrap.Modal.getOrCreateInstance(this.myModal.nativeElement);
        modal.show();
    }
}
