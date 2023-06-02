package uco.doo.rugrats.uconnect.busisness.assembler;

import java.util.List;

public interface Assembler<D, T, E> {
	T toDTOFromDomain(D domain);

	D toDomainFromDTO(T dto);

	E toEntityFromDomain(D domain);

	D toDomainFromEntity(E entity);

	List<D> toDomainFromEntityList(List<E> entityList);

	List<T> toDTOFromDomainList(List<D> domainList);
}
