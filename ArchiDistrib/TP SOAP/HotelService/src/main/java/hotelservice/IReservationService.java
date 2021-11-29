package hotelservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

import hotelservice.utils.Chambre;
import hotelservice.utils.Client;

@WebService
public interface IReservationService {

	
	@WebMethod
	boolean reserver(Chambre c, Client cl,  String d1, String d2);
}
