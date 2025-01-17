package com.api.vehicles.aplication.ports.inputs;

import com.api.vehicles.domain.ProcessPayment;
import com.api.vehicles.domain.ResponsePayment;

public interface ProcessPaymentApiPort {
	public ResponsePayment processPaymentApi(ProcessPayment payment,Long id);
	public ResponsePayment processPaymentApiResponse(ProcessPayment payment,Long id);
}
