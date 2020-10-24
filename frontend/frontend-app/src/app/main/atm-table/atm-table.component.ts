import {Component, ViewChild, OnInit} from '@angular/core';
import {MatSort} from '@angular/material/sort';
import {Atm, atms} from '../../model/atm';
import {MatPaginator} from '@angular/material/paginator';
import {MatTableDataSource} from '@angular/material/table';
import {MatInputModule} from '@angular/material/input';
import {AtmService} from "../../atm.service";

@Component({
  selector: 'app-atm-table',
  templateUrl: './atm-table.component.html',
  styleUrls: ['./atm-table.component.styl']
})
export class AtmTableComponent implements OnInit {
  displayedColumns = ['type', "address", "lat", "lng"];
  atms: Atm[] = atms;
  dataSource = new MatTableDataSource(atms);
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort, {}) sort: MatSort;
  filterValue: string;

  constructor(private atmService: AtmService) { }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

  ngOnInit() {
    this.dataSource.paginator = this.paginator;

  }

  onNavigate(id) {
    console.log(`Atm id${id}`)
  }

  filterProduct(value: string): void {
    if (value !== undefined && value != "") {
      console.log("filter", value)
      this.atmService.search(value).subscribe(response => {
          this.dataSource = response['atms'];
        });
    }
  }

}
