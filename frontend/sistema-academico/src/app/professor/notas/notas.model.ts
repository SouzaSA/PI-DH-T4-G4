export interface Disciplina {
  nome?: string;
  turma?: any;
}

export interface Turma {
  id?: number;
  nome?: string;
  professor?: Professor;
  alunos?: Array<Aluno>;
}

export interface Aluno {
  id: number;
  nome: string;
  faltas?: number;
  notas?: Array<string>;
}

export interface Professor {
  id: number;
  nome: string;
}

export interface Avaliacao {
  id?: number;
  disciplina?: any;
  turma?: any;
  data?: Date;
  nome?: string;
}
