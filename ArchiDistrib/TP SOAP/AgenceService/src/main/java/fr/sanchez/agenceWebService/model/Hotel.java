package fr.sanchez.agenceWebService.model;

import java.net.URL;

import fr.sanchez.agenceWebService.hotel.HotelService;
import fr.sanchez.agenceWebService.hotel.IHotelService;

public class Hotel {

	private URL url;
	public Hotel(URL url) {
		super();
		this.url = url;
	}
	public IHotelService getProxy() {
		HotelService h = new HotelService(url);
		return h.getHotelPort();
	}
	public URL getUrl() {
		return url;
	}
	
	
}
