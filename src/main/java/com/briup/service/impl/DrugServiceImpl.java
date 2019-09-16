package com.briup.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.briup.bean.Drug;
import com.briup.dao.DrugDao;
import com.briup.exception.UserEception;
import com.briup.service.DrugService;
@Service
public class DrugServiceImpl implements DrugService{
	@Autowired
	private DrugDao drugDao;

	@Override
	public Page<Drug> findAllDrugs(int i, int j) {
		PageRequest request = new PageRequest(i, j);
		Page<Drug> pages = drugDao.findAll(request);
		if(pages!=null) {
			return pages;
		}
		return null;
	}
	@Override
	public void deleteDrug(int id) {
		drugDao.delete(id);
		
	}
	@Override
	public void addDrug(Drug drug) throws UserEception {
		Drug dept1 = drugDao.findByName(drug.getName());
		if(dept1==null) {
			drugDao.save(drug);
		}else{
			throw new UserEception("药品名称重复");
		}
		
	}
	@Override
	public Drug getDrug(int id) {
		Drug drug = drugDao.findOne(id);
		return drug;
	}
	@Override
	public void updateDrug(Drug drug) {
		drugDao.save(drug);
		
	}
	@Override
	public Drug findDrugByName(String name, String inventory) {
		Drug drug = drugDao.findByName(name);
		if(drug==null) {
			return null;
		}
		else {
			drug.setInventory(drug.getInventory()+Integer.parseInt(inventory));
			drugDao.save(drug);
		}
		return drug;
	}
	@Override
	public String findDrugByName1(String name, String inventory) {
		Drug drug = drugDao.findByName(name);
		if(drug==null) {
			return "该药品不存在";
		}
		else {
			if(drug.getInventory()<Integer.parseInt(inventory)) {
				return "该药品库存不足";
			}else {
				drug.setInventory(drug.getInventory()-Integer.parseInt(inventory));
				drugDao.save(drug);
				return "OK";
			}
		}
	}

}
