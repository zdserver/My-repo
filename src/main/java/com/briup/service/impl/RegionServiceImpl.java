package com.briup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.bean.Region;
import com.briup.dao.RegionDao;
import com.briup.service.RegionService;

@Service
public class RegionServiceImpl implements RegionService{
	@Autowired
	private RegionDao regiondao;

	@Override
	public void deleteRegion(int id) {
		regiondao.delete(id);
		
	}

	@Override
	public void addRegion(Region region) {
		regiondao.save(region);
;		
	}

	@Override
	public void updateRegion(Region region) {
		regiondao.save(region);
		
	}

	@Override
	public Region getRegion(int id) {
		Region region = regiondao.getOne(id);
		return region;
	}

	@Override
	public List<Region> findAllRegions() {
		List<Region> list = regiondao.findAll();
		return list;
	}
	

}
