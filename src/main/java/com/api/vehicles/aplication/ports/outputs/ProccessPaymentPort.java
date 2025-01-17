package com.api.vehicles.aplication.ports.outputs;

import com.api.vehicles.domain.ProcessPayment;
import com.api.vehicles.domain.ResponsePayment;

public interface ProccessPaymentPort {
	public ResponsePayment processPaymentApi(ProcessPayment payment,Long id);
}
