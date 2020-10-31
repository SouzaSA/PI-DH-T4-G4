import { AdministradorDto } from '../dto/administrador.dto';
import { Administrador } from '../model/administrador.model';

export class AdministradorMapper {

    static toAdministrador( administradorDto: AdministradorDto) : Administrador {
        let administrador = new Administrador();

        administrador.id = administradorDto.administradorId;
        administrador.nome = administradorDto.pessoa.nome;
        administrador.sobrenome = administradorDto.pessoa.sobrenome;
        administrador.email = administradorDto.pessoa.email;
        administrador.cep = administradorDto.pessoa.endereco.cep;
        administrador.rua = administradorDto.pessoa.endereco.rua;
        administrador.numero = administradorDto.pessoa.endereco.numero;
        administrador.bairro = administradorDto.pessoa.endereco.bairro;
        administrador.complemento = administradorDto.pessoa.endereco.complemento;
        administrador.cidade = administradorDto.pessoa.endereco.cidade;
        administrador.estado = administradorDto.pessoa.endereco.estado;
        administrador.telefone = administradorDto.pessoa.telefone.map(v => v.telefone);

        return administrador;
    }

}