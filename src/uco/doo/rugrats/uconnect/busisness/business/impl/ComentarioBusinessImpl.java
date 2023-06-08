package uco.doo.rugrats.uconnect.busisness.business.impl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.ComentarioAssembler;
import uco.doo.rugrats.uconnect.busisness.business.ComentarioBusiness;
import uco.doo.rugrats.uconnect.busisness.domain.ComentarioDomain;
import uco.doo.rugrats.uconnect.busisness.domain.EstadoDomain;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.entities.ComentarioEntity;
import uco.doo.rugrats.uconnect.utils.UtilUUID;

import java.util.List;
import java.util.UUID;

public final class ComentarioBusinessImpl implements ComentarioBusiness {
    DAOFactory daoFactory;

    public ComentarioBusinessImpl(final DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }


    @Override
    public void comentar(ComentarioDomain domain) {
    	UUID identificador;
		ComentarioEntity entityTmp;
		 List<ComentarioEntity> result;
		
		do {
			identificador = UtilUUID.generateNewUUID();
			entityTmp = ComentarioEntity.create().setIdentificador(identificador);
			result = daoFactory.getComentarioDAO().read(entityTmp);
		}while(!result.isEmpty());
		
		final var domainToCreate = new ComentarioDomain(identificador, domain.getPublicacion(), domain.getComentarioPadre(), domain.getFechaPublicacion(), domain.getAutor(), domain.getContenido(), domain.getEstado(), domain.isTienePadre(),domain.isEstaEstadoRealActivo());
		final ComentarioEntity entity = ComentarioAssembler.getInstance().toEntityFromDomain(domainToCreate);
		daoFactory.getComentarioDAO().create(entity);	
    }

    @Override
    public void cambiarEstado(ComentarioDomain domain) {
		final ComentarioEntity entity = ComentarioAssembler.getInstance().toEntityFromDomain(domain);
		var entitiesToCompare = daoFactory.getComentarioDAO().read(entity);
    	if(entitiesToCompare.isEmpty() ? false: !entitiesToCompare.get(0).getEstado().getNombre().equalsIgnoreCase(entity.getEstado().getNombre())){
            daoFactory.getComentarioDAO().update(entity);
    	}  
    }

    @Override
    public List<ComentarioDomain> consultar(ComentarioDomain domain) {
    	final ComentarioEntity entity = ComentarioAssembler.getInstance().toEntityFromDomain(domain);

		final List<ComentarioEntity> resultEntityList = daoFactory.getComentarioDAO().read(entity);

		return ComentarioAssembler.getInstance().toDomainFromEntityList(resultEntityList);
    }

    @Override
    public void eliminar(UUID domain) {
        daoFactory.getComentarioDAO().delete(domain);
    }

    @Override
    public EstadoDomain obtenerEstadoReal() {
        return null;
    }
}