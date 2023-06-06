package uco.doo.rugrats.uconnect.busisness.facade.facadeimpl.test;

import java.util.List;

import uco.doo.rugrats.uconnect.busisness.facade.facadeimpl.ComentarioFacadeImpl;
import uco.doo.rugrats.uconnect.dto.ComentarioDTO;
import uco.doo.rugrats.uconnect.utils.UtilObject;
import uco.doo.rugrats.uconnect.utils.UtilUUID;

public interface TestComentarioFacadeImpl {

	public static void main(String[] args) {
		ComentarioFacadeImpl test = new ComentarioFacadeImpl();

		List<ComentarioDTO> result = test.consultar(ComentarioDTO.create()
				.setIdentificador(UtilUUID.generateUUIDFromString("24cb84be-fdd8-4fe2-811a-b1d97c59f731")));
		for (ComentarioDTO item : result) {
			System.out.println(UtilObject.getInstanceInString(item));
			if (!UtilObject.isNull(item.getComentarioPadre())
					|| !UtilObject.isDefault(item.getComentarioPadre(), ComentarioDTO.create())) {
				System.out.println("Padre" + UtilObject.getInstanceInString(item.getComentarioPadre()));
			}
		}
	}
}
