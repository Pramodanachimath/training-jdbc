package com.policyapp.service.dao;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.policyapp.model.Policy;
import com.policyapp.service.exception.IdNotFoundException;
import com.policyapp.service.exception.PolicyNotFoundException;

public class PolicyDAOImpl implements IPolicyDAO {

	@Override
	public List<Policy> findAll() {
		return showAllPolicies();
	}

	@Override
	public List<Policy> findByType(String policy) throws PolicyNotFoundException {

		List<Policy> policyList = showAllPolicies();

		return policyList.stream().filter((type -> type.getType().startsWith("t")))
				.sorted((p1, p2) -> p1.getPolicyName().compareTo(p2.getPolicyName())).collect(Collectors.toList());

	}

	@Override
	public List<Policy> findByCategory(String category) throws PolicyNotFoundException {
		List<Policy> policyList = showAllPolicies();

		return policyList.stream().filter((type -> type.getCategory().endsWith("e")))
				.sorted((p1, p2) -> p1.getPolicyName().compareTo(p2.getPolicyName())).collect(Collectors.toList());
	}

	@Override
	public List<Policy> findByHighSumAssured(double sumAssured) throws PolicyNotFoundException {

		List<Policy> policyList = showAllPolicies();

		return policyList.stream().filter((type -> type.getSumAssured() > 1000))
				.sorted((p1, p2) -> p1.getPolicyName().compareTo(p2.getPolicyName())).collect(Collectors.toList());
	}

	@Override
	public List<Policy> findByCoverage(String coverage) throws PolicyNotFoundException {
		List<Policy> policyList = showAllPolicies();

		return policyList.stream().filter((type -> type.getCoverage().contains("s")))
				.sorted((p1, p2) -> p1.getPolicyName().compareTo(p2.getPolicyName())).collect(Collectors.toList());
	}

	@Override
	public List<Policy> findByLessPremium(double premium) throws PolicyNotFoundException {

		List<Policy> policyList = showAllPolicies();

		return policyList.stream().filter((type -> type.getPremium() > 2000))
				.sorted((p1, p2) -> p1.getPolicyName().compareTo(p2.getPolicyName())).collect(Collectors.toList());

	}

	@Override
	public Policy findById(int policyId) throws IdNotFoundException {
		Optional<Policy> policyById = showAllPolicies().stream().filter(policy->policy.getPolicyNumber()>2000).sorted((p1,p2)->p1.getPolicyName().compareTo(p2.getPolicyName())).findFirst();

		if(policyById.isPresent()) {
			return policyById.get();
		}
		return null;

	}

	private List<Policy> showAllPolicies() {
		return Arrays.asList(new Policy("Jeevan sathi", 1001, 2000, 10, "Marriage", "life", 2000, "term"),
				new Policy("Jeevan Anand", 1001, 3000, 40, "life", "life", 2000, "endowment"),
				new Policy("Life saral", 1001, 16000, 50, "retirment", "life", 2000, "pension"),
				new Policy("Bajaj Allianz", 1001, 2000, 20, "pension", "life", 2000, "endowment"),
				new Policy("Tata Allianz", 1001, 2000, 40, "sickness", "life", 2000, "term"),
				new Policy("ClickToProtect", 1001, 2000, 60, "Marriage", "life", 2000, "term"));

	}

}
