import { ActivatedRoute, Router } from '@angular/router';
import { Component, Inject, OnInit } from '@angular/core';
import { GerenciaInformesService } from '../gerencia-informes.service';
import { Informe } from '../gerencia-informes.model';


@Component({
  selector: 'app-gerencia-informes-delete',
  templateUrl: './gerencia-informes-delete.component.html',
  styleUrls: ['./gerencia-informes-delete.component.css'],
})
export class GerenciaInformesDeleteComponent implements OnInit {
  
  informe: Informe;
  displayConfirmacao = false;
  
  
  constructor(
    private gerenciaInformesService: GerenciaInformesService,
    private router: Router,
    private route: ActivatedRoute,
    
  ) {}

  ngOnInit(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.gerenciaInformesService.readById(id).subscribe((informe) => {
      this.informe = informe;
    });
  }

  deleteInforme(): void {
    this.gerenciaInformesService.delete(this.informe.id).subscribe(() => {
      this.gerenciaInformesService.showMessage('Informe excluído com sucesso.');
      this.router.navigate(['professor/informes']);
    });
  }

  cancel(): void {
    this.router.navigate(['professor/informes']);
  }

  dialogoConfirmacao(): void {
    this.displayConfirmacao = true;
  }
}
