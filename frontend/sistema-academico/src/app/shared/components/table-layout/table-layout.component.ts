import { Component, Input, OnChanges } from '@angular/core';

import { SharedService } from './../../../service/shared.service';
import { ColumnSetting } from '../../../shared/model/table-layout.model';

@Component({
  selector: 'ct-table',
  templateUrl: './table-layout.component.html',
  styleUrls: ['./table-layout.component.scss']
})
export class TableLayoutComponent implements OnChanges { 

  @Input() 
  records: any[];

  @Input() 
  caption: string;

  @Input() 
  settings: ColumnSetting[];
    
  columnMaps: ColumnSetting[];

  keys: string[];

  constructor(private sharedService: SharedService) { }

  ngOnChanges() {
    if (this.settings) { // when settings provided
      this.columnMaps = this.settings;
    } 
    else { // no settings, create column maps with defaults
      this.columnMaps = Object.keys(this.records[0])
        .map( key => {
          return {
            primaryKey: key,
            header: key.slice(0, 1).toUpperCase() + key.replace(/_/g, ' ' ).slice(1)
          }
        });
    }
  };

  public editar(v: any){
    console.log(v);
    this.sharedService.sendEditEvent(v);
    
    //fazer
  };
}