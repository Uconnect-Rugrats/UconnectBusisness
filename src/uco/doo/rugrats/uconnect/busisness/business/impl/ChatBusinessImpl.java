package uco.doo.rugrats.uconnect.busisness.business.impl;

import uco.doo.rugrats.uconnect.busisness.assembler.concrete.ChatAssembler;
import uco.doo.rugrats.uconnect.busisness.business.ChatBusiness;
import uco.doo.rugrats.uconnect.busisness.domain.ChatDomain;
import uco.doo.rugrats.uconnect.busisness.domain.EstadoDomain;
import uco.doo.rugrats.uconnect.data.dao.factory.DAOFactory;
import uco.doo.rugrats.uconnect.entities.ChatEntity;

import java.util.List;
import java.util.UUID;

public final class ChatBusinessImpl implements ChatBusiness {
    DAOFactory daoFactory;
    public ChatBusinessImpl(final DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void crear(ChatDomain domain) {
        final ChatEntity entity = ChatAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getChatDAO().create(entity);
    }

    @Override
    public void cambiarEstado(ChatDomain domain) {
        final ChatEntity entity = ChatAssembler.getInstance().toEntityFromDomain(domain);
        daoFactory.getChatDAO().update(entity);
    }

    @Override
    public List<ChatDomain> consultar(ChatDomain domain) {
        final ChatEntity entity = ChatAssembler.getInstance().toEntityFromDomain(domain);
        final List<ChatEntity> resultado = daoFactory.getChatDAO().read(entity);
        return null;
    }

    @Override
    public void eliminar(UUID domain) {
        daoFactory.getChatDAO().delete(domain);
    }

    @Override
    public EstadoDomain obtenerEstadoReal() {
        return null;
    }
}
