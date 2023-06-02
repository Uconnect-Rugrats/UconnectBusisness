package uco.doo.rugrats.uconnect.busisness.assembler.concrete;

import uco.doo.rugrats.uconnect.busisness.assembler.Assembler;
import uco.doo.rugrats.uconnect.busisness.domain.ChatDomain;
import uco.doo.rugrats.uconnect.dto.ChatDTO;
import uco.doo.rugrats.uconnect.entities.ChatEntity;

import java.util.List;

public final class ChatAssembler implements Assembler<ChatDomain, ChatDTO, ChatEntity> {
	public static final ChatAssembler INSTANCE = new ChatAssembler();

	public static ChatAssembler getInstance() {
		return INSTANCE;
	}

	private ChatAssembler() {
		super();
	}

	@Override
	public ChatDTO toDTOFromDomain(ChatDomain domain) {
		return ChatDTO.create().setIdentificador(domain.getIdentificador())
				.setGrupo(GrupoAssembler.getInstance().toDTOFromDomain(domain.getGrupo()))
				.setEstado(EstadoAssembler.getInstance().toDTOFromDomain(domain.getEstado()));
	}

	@Override
	public ChatDomain toDomainFromDTO(ChatDTO dto) {
		return new ChatDomain(dto.getIdentificador(), GrupoAssembler.getInstance().toDomainFromDTO(dto.getGrupo()),
				EstadoAssembler.getInstance().toDomainFromDTO(dto.getEstado()));
	}

	@Override
	public ChatEntity toEntityFromDomain(ChatDomain domain) {
		return new ChatEntity(domain.getIdentificador(),
				GrupoAssembler.getInstance().toEntityFromDomain(domain.getGrupo()),
				EstadoAssembler.getInstance().toEntityFromDomain(domain.getEstado()));
	}

	@Override
	public ChatDomain toDomainFromEntity(ChatEntity entity) {
		return new ChatDomain(entity.getIdentificador(),
				GrupoAssembler.getInstance().toDomainFromEntity(entity.getGrupo()),
				EstadoAssembler.getInstance().toDomainFromEntity(entity.getEstado()));
	}

	@Override
	public List<ChatDomain> toDomainFromEntityList(List<ChatEntity> entityList) {
		return entityList.stream().map(this::toDomainFromEntity).toList();

	}

	@Override
	public List<ChatDTO> toDTOFromDomainList(List<ChatDomain> domainList) {
		return domainList.stream().map(this::toDTOFromDomain).toList();
	}
}
