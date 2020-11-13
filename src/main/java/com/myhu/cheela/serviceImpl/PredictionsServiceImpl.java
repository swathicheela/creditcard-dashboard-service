package com.myhu.cheela.serviceImpl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myhu.cheela.entity.Predictions;
import com.myhu.cheela.repository.FruadTransactionRepository;
import com.myhu.cheela.services.DashboardService;

@Component
public class PredictionsServiceImpl implements DashboardService{
	
	@Autowired
	private FruadTransactionRepository fraudRepository;

	@Override
	public List<Predictions> getPredictions() {
		return fraudRepository.findAll();
	}

}
