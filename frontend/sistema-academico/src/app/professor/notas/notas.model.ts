
export interface Disciplina {
  id?: number;
  nome?: string;
}

export interface Turma {
    id?: number;
    nome?: string;
    disciplina?: Disciplina;
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