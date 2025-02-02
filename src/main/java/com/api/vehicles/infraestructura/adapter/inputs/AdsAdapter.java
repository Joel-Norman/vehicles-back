package com.api.vehicles.infraestructura.adapter.inputs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.api.vehicles.aplication.ports.inputs.AdsPort;
import com.api.vehicles.aplication.ports.outputs.AdsPersistencePort;
import com.api.vehicles.domain.Response;

@Service
public class AdsAdapter implements AdsPort {

	@Autowired
	AdsPersistencePort adsPort;
	@Override
	public Response addAds(MultipartFile file, String url,String title) {
		// TODO Auto-generated method stub
		return adsPort.addAds(file, url,title);
	}

	@Override
	public Response updateAds(MultipartFile file, String url, Long id, boolean imge,String title) {
		// TODO Auto-generated method stub
		return adsPort.updateAds(file, url, id, imge,title);
	}

	@Override
	public Response listAds() {
		// TODO Auto-generated method stub
		return adsPort.listAds();
	}

	@Override
	public Response deleteAds(Long id) {
		// TODO Auto-generated method stub
		return adsPort.deleteAds(id);
	}

}
