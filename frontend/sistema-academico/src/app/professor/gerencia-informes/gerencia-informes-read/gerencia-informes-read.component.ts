import { Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';
import { GerenciaInformesUpdateComponent } from './../gerencia-informes-update/gerencia-informes-update.component';
import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { Informe } from '../gerencia-informes.model';
import { GerenciaInformesService } from '../gerencia-informes.service';

@Component({
  selector: 'app-gerencia-informes-read',
  templateUrl: './gerencia-informes-read.component.html',
  styleUrls: ['./gerencia-informes-read.component.css'],
})
export class GerenciaInformesReadComponent implements OnInit {
  informes: Informe[];
  displayConfirmacao = false;


  constructor(private gerenciaInformesService: GerenciaInformesService, private router: Router) {}

  ngOnInit(): void {
    this.gerenciaInformesService.read().subscribe((informes) => {
      this.informes = informes;
    });
  }

  dialogoConfirmacao(): void {
    this.displayConfirmacao = true;
  }
}
