import {ChangeDetectionStrategy, Component, HostBinding, Inject, Input, OnInit, Output} from '@angular/core';
import {Observable} from 'rxjs';
import {TranslatorService} from '../_services/translator.service';
import {Parameter} from '../_models/parameter';
import {ParametersService} from '../_services/parameters.service';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import {AppComponent} from '../app.component';
import {ActivatedRoute, Router} from '@angular/router';

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
    parameter.typeId = 0;
    this.parametersService.addParameter(parameter);

    this.parameters$ = this.parametersService.getParameters();
    setTimeout(() => {
      this.parameters$ = this.parametersService.getParameters();
      this.router.navigate(['/edit-parameters']);
    }, 5);
  }

  update(parameter: Parameter)
  {
    this.parametersService.updateParameter(parameter.id, parameter);

    this.parameters$ = this.parametersService.getParameters();
    setTimeout(() => {
      this.parameters$ = this.parametersService.getParameters();
      this.router.navigate(['/edit-parameters']);
    }, 5);
  }

  delete(parameter: Parameter)
  {
    if (parameter.type === 'number')
    this.parametersService.deleteParameter(parameter.id,0, parameter.typeId);
    else  if (parameter.type === 'double')
      this.parametersService.deleteParameter(parameter.id,1, parameter.typeId);
    else  if (parameter.type === 'string')
      this.parametersService.deleteParameter(parameter.id,2, parameter.typeId);
    else
      this.parametersService.deleteParameter(parameter.id,3, parameter.typeId);

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
              ) {}

  onClick(): void {
    this.dialogRef.close();
  }

  close(): void {
    this.dialogRef.close();
  }

}
