package com.myhu.cheela.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myhu.cheela.entity.Predictions;

import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.Counter;

@Component
public class CreditCardMetricsService {
	
	Counter counter;
	List<Predictions> trans=new ArrayList<>();
	List<String> postedTrans=new ArrayList<>();
	
	@Autowired
	private DashboardService dashboardService;
	
	@PostConstruct
	public void init() {
		counter = Counter.build().name("transaction_counter").help("Total number of transactions").
				labelNames("trans_num", "trans_type", "cc_num", "trans_time","category","merchant","merch_lat","merch_long","amt","age","is_fraud").register();
	}
	
	@PreDestroy
	public void destroy() {
		CollectorRegistry.defaultRegistry.unregister(counter);
	}

	public void publishTransactionMertics() {
		trans = dashboardService.getPredictions();
		for(Predictions predictions: trans ){
			if(!postedTrans.contains(predictions.getTrans_num())) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(predictions.getIs_fraud().equals("1"))
					counter.labels(predictions.getTrans_num(),"Fraud",predictions.getCc_num(),predictions.getTrans_time(),
						predictions.getCategory(),predictions.getMerchant(),predictions.getMerch_lat().toString(),predictions.getMerch_long().toString(),
						predictions.getAmt().toString(),predictions.getAge(),predictions.getIs_fraud()).inc();
				else
					counter.labels(predictions.getTrans_num(),"NonFraud",predictions.getCc_num(),predictions.getTrans_time(),
							predictions.getCategory(),predictions.getMerchant(),predictions.getMerch_lat().toString(),predictions.getMerch_long().toString(),
							predictions.getAmt().toString(),predictions.getAge(),predictions.getIs_fraud()).inc();
				postedTrans.add(predictions.getTrans_num());
			}
		}
	}
	
}
