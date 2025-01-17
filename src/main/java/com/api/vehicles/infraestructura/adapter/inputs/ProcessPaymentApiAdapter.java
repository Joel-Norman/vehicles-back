package com.api.vehicles.infraestructura.adapter.inputs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.vehicles.aplication.ports.inputs.ProcessPaymentApiPort;
import com.api.vehicles.aplication.ports.outputs.ProccessPaymentPort;
import com.api.vehicles.domain.ProcessPayment;
import com.api.vehicles.domain.ResponsePayment;
@Service
public class ProcessPaymentApiAdapter implements ProcessPaymentApiPort {
	@Autowired
	ProccessPaymentPort portPayment;
	@Override
	public ResponsePayment processPaymentApi(ProcessPayment payment,Long id) {
		// TODO Auto-generated method stub
		return portPayment.processPaymentApi(payment,id);
	}
	@Override
	public ResponsePayment processPaymentApiResponse(ProcessPayment payment, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
