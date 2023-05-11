package uco.doo.rugrats.uconnect.busisness.assembler.concrete;

import uco.doo.rugrats.uconnect.busisness.assembler.Assembler;
import uco.doo.rugrats.uconnect.busisness.domain.PublicacionDomain;
import uco.doo.rugrats.uconnect.dto.PublicacionDTO;
import uco.doo.rugrats.uconnect.entities.PublicacionEntity;

import java.util.List;

public final class PublicacionAssembler implements Assembler<PublicacionDomain, PublicacionDTO, PublicacionEntity> {
    public static final PublicacionAssembler INSTANCE = new PublicacionAssembler();
    public static PublicacionAssembler getInstance() { return INSTANCE; }
    private PublicacionAssembler(){
        super();
    }

    @Override
    public PublicacionDTO toDTOFromDomain(PublicacionDomain domain) {
        return PublicacionDTO.create().setIdentificador(domain.getIdentificador()).setContenido(domain.getContenido()).setTitulo(domain.getTitulo())
                .setGrupo(GrupoAssembler.getInstance().toDTOFromDomain(domain.getGrupo())).setAutor(ParticipanteGrupoAssembler.getInstance().toDTOFromDomain(domain.getAutor()))
                .setFechaPublicacion(domain.getFechaPublicacion()).setEstado(EstadoAssembler.getInstance().toDTOFromDomain(domain.getEstado()));
    }

    @Override
    public PublicacionDomain toDomainFromDTO(PublicacionDTO dto) {
        return new PublicacionDomain(dto.getIdentificador(),GrupoAssembler.getInstance().toDomainFromDTO(dto.getGrupo()),
                ParticipanteGrupoAssembler.getInstance().toDomainFromDTO(dto.getAutor()),dto.getFechaPublicacion(),dto.getTitulo(),
                dto.getContenido(),EstadoAssembler.getInstance().toDomainFromDTO(dto.getEstado()));
    }

    @Override
    public PublicacionEntity toEntityFromDomain(PublicacionDomain domain) {
        return new PublicacionEntity(domain.getIdentificador(),GrupoAssembler.getInstance().toEntityFromDomain(domain.getGrupo()),
                ParticipanteGrupoAssembler.getInstance().toEntityFromDomain(domain.getAutor()), domain.getFechaPublicacion(),domain.getTitulo(),
                domain.getContenido(), EstadoAssembler.getInstance().toEntityFromDomain(domain.getEstado()));
    }

    @Override
    public PublicacionDomain toDomainFromEntity(PublicacionEntity entity) {
        return new PublicacionDomain(entity.getIdentificador(),GrupoAssembler.getInstance().toDomainFromEntity(entity.getGrupo()),
                ParticipanteGrupoAssembler.getInstance().toDomainFromEntity(entity.getAutor()), entity.getFechaPublicacion(),entity.getTitulo(),
                entity.getContenido(), EstadoAssembler.getInstance().toDomainFromEntity(entity.getEstado()));
    }

    @Override
    public List<PublicacionDomain> toDomainFromEntityList(List<PublicacionEntity> entityList) {
        return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();

    }

    @Override
    public List<PublicacionDomain> toDomainFromDTOList(List<PublicacionDTO> dtoList) {
        return dtoList.stream().map(dto -> toDomainFromDTO(dto)).toList();
    }

    @Override
    public List<PublicacionDTO> toDTOFromDomainList(List<PublicacionDomain> domainList) {
        return domainList.stream().map(domain -> toDTOFromDomain(domain)).toList();
    }
}
