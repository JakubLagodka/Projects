import {ChangeDetectionStrategy, Component, HostBinding, Inject, Input, OnInit, Output} from '@angular/core';
import {Observable, of} from 'rxjs';
import {TranslatorService} from '../_services/translator.service';
import {Parameter} from '../_models/parameter';
import {ParametersService} from '../_services/parameters.service';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import {AppComponent} from '../app.component';
import {ActivatedRoute, Router} from '@angular/router';
import {FormControl, Validators} from '@angular/forms';

@Component({
  selector: 'app-edit-parameters',
  templateUrl: './edit-parameters.component.html',
  styleUrls: ['./edit-parameters.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class EditParametersComponent implements OnInit {
  parameter: Parameter = new Parameter();
  parameters$: Observable<Parameter[]>;
  confirmed = false;
  parameterTypes = [0,1,2,3];
  parameterTypeControl = new FormControl('', Validators.required);
  constructor(public parametersService: ParametersService,
              public translatorService: TranslatorService,
              public dialog: MatDialog,
              private route: ActivatedRoute,
              private router: Router) { }

  ngOnInit(): void {
    this.parameters$ = this.parametersService.getParameters();
  }
  add(parameter: Parameter)
  {
    parameter.modifiable = true;

    if (this.parameterTypeControl.value === 0)
    {
      parameter.typeId = 0;
      parameter.type = 'number';
    }

    else  if (this.parameterTypeControl.value === 1)
    {
      parameter.type = 'double';
      parameter.typeId = 1;
    }

    else  if (this.parameterTypeControl.value === 2)
  {
    parameter.type = 'string';
    parameter.typeId = 2;
  }

    else
    {
      parameter.type = 'boolean';
      parameter.typeId = 3;
    }


    this.parametersService.addParameter(parameter);

    this.parameters$ = this.parametersService.getParameters();
    setTimeout(() => {
      this.parameters$ = this.parametersService.getParameters();
      this.router.navigate(['/edit-parameters']);
    }, 50);
  }

  update(parameter: Parameter)
  {
    this.parametersService.updateParameter(parameter.id, parameter);

    this.parameters$ = this.parametersService.getParameters();
    setTimeout(() => {
      this.parameters$ = this.parametersService.getParameters();
      this.router.navigate(['/edit-parameters']);
    }, 50);
  }

  delete(parameter: Parameter)
  {
   /* if (parameter.type === 'number')
    this.parametersService.deleteParameterAndColumn(parameter.id,0, parameter.typeNumber);
    else  if (parameter.type === 'double')
      this.parametersService.deleteParameterAndColumn(parameter.id,1, parameter.typeNumber);
    else  if (parameter.type === 'string')
      this.parametersService.deleteParameterAndColumn(parameter.id,2, parameter.typeNumber);
    else
      this.parametersService.deleteParameterAndColumn(parameter.id,3, parameter.typeNumber);*/

    if (parameter.type === 'number')
 this.parametersService.deleteParameter(parameter.id);
 else  if (parameter.type === 'double')
   this.parametersService.deleteParameter(parameter.id);
 else  if (parameter.type === 'string')
   this.parametersService.deleteParameter(parameter.id);
 else
   this.parametersService.deleteParameter(parameter.id);

    this.parameters$ = this.parametersService.getParameters();
    setTimeout(() => {
      this.parameters$ = this.parametersService.getParameters();
      this.router.navigate(['/edit-parameters']);
    }, 5);
  }


  openDialog(): void {
    const dialogRef = this.dialog.open(EditParametersDialogComponent, {
      width: '250px',
    });

 //   dialogRef.afterClosed().subscribe(result => {

      this.confirmed = true;

  //  });
  }

}

@Component({
  selector: 'app-edit-parameters-dialog',
  templateUrl: './edit-parameters-dialog.component.html'
})
export class EditParametersDialogComponent {

  constructor(public dialogRef: MatDialogRef<EditParametersDialogComponent>,
              private route: ActivatedRoute,
              private router: Router) {}

  onClick(): void {
    this.dialogRef.close();
  }

  close(): void {
    this.dialogRef.close();
    this.router.navigate(['/administrator-panel']);
  }

}
