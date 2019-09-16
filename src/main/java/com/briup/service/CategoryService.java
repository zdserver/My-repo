package com.briup.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.briup.bean.Category;
import com.briup.exception.UserEception;

public interface CategoryService {

	Page<Category> findAllCategorys(int i, int j);

	void deleteCategory(int id);

	void addCategory(Category category) throws UserEception;

	Category getCategory(int id);

	void updateCategory(Category category);

	List<Category> findAllCategory();
}
