import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from 'src/app/core/service/user.service';
import { GenericValidateField } from 'src/app/core/utils/genericValidateField';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html'
})
export class LoginComponent implements GenericValidateField{
  loginForm!: FormGroup;
  constructor(
    private formBuilder: FormBuilder, 
    private _auth: AuthService,
    private _user : UserService,
    private router : Router
  ) {
    this.initForm();
  }

  initForm() {
    this.loginForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required],
    });
  }

  login() {
    this._auth.login(this.loginForm.value)
      .subscribe((response) => {
        this._user.saveUser(response);
        this.router.navigateByUrl('/home');
      }, badRequest => {
        alert(badRequest);
      })
  }

  validateField(key: string) {
    return (
      (this.loginForm.get(key)?.dirty || this.loginForm.get(key)?.touched) &&
      this.loginForm.get(key)?.invalid
    );
  }
}
