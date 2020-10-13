export interface Aluno {
  id: number;
  nome: string;
  email: string;
  cep: string;
  rua: string;
  numero: number;
  bairro: string;
  complemento?: string;
  cidade: string;
  estado: string;
  telefone: Array<string>;
  curso: string;
}