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
import com.api.vehicles.domain.Response;
import com.api.vehicles.infraestructura.adapter.outputs.entities.ConfigurationEntity;
import com.api.vehicles.infraestructura.adapter.outputs.entities.ConsultEntity;
import com.api.vehicles.infraestructura.adapter.outputs.entities.User;
import com.api.vehicles.infraestructura.adapter.outputs.repositories.ConfigurationEntityRepository;
import com.api.vehicles.infraestructura.adapter.outputs.repositories.ConsultEntityRepository;
import com.api.vehicles.infraestructura.adapter.outputs.repositories.UserRespository;
@Service
public class GenerateConsultPersistenceAdapter implements GenerateConsultPersistencePort{
	@Autowired
	UserRespository userRepo;
	@Autowired
    ConsultEntityRepository consultRepo;
	@Autowired
	ConfigurationEntityRepository configRepo;
	@Override
	public GenerarConsulta saveConsult(GenerarConsulta consult) {
		try {
			ConfigurationEntity conf=configRepo.findById(1L).get();
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
			c.setPrice(conf.getPrice());
			double t1=conf.getPrice()/((conf.getTax1()/100)+1);
			double t2=t1/((conf.getTax2()/100)+1);
			c.setPriceTx1(t1);
			c.setPriceTx2(t2);
			c.setTax1(conf.getTax1());
			c.setTax2(conf.getTax2());
			c= consultRepo.save(c);
			return consult;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public Response updatePaymentConsult(Long id) {
		try {
			
			ConsultEntity c=consultRepo.findById(id).get();
			
			//c.setStatus("AVAILABLE");
			c.setPaymentDate(new Date());
			
			c= consultRepo.save(c);
			return new Response(true, "Pago del informe actualizado", null);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response(false, "Ocurrio un error al intentar registrar el pago", null);
		}
	}
}
