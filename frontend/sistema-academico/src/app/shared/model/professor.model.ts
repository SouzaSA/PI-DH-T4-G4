import { ProfessorDto } from '../dto/professor.dto';

export class Professor {
  id?: number;
  nome?: string;
  email?: string;
  cep?: string;
  rua?: string;
  numero?: number;
  bairro?: string;
  complemento?: string;
  cidade?: string;
  estado?: string;
  telefone?: Array<string>;
  departamento?: string;

  constructor() {
    this.id = undefined;
    this.nome  = undefined;
    this.email = undefined;
    this.cep = undefined;
    this.rua = undefined;
    this.numero = undefined;
    this.bairro = undefined;
    this.complemento = undefined;
    this.cidade = undefined;
    this.estado = undefined;
    this.telefone = undefined;
    this.departamento = undefined;
  }

}