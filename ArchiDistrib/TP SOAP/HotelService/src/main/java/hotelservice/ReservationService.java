package hotelservice;

import javax.jws.WebService;

import hotelservice.utils.Chambre;
import hotelservice.utils.Client;
import hotelservice.utils.Reservation;

@WebService(endpointInterface="hotelservice.IReservationService")
public class ReservationService implements IReservationService{

	public boolean reserver(Chambre c, Client cl, String d1, String d2) {
		
		int da = Integer.parseInt(d1.replace("/", ""));
		int da1 = Integer.parseInt(d2.replace("/", ""));
		boolean valid = true;
		for (int i = 0; i < c.getReservation().size(); i++) {
			int cd = Integer.parseInt(c.getReservation().get(i).getDebut().replace("/", ""));
			int cd1 = Integer.parseInt(c.getReservation().get(i).getFin().replace("/", ""));
			if ((da > cd && da < cd1) || (da1 < cd1 && da1 > cd)) {
				valid = false;
			}
		}
		if (valid) {
			new Reservation(c, cl, d1, d2);
		}
		return valid;
	}
}
