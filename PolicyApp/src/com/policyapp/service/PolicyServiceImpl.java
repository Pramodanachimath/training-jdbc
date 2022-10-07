package com.policyapp.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.policyapp.model.Policy;
import com.policyapp.service.dao.IPolicyDAO;
import com.policyapp.service.dao.PolicyDAOImpl;
import com.policyapp.service.exception.IdNotFoundException;
import com.policyapp.service.exception.PolicyNotFoundException;

public class PolicyServiceImpl implements IPolicyService {

	IPolicyDAO policyDao = new PolicyDAOImpl();

	@Override
	public List<Policy> getAll() {

		List<Policy> policies = new PolicyDAOImpl().findAll();

		List<Policy> policyList = policies.stream().sorted((p1, p2) -> p1.getPolicyName().compareTo(p2.getPolicyName()))
				.collect(Collectors.toList());

		return policyList;
	}

	@Override
	public List<Policy> getByType(String policy) throws PolicyNotFoundException {

		List<Policy> policies = new PolicyDAOImpl().findByType(policy);

		return policies.stream().filter((type -> type.getType().startsWith("t")))
				.sorted((p1, p2) -> p1.getPolicyName().compareTo(p2.getPolicyName())).collect(Collectors.toList());
	}

	@Override
	public List<Policy> getByCategory(String category) throws PolicyNotFoundException {
		List<Policy> policies = new PolicyDAOImpl().findByCategory(category);

		return policies.stream().filter((type -> type.getCategory().endsWith("e")))
				.sorted((p1, p2) -> p1.getPolicyName().compareTo(p2.getPolicyName())).collect(Collectors.toList());
	}

	@Override
	public List<Policy> getByHighSumAssured(double sumAssured) throws PolicyNotFoundException {
		List<Policy> policies = new PolicyDAOImpl().findByHighSumAssured(sumAssured);
		return policies.stream().filter((type -> type.getSumAssured() > 1000))
				.sorted((p1, p2) -> p1.getPolicyName().compareTo(p2.getPolicyName())).collect(Collectors.toList());

	}

	@Override
	public List<Policy> getByCoverage(String coverage) throws PolicyNotFoundException {
		List<Policy> policies = new PolicyDAOImpl().findByCoverage(coverage);

		return policies.stream().filter((type -> type.getCoverage().contains("s")))
				.sorted((p1, p2) -> p1.getPolicyName().compareTo(p2.getPolicyName())).collect(Collectors.toList());
	}

	@Override
	public List<Policy> getByLessPremium(double premium) throws PolicyNotFoundException {
		List<Policy> policies = new PolicyDAOImpl().findByLessPremium(premium);

		return policies.stream().filter((type -> type.getPremium() > 2000))
				.sorted((p1, p2) -> p1.getPolicyName().compareTo(p2.getPolicyName())).collect(Collectors.toList());
   
		
	}

	@Override
	public Policy getById(int policyId) throws IdNotFoundException {
		Policy policyById=policyDao.findById(policyId);
		if(policyById!=null) {
			return policyById;
		}
		throw new IdNotFoundException("Id Not found");

	}

}
