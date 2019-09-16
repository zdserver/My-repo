package com.briup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.briup.bean.Category;
import com.briup.dao.CategoryDao;
import com.briup.exception.UserEception;
import com.briup.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	private CategoryDao catDao;
	@Override
	public Page<Category> findAllCategorys(int i, int j) {
		PageRequest request = new PageRequest(i, j);
		Page<Category> pages = catDao.findAll(request);
		if(pages!=null) {
			return pages;
		}
		return null;
	}
	@Override
	public void deleteCategory(int id) {
		catDao.delete(id);
		
	}
	@Override
	public void addCategory(Category category) throws UserEception {
		Category dept1 = catDao.findByName(category.getName());
		if(dept1==null) {
			catDao.save(category);
		}else{
			throw new UserEception("药品名称重复");
		}
		
	}
	@Override
	public Category getCategory(int id) {
		Category category = catDao.findOne(id);
		return category;
	}
	@Override
	public void updateCategory(Category category) {
		catDao.save(category);
		
	}
	@Override
	public List<Category> findAllCategory() {
		List<Category> list = catDao.findAll();
		if(list!=null) {
			return list;
		}
		return null;
	}
}
