package com.policyapp.client;

import com.policyapp.service.IPolicyService;
import com.policyapp.service.PolicyServiceImpl;
import com.policyapp.service.exception.IdNotFoundException;
import com.policyapp.service.exception.PolicyNotFoundException;

public class UserClass {

	public static void main(String[] args) {

		IPolicyService policyService = new PolicyServiceImpl();
		System.out.println("get By All");
		policyService.getAll().forEach(System.out::println);
		System.out.println();

		System.out.println("get By Type");

		try {
			policyService.getByType("term").forEach(System.out::println);
		} catch (PolicyNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();

		System.out.println("get By category");
		try {
			policyService.getByCategory("life").forEach(System.out::println);
			System.out.println();
		} catch (PolicyNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//
		System.out.println("get By Coverage");
		try {
			policyService.getByCoverage("life").forEach(System.out::println);
			System.out.println();
		} catch (PolicyNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("get By HighSumAssured");
		try {
			policyService.getByHighSumAssured(2000).forEach(System.out::println);
			System.out.println();
		} catch (PolicyNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("get By LessPremium");

		try {
			policyService.getByLessPremium(2000).forEach(System.out::println);
			System.out.println();
		} catch (PolicyNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("get By Id");
		try {
			policyService.getById(1001);
		} catch (IdNotFoundException e) {
			e.printStackTrace();
		}
	}

}
