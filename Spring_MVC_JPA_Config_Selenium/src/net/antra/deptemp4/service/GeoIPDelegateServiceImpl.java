package net.antra.deptemp4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.antra.deptemp4.ws.GeoIP;
import net.antra.deptemp4.ws.GeoIPService;
import net.antra.deptemp4.ws.GeoIPServiceSoap;

@Service
public class GeoIPDelegateServiceImpl implements GeoIPDelegateService {

	@Autowired
	GeoIPService service;
	
	@Override
	public String getCountryName(String ip) {
//		GeoIPService service = new GeoIPService();
//		GeoIPServiceSoap geoService = service.getGeoIPServiceSoap();
//		GeoIP geoIp = geoService.getGeoIP(ip);
//		return geoIp.getCountryName();
		return service.getGeoIPServiceSoap().getGeoIP(ip).getCountryName();
	}
}
