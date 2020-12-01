import { DiaHoraDto } from '../dto/diaHora.dto';
import { DiaHora } from '../model/diaHora.model';

export class DiaHoraMapper {

    static toDiaHora (diaHoraDto: DiaHoraDto): DiaHora {
        let diaHora: DiaHora;
        
        diaHora.diaHoraId = diaHoraDto.diaHoraId;
        diaHora.diaSemana = diaHoraDto.diaSemana;
        diaHora.horario = diaHoraDto.horario;

        return diaHora;
    }
}