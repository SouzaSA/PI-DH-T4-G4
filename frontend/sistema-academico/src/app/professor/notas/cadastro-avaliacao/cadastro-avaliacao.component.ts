import { Avaliacao, Turma } from './../notas.model';
import { Component, OnInit } from '@angular/core';
import { SelectItem, SelectItemGroup } from 'primeng/api';
import { AvaliacaoService } from 'src/app/service/avaliacao.service';

@Component({
  selector: 'app-cadastro-avaliacao',
  templateUrl: './cadastro-avaliacao.component.html',
  styleUrls: ['./cadastro-avaliacao.component.css'],
})
export class CadastroAvaliacaoComponent implements OnInit {
  disciplinas: SelectItemGroup[];
  items: SelectItem[];
  avaliacao: Avaliacao;
  turmaSelecionada: string;
  operacao = true;
  data: Date;

  constructor(private avaliacaoService: AvaliacaoService) {
    this.disciplinas = [
      {
        label: 'DISC1',
        value: 'DISC1',
        items: [
          { label: 'DISC1-A', value: 'DISC1-A' },
          { label: 'DISC1-B', value: 'DISC1-B' },
        ],
      },
      {
        label: 'DISC2',
        value: 'DISC2',
        items: [{ label: 'DISC2-A', value: 'DISC2-A' }],
      },
      { label: 'DISC3', value: 'DISC3', items: [] },
      { label: 'DISC4', value: 'DISC4', items: [] },
    ];
  }

  ngOnInit(): void {
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
