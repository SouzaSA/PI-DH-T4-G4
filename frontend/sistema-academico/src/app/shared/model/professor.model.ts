import { ProfessorDto } from '../dto/professor.dto';

export class Professor {
  professorId?: number;
  pessoaId?: number;
  enderecoId?: number;
  nome?: string;
  sobrenome?: string;
  email?: string;
  cep?: string;
  rua?: string;
  numero?: number;
  bairro?: string;
  complemento?: string;
  cidade?: string;
  estado?: string;
  telefones?: Array<string>;
  departamento?: string;

  constructor() {
    this.professorId = undefined;
    this.pessoaId = undefined;
    this.enderecoId = undefined;
    this.nome  = undefined;
    this.sobrenome  = undefined;
    this.email = undefined;
    this.cep = undefined;
    this.rua = undefined;
    this.numero = undefined;
    this.bairro = undefined;
    this.complemento = undefined;
    this.cidade = undefined;
    this.estado = undefined;
    this.telefones = undefined;
    this.departamento = undefined;
  }

}