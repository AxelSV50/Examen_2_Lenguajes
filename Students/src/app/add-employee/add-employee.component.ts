import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { HttpProviderService } from '../service/http-provider.service';

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.scss']
})
export class AddEmployeeComponent implements OnInit {
  addMajorForm: majorForm = new majorForm();

  @ViewChild("majorForm")
  majorForm!: NgForm;

  isSubmitted: boolean = false;

  constructor(private router: Router, private httpProvider: HttpProviderService, private toastr: ToastrService) { }

  ngOnInit(): void {
  }

  AddMajor(isValid: any) {
    this.isSubmitted = true;
    if (isValid) {
      this.httpProvider.saveMajor(this.addMajorForm).subscribe(async data => {
        this.toastr.success("Carrera ingresada correctamente");
          setTimeout(() => {
            this.router.navigate(['/Home']);
          }, 500);
      },
        async error => {
          this.toastr.error("Hubo un error al ingresar la carrera");
          setTimeout(() => {
            this.router.navigate(['/Home']);
          }, 500);
        });
    }
  }

}

export class majorForm {
  name: string = "";
  code: string = "";
}