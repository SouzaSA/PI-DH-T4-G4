import { SalaDto } from './../dto/sala.dto';
import { DisciplinaDto } from './../dto/disciplina.dto';
import { ProfessorDto } from './../dto/professor.dto';

export class DisciplinaOferecida {
  disciplinaOferecidaId?: number;
  horario?: string;
  professor?: string;
  disciplina?: string;
  sala?: string;
  semestre?: number;
  turma?: number;
  ano?: number;

  constructor() {
    this.disciplinaOferecidaId = undefined;
    this.horario = undefined;
    this.professor = undefined;
    this.disciplina = undefined;
    this.sala = undefined;
    this.semestre = undefined;
    this.turma = undefined;
    this.ano = undefined;
  }

}