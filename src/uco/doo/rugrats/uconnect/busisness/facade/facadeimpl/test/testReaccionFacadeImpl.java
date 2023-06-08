package uco.doo.rugrats.uconnect.busisness.facade.facadeimpl.test;

import java.util.List;

import uco.doo.rugrats.uconnect.busisness.facade.facadeimpl.ReaccionFacadeImpl;
import uco.doo.rugrats.uconnect.dto.ReaccionDTO;
import uco.doo.rugrats.uconnect.utils.UtilObject;

public interface testReaccionFacadeImpl {
	public static void main(String[] args) {
		ReaccionFacadeImpl test = new ReaccionFacadeImpl();

		List<ReaccionDTO> result = test.mostrar(ReaccionDTO.create());
		for (ReaccionDTO item : result) {
			System.out.println(UtilObject.getInstanceInString(item));
		}
	}
}
