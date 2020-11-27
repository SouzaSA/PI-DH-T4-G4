import { ProfessorDto } from '../dto/professor.dto';
import { Professor } from '../model/professor.model';

export class ProfessorMapper {

    static toProfessor( professorDto: ProfessorDto) : Professor {
        let professor = new Professor();

        professor.professorId = professorDto.professorId;
        professor.pessoaId = professorDto.pessoa.pessoaId;
        professor.enderecoId = professorDto.pessoa.endereco.id;
        professor.nome = professorDto.pessoa.nome;
        professor.sobrenome = professorDto.pessoa.sobrenome;
        professor.email = professorDto.pessoa.email;
        professor.cep = professorDto.pessoa.endereco.cep;
        professor.rua = professorDto.pessoa.endereco.rua;
        professor.numero = professorDto.pessoa.endereco.numero;
        professor.bairro = professorDto.pessoa.endereco.bairro;
        professor.complemento = professorDto.pessoa.endereco.complemento;
        professor.cidade = professorDto.pessoa.endereco.cidade;
        professor.estado = professorDto.pessoa.endereco.estado;
        professor.telefones = professorDto.pessoa.telefones.map(v => v.telefone);
        professor.departamento = professorDto.departamento;

        return professor;
    }

}