/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import {
  Component, ElementRef, EventEmitter, Injector, Input, OnDestroy, OnInit, Output,
  ViewChild
} from '@angular/core';
import { AbstractPopupComponent } from '../../../../../common/component/abstract-popup.component';
import { DatasourceInfo } from '../../../../../domain/datasource/datasource';
import { IngestionSettingComponent } from '../../../component/ingestion-setting.component';

/**
 * Creating datasource with File - ingestion step
 */
@Component({
  selector: 'file-ingestion',
  templateUrl: './file-ingestion.component.html'
})
export class FileIngestionComponent extends AbstractPopupComponent implements OnInit, OnDestroy {

  // datasource data
  private _sourceData: DatasourceInfo;

  @ViewChild(IngestionSettingComponent)
  private _ingestionSettingComponent: IngestionSettingComponent;

  @Input('sourceData')
  public set setSourceData(sourceData: DatasourceInfo) {
    this._sourceData = sourceData;
    this._ingestionSettingComponent.init(this._sourceData, 'FILE', this._sourceData.schemaData.selectedTimestampColumn);
  }

  @Input()
  public step: string;

  @Output()
  public stepChange: EventEmitter<string> = new EventEmitter();

  // Constructor
  constructor(protected element: ElementRef,
              protected injector: Injector) {
    super(element, injector);
  }

  /**
   * ngOnInit
   */
  public ngOnInit() {
    super.ngOnInit();
  }

  /**
   * ngOnDestroy
   */
  public ngOnDestroy() {
    super.ngOnDestroy();
  }

  /**
   * Move to previous step
   */
  public prev(): void {
    this.step = 'file-configure-schema';
    this.stepChange.emit(this.step);
  }

  /**
   * Move to next step
   */
  public next(): void {
    this.step = 'file-complete';
    this.stepChange.emit(this.step);
  }

  /**
   * Step change click event
   * @param {string} route
   */
  public onClickPageChange(route: string): void {
    route === 'prev' ? this._ingestionSettingComponent.onClickPrev() : this._ingestionSettingComponent.onClickNext();
  }
}
