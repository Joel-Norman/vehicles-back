package com.api.vehicles.infraestructura.adapter.outputs;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.vehicles.aplication.ports.outputs.ListConsultPersistencePort;
import com.api.vehicles.domain.Consult;
import com.api.vehicles.domain.ListConsult;
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
					new SimpleDateFormat("MMMM",new Locale("es", "ES")).format(t.getInitDate()),
					String.valueOf(t.getInitDate().getDate()),
					new SimpleDateFormat("EEEE",new Locale("es", "ES")).format(t.getInitDate()),
					new SimpleDateFormat("HH:mm",new Locale("es", "ES")).format(t.getInitDate()),
					t.getPaymentDate()!=null
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
					new SimpleDateFormat("MMMM",new Locale("es", "ES")).format(t.getInitDate()),
					String.valueOf(t.getInitDate().getDate()),
					new SimpleDateFormat("EEEE",new Locale("es", "ES")).format(t.getInitDate()),
					new SimpleDateFormat("HH:mm",new Locale("es", "ES")).format(t.getInitDate()),
					t.getPaymentDate()!=null
					)).toList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	@Override
	public List<ListConsult> listConsultPaymentsPersistence(Date init, Date end) {
		try {
			List<ConsultEntity> l=consultRepo.findByInitDateBetween(init, end);
			List<ListConsult> ls=new ArrayList<>();
			for (ConsultEntity t:l) {
				ListConsult c=new ListConsult();
				c.setId(t.getId());
				c.setInform(t.getInform());
				c.setInitDate(t.getInitDate());
				c.setNit(t.getNit());
				c.setPaymentDate(t.getPaymentDate());
				c.setPlaca(t.getPlaca());
				c.setPrice(t.getPrice());
				c.setPriceTx1(t.getPriceTx1());
				c.setPriceTx2(t.getPriceTx2());
				c.setStatus(t.getStatus());
				c.setTax1(t.getTax1());
				c.setTax2(t.getTax2());
				ls.add(c);
			}
			
			return ls;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
