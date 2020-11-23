import { AlunoDto } from '../dto/aluno.dto';
import { Aluno } from '../model/aluno.model';

export class AlunoMapper {

    static toAluno( alunoDto: AlunoDto) : Aluno {
        let aluno = new Aluno();

        aluno.id = alunoDto.alunoId;
        aluno.nome = alunoDto.pessoa.nome;
        aluno.sobrenome = alunoDto.pessoa.sobrenome;
        aluno.email = alunoDto.pessoa.email;
        aluno.cep = alunoDto.pessoa.endereco.cep;
        aluno.rua = alunoDto.pessoa.endereco.rua;
        aluno.numero = alunoDto.pessoa.endereco.numero;
        aluno.bairro = alunoDto.pessoa.endereco.bairro;
        aluno.complemento = alunoDto.pessoa.endereco.complemento;
        aluno.cidade = alunoDto.pessoa.endereco.cidade;
        aluno.estado = alunoDto.pessoa.endereco.estado;
        aluno.telefones = alunoDto.pessoa.telefones.map(v => v.telefone);
        aluno.curso = alunoDto.curso.nome;


        return aluno;
    }

}