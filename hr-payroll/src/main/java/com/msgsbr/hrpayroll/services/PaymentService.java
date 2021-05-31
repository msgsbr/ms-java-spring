package com.msgsbr.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msgsbr.hrpayroll.entities.Payment;
import com.msgsbr.hrpayroll.entities.Worker;
import com.msgsbr.hrpayroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {
	
	@Autowired
	private WorkerFeignClient workerFeignClient;

	public Payment getPayment(long workerId, int days) {
		
		Map<String, String> uriVariable = new HashMap<>();
		uriVariable.put("id", ""+workerId);
		
		Worker worker = workerFeignClient.findById(workerId).getBody();
		
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
	
}
