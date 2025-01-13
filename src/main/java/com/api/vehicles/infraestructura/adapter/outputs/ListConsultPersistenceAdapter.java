package com.api.vehicles.infraestructura.adapter.outputs;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.vehicles.aplication.ports.outputs.ListConsultPersistencePort;
import com.api.vehicles.domain.Consult;
import com.api.vehicles.infraestructura.adapter.outputs.entities.ConsultEntity;
import com.api.vehicles.infraestructura.adapter.outputs.repositories.ConsultEntityRepository;
import com.api.vehicles.infraestructura.adapter.outputs.repositories.UserRespository;
@Service
public class ListConsultPersistenceAdapter implements ListConsultPersistencePort{
	@Autowired
	UserRespository userRepo;
	@Autowired
    ConsultEntityRepository consultRepo;
	@Override
	public List<Consult> listConsultPersistence(String username) {
		try {
			List<ConsultEntity> l=consultRepo.findByUserUsername(username);
			return l.stream().map(t -> new Consult(
					t.getId(),
					t.getNit(),
					t.getPlaca(),
					t.getStatus(),
					t.getInform(),
					new SimpleDateFormat("MMMM").format(t.getInitDate()),
					String.valueOf(t.getInitDate().getDate()),
					new SimpleDateFormat("EEEE").format(t.getInitDate()),
					new SimpleDateFormat("HH:mm").format(t.getInitDate())
					)).toList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	@Override
	public List<Consult> listConsultPendientPersistence(String status) {
		try {
			List<ConsultEntity> l=consultRepo.findByStatus(status);
			return l.stream().map(t -> new Consult(
					t.getId(),
					t.getNit(),
					t.getPlaca(),
					t.getStatus(),
					t.getInform(),
					new SimpleDateFormat("MMMM").format(t.getInitDate()),
					String.valueOf(t.getInitDate().getDate()),
					new SimpleDateFormat("EEEE").format(t.getInitDate()),
					new SimpleDateFormat("HH:mm").format(t.getInitDate())
					)).toList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
