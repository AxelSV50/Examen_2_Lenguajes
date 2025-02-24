import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { HttpProviderService } from '../service/http-provider.service';

@Component({
  selector: 'app-edit-employee',
  templateUrl: './edit-employee.component.html',
  styleUrls: ['./edit-employee.component.scss']
})
export class EditEmployeeComponent implements OnInit {
  editMajorForm: majorForm = new majorForm();

  @ViewChild("majorForm")
  majorForm!: NgForm;

  isSubmitted: boolean = false;
  majorId: any;

  constructor(private toastr: ToastrService, private route: ActivatedRoute, private router: Router,
    private httpProvider: HttpProviderService) { }

  ngOnInit(): void {
    this.majorId = this.route.snapshot.params['majorId'];
    this.getMajorDetailById();
  }

  getMajorDetailById() {
    this.httpProvider.getMajorDetailById(this.majorId).subscribe((data: any) => {
      if (data != null && data.body != null) {
        var resultData = data.body;
        if (resultData) {
          this.editMajorForm.id = resultData.id;
          this.editMajorForm.name = resultData.name;
          this.editMajorForm.code = resultData.code;
        }
      }
    },
      (error: any) => { });
  }

  EditMajor(isValid: any) {
    this.isSubmitted = true;
    if (isValid) {
      this.httpProvider.saveMajor(this.editMajorForm).subscribe(async data => {
          this.toastr.success("Carrera actualizada correctamente");
          setTimeout(() => {
            this.router.navigate(['/Home']);
          }, 500);
      },
        async error => {
          this.toastr.error("Hubo un erorr al actualizar la carrera");
          setTimeout(() => {
            this.router.navigate(['/Home']);
          }, 500);
        });
    }
  }
}

export class majorForm {
  id: number = 0;
  name: string = "";
  code: string = "";
}
