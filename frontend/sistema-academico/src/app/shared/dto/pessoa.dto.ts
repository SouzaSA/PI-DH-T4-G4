import { EnderecoDto } from './endereco.dto';

export interface PessoaDto {
    pessoaId?: number;
    nome?: string;
    sobrenome?: string;
    email?: string;
    endereco?: EnderecoDto;
    telefone?: Array<string>;
  }