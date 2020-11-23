import {Component, OnInit, ViewChild} from '@angular/core';
import {User} from '../../_models/user';
import {Subscription} from 'rxjs';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {MatSidenav} from '@angular/material/sidenav';
import {ActivatedRoute, Router} from '@angular/router';
import {AuthenticationService} from '../../_services/authentication.service';
import {first} from 'rxjs/operators';

@Component({
  selector: 'app-side-pannel',
  templateUrl: './side-pannel.component.html',
  styleUrls: ['./side-pannel.component.css']
})
export class SidePannelComponent implements OnInit {


  constructor(

              ){};

ngOnInit() {

}

  onSubmit() {



  }
}
