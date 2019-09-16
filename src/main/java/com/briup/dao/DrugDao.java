package com.briup.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.briup.bean.Drug;

public interface DrugDao extends JpaRepository<Drug, Integer>{
	Drug findByName(String name);
}
