import { Component, OnInit } from '@angular/core';
import { SelectItem, SelectItemGroup } from 'primeng/api';

import { map, max } from 'rxjs/operators';

import { ProfessorService } from './../../../service/professor.service';
import { AvaliacaoService } from 'src/app/service/avaliacao.service';
import { DisciplinaDto } from './../../../shared/dto/disciplina.dto';
import { CursaDisciplinaOferecidaDto } from 'src/app/shared/dto/cursa-disciplina-oferecida.dto';
import { NotaDto } from 'src/app/shared/dto/nota.dto';
import { DropdownService } from 'src/app/service/dropdown.service';

export interface UltimaAvaliacao {
  PROVA: number,
  TRABALHO: number,
  SEMINARIO: number
};

@Component({
  selector: 'app-cadastro-avaliacao',
  templateUrl: './cadastro-avaliacao.component.html',
  styleUrls: ['./cadastro-avaliacao.component.css'],
})
export class CadastroAvaliacaoComponent implements OnInit {
  disciplinasPeloProfessor: CursaDisciplinaOferecidaDto[];
  disciplinas: DisciplinaDto[];
  avaliacaoTipos: string[];
  avaliacaoSelecionada: string;
  avaliacao: NotaDto;
  items: SelectItem[];
  turmaSelecionada: DisciplinaDto;
  operacao = true;
  data: Date;

  ultimaAvaliacao: UltimaAvaliacao = {
    PROVA: 0,
    TRABALHO: 0,
    SEMINARIO: 0
  };

  constructor(
    private professorService: ProfessorService,
    private dropdownService: DropdownService,
    private avaliacaoService: AvaliacaoService
  ) {}

  ngOnInit(): void {

    this.ultimaAvaliacao.PROVA = 0;
    this.ultimaAvaliacao.TRABALHO = 0;
    this.ultimaAvaliacao.SEMINARIO = 0;

    this.professorService.listaCursaDisciplinaOferecidaPeloProfessorId(+sessionStorage.getItem('professorId'))
      .subscribe(data => {
        this.disciplinasPeloProfessor = data,
        this.disciplinas = Array.from(new Set(data.map(v => v.disciplinaOferecida.disciplina)))
      });
    this.dropdownService.getAvaliacoes().subscribe(avaliacoes => 
      this.avaliacaoTipos = avaliacoes
    )
    this.consultar();
  }

  atualizaUltimaAvaliacao(disciplina: DisciplinaDto) {
    let disOf = this.disciplinasPeloProfessor
      .filter(disPeloProf => disPeloProf.disciplinaOferecida.disciplina.codigo == disciplina.codigo)[0];
    
    this.ultimaAvaliacao.PROVA = Math.max(...(disOf.notas.filter(notas => notas.titulo == "PROVA").map(notas => notas.numero)), 0);
    this.ultimaAvaliacao.SEMINARIO = Math.max(...(disOf.notas.filter(notas => notas.titulo == "SEMINARIO").map(notas => notas.numero)), 0);
    this.ultimaAvaliacao.TRABALHO = Math.max(...(disOf.notas.filter(notas => notas.titulo == "TRABALHO").map(notas => notas.numero)), 0)
    console.log(this.ultimaAvaliacao.PROVA); 
    console.log(this.ultimaAvaliacao.SEMINARIO); 
    console.log(this.ultimaAvaliacao.TRABALHO); 
      
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
