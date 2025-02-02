package com.api.vehicles.aplication.ports.inputs;

import org.springframework.web.multipart.MultipartFile;

import com.api.vehicles.domain.Response;

public interface AdsPort {
	public Response addAds(MultipartFile file,String url,String title);
	public Response updateAds(MultipartFile file,String url,Long id,boolean imge,String title);
	public Response listAds();
	public Response deleteAds(Long id);
}
