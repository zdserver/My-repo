package com.briup.service;

import org.springframework.data.domain.Page;

import com.briup.bean.Drug;
import com.briup.exception.UserEception;

public interface DrugService {

	Page<Drug> findAllDrugs(int i, int j);

	void deleteDrug(int id);

	void addDrug(Drug drug) throws UserEception;

	void updateDrug(Drug drug);

	Drug getDrug(int id);

	Drug findDrugByName(String name, String inventory);

	String findDrugByName1(String name, String inventory);

}
