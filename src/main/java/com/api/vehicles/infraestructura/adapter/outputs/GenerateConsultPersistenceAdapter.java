package com.api.vehicles.infraestructura.adapter.outputs;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.vehicles.aplication.ports.inputs.GenerarConsultaPort;
import com.api.vehicles.aplication.ports.outputs.GenerateConsultPersistencePort;
import com.api.vehicles.domain.Consult;
import com.api.vehicles.domain.GenerarConsulta;
import com.api.vehicles.domain.Register;
import com.api.vehicles.infraestructura.adapter.outputs.entities.ConsultEntity;
import com.api.vehicles.infraestructura.adapter.outputs.entities.User;
import com.api.vehicles.infraestructura.adapter.outputs.repositories.ConsultEntityRepository;
import com.api.vehicles.infraestructura.adapter.outputs.repositories.UserRespository;
@Service
public class GenerateConsultPersistenceAdapter implements GenerateConsultPersistencePort{
	@Autowired
	UserRespository userRepo;
	@Autowired
    ConsultEntityRepository consultRepo;
	
	@Override
	public GenerarConsulta saveConsult(GenerarConsulta consult) {
		try {
			User u=userRepo.findByUsername(consult.getUsername());
			if(u==null) {
				return null;
			}
			ConsultEntity c=new ConsultEntity();
			c.setInform("");
			c.setNit(consult.getNit());
			c.setPlaca(consult.getPlaca());
			c.setStatus("NOT_AVAILABLE");
			c.setUser(u);
			c.setInitDate(new Date());
			c= consultRepo.save(c);
			return consult;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
