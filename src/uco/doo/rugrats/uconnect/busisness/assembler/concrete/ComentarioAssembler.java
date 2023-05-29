package uco.doo.rugrats.uconnect.busisness.assembler.concrete;

import uco.doo.rugrats.uconnect.busisness.assembler.Assembler;
import uco.doo.rugrats.uconnect.busisness.domain.ComentarioDomain;
import uco.doo.rugrats.uconnect.dto.ComentarioDTO;
import uco.doo.rugrats.uconnect.entities.ComentarioEntity;
import uco.doo.rugrats.uconnect.utils.UtilObject;

import java.util.List;

public final class ComentarioAssembler implements Assembler<ComentarioDomain, ComentarioDTO, ComentarioEntity> {
    public static final ComentarioAssembler INSTANCE = new ComentarioAssembler();
    public static ComentarioAssembler getInstance() { return INSTANCE; }
    private ComentarioAssembler(){
        super();
    }

    @Override
    public ComentarioDTO toDTOFromDomain(ComentarioDomain domain) {
        return ComentarioDTO.create().setIdentificador(domain.getIdentificador()).setComentarioPadre(!UtilObject.isNull(domain.getComentarioPadre()) ? ComentarioAssembler.getInstance().toDTOFromDomain(domain.getComentarioPadre()):null).setAutor(ParticipanteGrupoAssembler.getInstance().toDTOFromDomain(domain.getAutor()))
                .setContenido(domain.getContenido()).setFechaPublicacion(domain.getFechaPublicacion()).setPublicacion(PublicacionAssembler.getInstance().toDTOFromDomain(domain.getPublicacion()))
                .setEstado(EstadoAssembler.getInstance().toDTOFromDomain(domain.getEstado())).setTienePadre(domain.isTienePadre());
    }

    @Override
    public ComentarioDomain toDomainFromDTO(ComentarioDTO dto) {
        return new ComentarioDomain(dto.getIdentificador(),PublicacionAssembler.getInstance().toDomainFromDTO(dto.getPublicacion()),
        		!UtilObject.isNull(dto.getComentarioPadre())? ComentarioAssembler.getInstance().toDomainFromDTO(dto.getComentarioPadre()):null,dto.getFechaPublicacion(),ParticipanteGrupoAssembler.getInstance().toDomainFromDTO(dto.getAutor()),
                dto.getContenido(),EstadoAssembler.getInstance().toDomainFromDTO(dto.getEstado()),dto.isTienePadre());
    }

    @Override
    public ComentarioEntity toEntityFromDomain(ComentarioDomain domain) {
        return new ComentarioEntity(domain.getIdentificador(),PublicacionAssembler.getInstance().toEntityFromDomain(domain.getPublicacion()),
        		!UtilObject.isNull(domain.getComentarioPadre())? ComentarioAssembler.getInstance().toEntityFromDomain(domain.getComentarioPadre()):null,domain.getFechaPublicacion(),
                ParticipanteGrupoAssembler.getInstance().toEntityFromDomain(domain.getAutor()), domain.getContenido(),EstadoAssembler.getInstance().toEntityFromDomain(domain.getEstado()),domain.isTienePadre());
    }

    @Override
    public ComentarioDomain toDomainFromEntity(ComentarioEntity entity) {
        return new ComentarioDomain(entity.getIdentificador(), PublicacionAssembler.getInstance().toDomainFromEntity(entity.getPublicacion()),
        		!UtilObject.isNull(entity.getComentarioPadre())? ComentarioAssembler.getInstance().toDomainFromEntity(entity.getComentarioPadre()):null,entity.getFechaPublicacion(),ParticipanteGrupoAssembler.getInstance().toDomainFromEntity(entity.getAutor()),
                entity.getContenido(),EstadoAssembler.getInstance().toDomainFromEntity(entity.getEstado()),entity.isTienePadre());
    }

    @Override
    public List<ComentarioDomain> toDomainFromEntityList(List<ComentarioEntity> entityList) {
        return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();

    }

    @Override
    public List<ComentarioDomain> toDomainFromDTOList(List<ComentarioDTO> dtoList) {
        return dtoList.stream().map(dto -> toDomainFromDTO(dto)).toList();
    }

    @Override
    public List<ComentarioDTO> toDTOFromDomainList(List<ComentarioDomain> domainList) {
        return domainList.stream().map(domain -> toDTOFromDomain(domain)).toList();    }
}
