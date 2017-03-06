package net.antra.deptemp4.service;

import net.antra.deptemp4.ws.GeoIP;
import net.antra.deptemp4.ws.GeoIPService;
import net.antra.deptemp4.ws.GeoIPServiceSoap;

public class GeoIpConsumingTest {

	public static void main(String[] args) {
		GeoIPService service = new GeoIPService();
		GeoIPServiceSoap geoService = service.getGeoIPServiceSoap();
		GeoIP geoIp = geoService.getGeoIP("75.245.234.21");

		System.out.println(geoIp.getCountryName());
	}

}
