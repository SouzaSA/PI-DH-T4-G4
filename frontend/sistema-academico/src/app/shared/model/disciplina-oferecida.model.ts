import { DiaHora } from './diaHora.model';

export class DisciplinaOferecida {
  disciplinaOferecidaId?: number;
  diasHoras?: DiaHora[];
  professor?: string;
  disciplina?: string;
  sala?: string;
  semestre?: number;
  turma?: number;
  ano?: number;

  constructor() {
    this.disciplinaOferecidaId = undefined;
    this.diasHoras = undefined;
    this.professor = undefined;
    this.disciplina = undefined;
    this.sala = undefined;
    this.semestre = undefined;
    this.turma = undefined;
    this.ano = undefined;
  }

}