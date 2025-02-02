package com.api.vehicles.infraestructura.adapter.outputs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.vehicles.aplication.ports.outputs.UpdateConfigPersistencePort;
import com.api.vehicles.domain.Configuration;
import com.api.vehicles.domain.Response;
import com.api.vehicles.infraestructura.adapter.outputs.entities.ConfigurationEntity;
import com.api.vehicles.infraestructura.adapter.outputs.repositories.ConfigurationEntityRepository;
@Service
public class UpdateConfigPersistenceAdapter implements UpdateConfigPersistencePort {

	@Autowired
	ConfigurationEntityRepository configRepo;
	@Override
	public Response updateConfig(Configuration config) {
		try {
			ConfigurationEntity c=configRepo.findById(1L).get();
			c.setPrice(config.getPrice());
			c.setTax1(config.getTax1());
			c.setTax2(config.getTax2());
			c.setApiKey(config.getApiKey());
			c.setApiPassword(config.getApiPassword());
			c.setApiUser(config.getApiUser());
			configRepo.save(c);
			return new Response(true, "Datos actualizados con exito.", null);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response(false, "Ocurrio un error al guardar los datos", null);
		}
	}
	@Override
	public Response viewConfig() {
		try {
			ConfigurationEntity config=configRepo.findById(1L).get();
			Configuration c=new Configuration();
			c.setPrice(config.getPrice());
			c.setTax1(config.getTax1());
			c.setTax2(config.getTax2());
			c.setApiKey(config.getApiKey());
			c.setApiPassword(config.getApiPassword());
			c.setApiUser(config.getApiUser());
			return new Response(true, "", c);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response(false, "Ocurrio un error al obtener los datos", null);
		}
	}

}
