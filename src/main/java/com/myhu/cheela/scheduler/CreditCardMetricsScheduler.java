package com.myhu.cheela.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.myhu.cheela.services.CreditCardMetricsService;

@Component
public class CreditCardMetricsScheduler {

	@Autowired
	CreditCardMetricsService service;
	
	
	@Scheduled(fixedDelay=60000)
	public void runTransactionMertics() {
		service.publishTransactionMertics();
	}
}
