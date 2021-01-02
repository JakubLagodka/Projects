import {Component, Inject, OnInit} from '@angular/core';
import {Observable} from 'rxjs';
import {TranslatorService} from '../_services/translator.service';
import {Parameters} from '../_models/parameters';
import {ParametersService} from '../_services/parameters.service';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';

@Component({
  selector: 'app-edit-parameters',
  templateUrl: './edit-parameters.component.html',
  styleUrls: ['./edit-parameters.component.css']
})
export class EditParametersComponent implements OnInit {

  parameters$: Observable<Parameters[]>;
  confirmed = false;
  constructor(public parametersService: ParametersService,
              public translatorService: TranslatorService,
              public dialog: MatDialog) { }

  ngOnInit(): void {
    this.parameters$ = this.parametersService.getParameters();

  }
  add(parameter: Parameters)
  {
    this.parametersService.addParameter(parameter);
  }

  update(parameter: Parameters)
  {
    this.parametersService.updateParameter(parameter.id, parameter);
  }

  delete(parameter: Parameters)
  {
    this.parametersService.deleteParameter(parameter.id);
  }



  openDialog(): void {
    const dialogRef = this.dialog.open(EditParametersDialogComponent, {
      width: '250px',
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');

    });
  }
}

@Component({
  selector: 'app-edit-parameters-dialog',
  templateUrl: 'edit-parameters-dialog.html',
})
export class EditParametersDialogComponent {

  constructor(
    public dialogRef: MatDialogRef<EditParametersDialogComponent>) {}

  onNoClick(): void {
    this.dialogRef.close();
  }

}
