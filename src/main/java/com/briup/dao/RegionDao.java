package com.briup.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.briup.bean.Region;

public interface RegionDao extends JpaRepository<Region, Integer>{
	public Region findByHisname(String name);
}
