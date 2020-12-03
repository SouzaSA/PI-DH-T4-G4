import { Component, OnInit } from '@angular/core';
import { SelectItem, SelectItemGroup } from 'primeng/api';

import { map } from 'rxjs/operators';

import { ProfessorService } from './../../../service/professor.service';
import { AvaliacaoService } from 'src/app/service/avaliacao.service';
import { DisciplinaDto } from './../../../shared/dto/disciplina.dto';
import { CursaDisciplinaOferecidaDto } from 'src/app/shared/dto/cursa-disciplina-oferecida.dto';
import { NotaDto } from 'src/app/shared/dto/nota.dto';

@Component({
  selector: 'app-cadastro-avaliacao',
  templateUrl: './cadastro-avaliacao.component.html',
  styleUrls: ['./cadastro-avaliacao.component.css'],
})
export class CadastroAvaliacaoComponent implements OnInit {
  disciplinasPeloProfessor: CursaDisciplinaOferecidaDto[];
  disciplinas: DisciplinaDto[];
  avaliacao: NotaDto;
  items: SelectItem[];
  turmaSelecionada: string;
  operacao = true;
  data: Date;

  constructor(
    private professorService: ProfessorService,
    private avaliacaoService: AvaliacaoService
  ) {}

  ngOnInit(): void {
    this.professorService.listaCursaDisciplinaOferecidaPeloProfessorId(+sessionStorage.getItem('professorId'))
      .subscribe(data => {
        this.disciplinasPeloProfessor = data,
        this.disciplinas = Array.from(new Set(data.map(v => v.disciplinaOferecida.disciplina)))

      });
    this.consultar();
  }

  consultar() {
    this.avaliacaoService
      .listar()
      .subscribe((resposta) => (this.avaliacao = resposta as any));
  }

  inserirOuAtualizar() {
    if (this.operacao) {
      this.adicionar();
    } else {
      this.atualizar();
      this.operacao = true;
    }
  }

  editar(avaliacao: any) {
    this.avaliacao = avaliacao;
    this.operacao = false;
  }

  atualizar() {
    this.avaliacaoService.atualizar(this.avaliacao).subscribe(() => {
      this.avaliacao = this.avaliacao;
      this.consultar();
    });
  }

  adicionar() {
    this.avaliacaoService.adicionar(this.avaliacao).subscribe(() => {
      this.avaliacao = this.avaliacao;
      this.consultar();
    });
  }

  excluir(id: number) {
    this.avaliacaoService.excluir(id).subscribe(() => {
      this.consultar();
    });
  }
}
