package com.briup.service;

import java.util.List;


import com.briup.bean.Region;

public interface RegionService {
	public void deleteRegion(int id);
	public void addRegion(Region region);
	public void updateRegion(Region region);
	public Region getRegion(int id);
	public List<Region> findAllRegions();
}
