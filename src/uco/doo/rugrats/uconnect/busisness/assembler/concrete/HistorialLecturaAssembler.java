package uco.doo.rugrats.uconnect.busisness.assembler.concrete;

import uco.doo.rugrats.uconnect.busisness.assembler.Assembler;
import uco.doo.rugrats.uconnect.busisness.domain.HistorialLecturaDomain;
import uco.doo.rugrats.uconnect.dto.HistorialLecturaDTO;
import uco.doo.rugrats.uconnect.entities.HistorialLecturaEntity;

import java.util.List;

public final class HistorialLecturaAssembler implements Assembler<HistorialLecturaDomain, HistorialLecturaDTO, HistorialLecturaEntity> {
    public static final HistorialLecturaAssembler INSTANCE = new HistorialLecturaAssembler();
    public static HistorialLecturaAssembler getInstance() { return INSTANCE; }
    private HistorialLecturaAssembler(){
        super();
    }

    @Override
    public HistorialLecturaDTO toDTOFromDomain(HistorialLecturaDomain domain) {
        return HistorialLecturaDTO.create().setIdentificador(domain.getIdentificador()).setFechaLectura(domain.getFechaLectura())
                .setGrupo(GrupoAssembler.getInstance().toDTOFromDomain(domain.getGrupo())).setLector(ParticipanteGrupoAssembler.getInstance().toDTOFromDomain(domain.getLector()))
                .setMensaje(MensajeAssembler.getInstance().toDTOFromDomain(domain.getMensaje())).setEstado(EstadoAssembler.getInstance().toDTOFromDomain(domain.getEstado()));
    }

    @Override
    public HistorialLecturaDomain toDomainFromDTO(HistorialLecturaDTO dto) {
        return new HistorialLecturaDomain(dto.getIdentificador(),GrupoAssembler.getInstance().toDomainFromDTO(dto.getGrupo()),
                ParticipanteGrupoAssembler.getInstance().toDomainFromDTO(dto.getLector()), dto.getFechaLectura(),
                MensajeAssembler.getInstance().toDomainFromDTO(dto.getMensaje()),EstadoAssembler.getInstance().toDomainFromDTO(dto.getEstado()) );
    }

    @Override
    public HistorialLecturaEntity toEntityFromDomain(HistorialLecturaDomain domain) {
        return new HistorialLecturaEntity(domain.getIdentificador(),GrupoAssembler.getInstance().toEntityFromDomain(domain.getGrupo()),
                ParticipanteGrupoAssembler.getInstance().toEntityFromDomain(domain.getLector()),domain.getFechaLectura(),
                MensajeAssembler.getInstance().toEntityFromDomain(domain.getMensaje()),EstadoAssembler.getInstance().toEntityFromDomain(domain.getEstado()) );
    }

    @Override
    public HistorialLecturaDomain toDomainFromEntity(HistorialLecturaEntity entity) {
        return new HistorialLecturaDomain(entity.getIdentificador(),GrupoAssembler.getInstance().toDomainFromEntity(entity.getGrupo()),
                ParticipanteGrupoAssembler.getInstance().toDomainFromEntity(entity.getLector()),entity.getFechaLectura(),
                MensajeAssembler.getInstance().toDomainFromEntity(entity.getMensaje()), EstadoAssembler.getInstance().toDomainFromEntity(entity.getEstado()));
    }

    @Override
    public List<HistorialLecturaDomain> toDomainFromEntityList(List<HistorialLecturaEntity> entityList) {
        return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();

    }

    @Override
    public List<HistorialLecturaDomain> toDomainFromDTOList(List<HistorialLecturaDTO> dtoList) {
        return dtoList.stream().map(dto -> toDomainFromDTO(dto)).toList();
    }

    @Override
    public List<HistorialLecturaDTO> toDTOFromDomainList(List<HistorialLecturaDomain> domainList) {
        return domainList.stream().map(domain -> toDTOFromDomain(domain)).toList();    }
}
