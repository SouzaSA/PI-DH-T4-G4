import { EnderecoDto } from './endereco.dto';
import { TelefoneDto } from './telefone.dto';

export interface PessoaDto {
    pessoaId?: number;
    nome?: string;
    sobrenome?: string;
    email?: string;
    endereco?: EnderecoDto;
    telefones?: Array<TelefoneDto>;
  }