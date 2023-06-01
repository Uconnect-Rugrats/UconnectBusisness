package uco.doo.rugrats.uconnect.busisness.business.impl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.ReaccionAssembler;
import uco.doo.rugrats.uconnect.busisness.business.ReaccionBusiness;
import uco.doo.rugrats.uconnect.busisness.domain.EstadoDomain;
import uco.doo.rugrats.uconnect.busisness.domain.ReaccionDomain;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.entities.ReaccionEntity;
import uco.doo.rugrats.uconnect.utils.UtilUUID;

import java.util.List;
import java.util.UUID;

public final class ReaccionBusinessImpl implements ReaccionBusiness {
    DAOFactory daoFactory;
    public ReaccionBusinessImpl(final DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void reaccionar(ReaccionDomain domain) {
    	UUID identificador;
		ReaccionEntity entityTmp;
		 List<ReaccionEntity> result;
		
		do {
			identificador = UtilUUID.generateNewUUID();
			entityTmp = ReaccionEntity.create().setIdentificador(identificador);
			result = daoFactory.getReaccionDAO().read(entityTmp);
		}while(!result.isEmpty());
		
		final var domainToCreate = new ReaccionDomain(identificador, domain.getPublicacion(), domain.getAutor(), domain.getFechaReaccion(), domain.getTipo(), domain.getEstado());
		final ReaccionEntity entity = ReaccionAssembler.getInstance().toEntityFromDomain(domainToCreate);
		daoFactory.getReaccionDAO().create(entity);	
    }

    @Override
    public List<ReaccionDomain> mostrar(ReaccionDomain domain) {
    	final ReaccionEntity entity = ReaccionAssembler.getInstance().toEntityFromDomain(domain);

		final List<ReaccionEntity> resultEntityList = daoFactory.getReaccionDAO().read(entity);

		return ReaccionAssembler.getInstance().toDomainFromEntityList(resultEntityList);
    }

    @Override
    public void eliminar(UUID domain) {
        daoFactory.getReaccionDAO().delete(domain);
    }

    @Override
    public EstadoDomain obtenerEstadoReal() {
        return null;
    }

	@Override
	public void cambiarReaccion(ReaccionDomain domain) {
		final ReaccionEntity entity = ReaccionAssembler.getInstance().toEntityFromDomain(domain);
		var entitiesToCompare = daoFactory.getReaccionDAO().read(entity);
    	if(entitiesToCompare.isEmpty() ? false: !entitiesToCompare.get(0).getTipo().getNombre().equalsIgnoreCase(entity.getTipo().getNombre())){
            daoFactory.getReaccionDAO().update(entity);
    	} 
		
	}
}
