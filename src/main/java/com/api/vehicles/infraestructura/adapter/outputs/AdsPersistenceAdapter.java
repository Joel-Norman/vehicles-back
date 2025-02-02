package com.api.vehicles.infraestructura.adapter.outputs;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.api.vehicles.aplication.ports.outputs.AdsPersistencePort;
import com.api.vehicles.domain.Response;
import com.api.vehicles.infraestructura.adapter.outputs.entities.AdsEntity;
import com.api.vehicles.infraestructura.adapter.outputs.repositories.AdsRepository;

@Service
public class AdsPersistenceAdapter implements AdsPersistencePort{
	@Autowired
	AdsRepository adsRepo;

	@Override
	public Response addAds(MultipartFile file, String url,String title) {
		try {
			String archive="image_ads"+Calendar.getInstance().getTimeInMillis()+file.getOriginalFilename();
            Path filePath = Paths.get(archive);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            AdsEntity a=new AdsEntity();
            a.setImage(archive);
            a.setUrl(url);
            a.setTitle(title);
            adsRepo.save(a);
            return new Response(true,"Anuncio guardado con exito",null);
        } catch (Exception e) {
            e.printStackTrace();
            return new Response(false,"Ocurrio un error al intentar guardar el anuncio.",null);
        }
	}

	@Override
	public Response updateAds(MultipartFile file, String url, Long id,boolean image,String title) {
		try {
			AdsEntity a=adsRepo.findById(id).get();
			if(image) {
				String archive="image_ads"+Calendar.getInstance().getTimeInMillis()+file.getOriginalFilename();
	            Path filePath = Paths.get(archive);
	            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
	            a.setImage(archive);
			}
			a.setTitle(title);
            a.setUrl(url);
            adsRepo.save(a);
            return new Response(true,"Anuncio guardado con exito",null);
        } catch (Exception e) {
            e.printStackTrace();
            return new Response(false,"Ocurrio un error al intentar guardar el anuncio.",null);
        }
	}

	@Override
	public Response listAds() {
		return new Response(true,"",adsRepo.findAll(Sort.by(Sort.Direction.DESC, "id")));
	}

	@Override
	public Response deleteAds(Long id) {
		try {
			AdsEntity a=adsRepo.findById(id).get();
			adsRepo.deleteById(id);
            Path filePath = Paths.get(a.getImage());
            Files.delete(filePath);
            
            return new Response(true,"Anuncio borrado con exito",null);
        } catch (Exception e) {
            e.printStackTrace();
            return new Response(false,"Ocurrio un error al intentar borrar el anuncio.",null);
        }
	}
	
	

}
