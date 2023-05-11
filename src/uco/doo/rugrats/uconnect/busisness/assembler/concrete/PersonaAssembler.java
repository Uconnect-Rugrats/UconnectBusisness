package uco.doo.rugrats.uconnect.busisness.assembler.concrete;

import uco.doo.rugrats.uconnect.busisness.assembler.Assembler;
import uco.doo.rugrats.uconnect.busisness.domain.PersonaDomain;
import uco.doo.rugrats.uconnect.dto.PersonaDTO;
import uco.doo.rugrats.uconnect.entities.PersonaEntity;

import java.util.List;

public final class PersonaAssembler implements Assembler<PersonaDomain, PersonaDTO, PersonaEntity> {
    public static final PersonaAssembler INSTANCE = new PersonaAssembler();
    public static PersonaAssembler getInstance() { return INSTANCE; }
    private PersonaAssembler(){
        super();
    }

    @Override
    public PersonaDTO toDTOFromDomain(PersonaDomain domain) {
        return PersonaDTO.create().setIdentificador(domain.getIdentificador()).setTipoIdentificacion(TipoIdentificacionAssembler.getInstance().toDTOFromDomain(domain.getTipoIdentificacion()))
                .setNumeroIdentificacion(domain.getNumeroIdentificacion()).setPrimerNombre(domain.getPrimerNombre()).setSegundoNombre(domain.getSegundoNombre())
                .setPrimerApellido(domain.getPrimerApellido()).setSegundoApellido(domain.getSegundoApellido()).setCorreo(domain.getCorreo())
                .setPaisTelefono(PaisAssembler.getInstance().toDTOFromDomain(domain.getPaisTelefono())).setNumeroTelefono(domain.getNumeroTelefono())
                .setEstado(EstadoAssembler.getInstance().toDTOFromDomain(domain.getEstado()));
    }

    @Override
    public PersonaDomain toDomainFromDTO(PersonaDTO dto) {
        return new PersonaDomain(dto.getIdentificador(),TipoIdentificacionAssembler.getInstance().toDomainFromDTO(dto.getTipoIdentificacion()),
                dto.getNumeroIdentificacion(),dto.getPrimerNombre(),dto.getSegundoNombre(),dto.getPrimerApellido(),dto.getSegundoApellido(),
                dto.getCorreo(),PaisAssembler.getInstance().toDomainFromDTO(dto.getPaisTelefono()),dto.getNumeroTelefono(),EstadoAssembler.getInstance().toDomainFromDTO(dto.getEstado()) );
    }

    @Override
    public PersonaEntity toEntityFromDomain(PersonaDomain domain) {
        return new PersonaEntity(domain.getIdentificador(),TipoIdentificacionAssembler.getInstance().toEntityFromDomain(domain.getTipoIdentificacion()),
                domain.getNumeroIdentificacion(),domain.getPrimerNombre(),domain.getSegundoNombre(),domain.getPrimerApellido(),
                domain.getSegundoApellido(),domain.getCorreo(),PaisAssembler.getInstance().toEntityFromDomain(domain.getPaisTelefono()),
                domain.getNumeroTelefono(),EstadoAssembler.getInstance().toEntityFromDomain(domain.getEstado()));
    }

    @Override
    public PersonaDomain toDomainFromEntity(PersonaEntity entity) {
        return new PersonaDomain(entity.getIdentificador(),TipoIdentificacionAssembler.getInstance().toDomainFromEntity(entity.getTipoIdentificacion()),
                entity.getNumeroIdentificacion(),entity.getPrimerNombre(),entity.getSegundoNombre(),entity.getPrimerApellido(),entity.getSegundoApellido(),
                entity.getCorreo(),PaisAssembler.getInstance().toDomainFromEntity(entity.getPaisTelefono()),entity.getNumeroTelefono(),
                EstadoAssembler.getInstance().toDomainFromEntity(entity.getEstado()));
    }

    @Override
    public List<PersonaDomain> toDomainFromEntityList(List<PersonaEntity> entityList) {
        return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();

    }

    @Override
    public List<PersonaDomain> toDomainFromDTOList(List<PersonaDTO> dtoList) {
        return dtoList.stream().map(dto -> toDomainFromDTO(dto)).toList();
    }

    @Override
    public List<PersonaDTO> toDTOFromDomainList(List<PersonaDomain> domainList) {
        return domainList.stream().map(domain -> toDTOFromDomain(domain)).toList();    }
}
