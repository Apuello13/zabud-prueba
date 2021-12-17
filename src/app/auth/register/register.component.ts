import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from 'src/app/core/service/user.service';
import { GenericValidateField } from 'src/app/core/utils/genericValidateField';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html'
})
export class RegisterComponent implements GenericValidateField{
  registerForm!: FormGroup;
  constructor(
    private _auth: AuthService,
    private _user: UserService,
    private router: Router,
    private formBuilder: FormBuilder
  ) {
    this.initForm();
  }

  initForm() {
    this.registerForm = this.formBuilder.group({
      id: [0],
      nombre: ['', Validators.required],
      username: ['', Validators.required],
      password: ['', Validators.required],
    });
  }

  register() {
    this._auth.register(this.registerForm.value).subscribe(
      (response) => {
        this._user.saveUser(response);
        this.router.navigateByUrl('/home');
      },
      (badRequest) => {
        alert(badRequest);
      }
    );
  }

  validateField(key: string) {
    return (
      (this.registerForm.get(key)?.dirty || this.registerForm.get(key)?.touched) &&
      this.registerForm.get(key)?.invalid
    );
  }
}
