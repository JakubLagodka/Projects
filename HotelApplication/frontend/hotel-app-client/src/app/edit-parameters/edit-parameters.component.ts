import {Component, Inject, OnInit} from '@angular/core';
import {Observable} from 'rxjs';
import {Reservation} from '../_models/reservation';
import {AppComponent} from '../app.component';
import {TranslatorService} from '../_services/translator.service';
import {Parameters} from '../_models/parameters';
import {ParametersService} from '../_services/parameters.service';

@Component({
  selector: 'app-edit-parameters',
  templateUrl: './edit-parameters.component.html',
  styleUrls: ['./edit-parameters.component.css']
})
export class EditParametersComponent implements OnInit {

  parameters$: Observable<Parameters[]>;

  constructor(public parametersService: ParametersService,
              public translatorService: TranslatorService) { }

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
}
