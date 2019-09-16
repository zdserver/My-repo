package com.briup.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.bean.Category;
import com.briup.bean.Drug;
import com.briup.exception.UserEception;
import com.briup.service.CategoryService;
import com.briup.service.DrugService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
@Api(value = "Medicine|用于药房管理的控制器")
@RestController
public class MedicineManagerMan {
	@Autowired
	private CategoryService caService;
	@Autowired
	private DrugService drugService;
	@RequestMapping(value="/category/{id}",method=RequestMethod.DELETE)
	public String test(@PathVariable(value="id",required=false) int id) {
		caService.deleteCategory(id);
		return "OK";
	}
	@RequestMapping(value="/category",method=RequestMethod.POST)
	public String test1(Category category) {
		try {
			caService.addCategory(category);
			return "OK";
		} catch (UserEception e) {
			return e.getMessage();
		}
	}
	@RequestMapping(value="/category/{id}",method=RequestMethod.GET)
	@ApiOperation(value="查询药品", notes="根据用户id查询")
	@ApiImplicitParam(paramType="query", name = "id", value = "用户ID", required = true, dataType = "Integer")
	public Category test3(@PathVariable(value="id",required=false) int id) {
		Category category = caService.getCategory(id);
		return category;
	}
	@RequestMapping(value="/category",method=RequestMethod.PUT)
	public String test4(Category category) {
		caService.updateCategory(category);
		return "修改成功";
	}
	@RequestMapping(value="/category",method=RequestMethod.DELETE)
	public String test5(@RequestParam("ids") int[] id) {
		for(int i=0;i<id.length;i++) {
			caService.deleteCategory(id[i]);
		}
		return "OK";
	}
	
	
	@RequestMapping(value="/selectCategory",method=RequestMethod.GET)
	public List<Category> test00() {
		List<Category> list = caService.findAllCategory();
		return list;
	}
	@RequestMapping(value="/medicineStorge",method=RequestMethod.GET)
	public Drug test01(HttpServletRequest request) {
		String name = request.getParameter("name");
		String inventory = request.getParameter("inventory");
		Drug drug = drugService.findDrugByName(name,inventory);
		return drug;
	}
	@RequestMapping(value="/medicineGetting",method=RequestMethod.GET)
	public String test02(HttpServletRequest request) {
		String name = request.getParameter("name");
		String inventory = request.getParameter("inventory");
		String str= drugService.findDrugByName1(name,inventory);
		return str;
	}
	@RequestMapping(value="/drug/{id}",method=RequestMethod.DELETE)
	public String test6(@PathVariable(value="id",required=false) int id) {
		drugService.deleteDrug(id);
		return "OK";
	}
	@RequestMapping(value="/drug",method=RequestMethod.POST)
	public String test7(Drug drug) {
		try {
			drugService.addDrug(drug);
			return "OK";
		} catch (UserEception e) {
			return e.getMessage();
		}
	}
	@RequestMapping(value="/drug/{id}",method=RequestMethod.GET)
	public Drug test8(@PathVariable(value="id",required=false) int id) {
		Drug category = drugService.getDrug(id);
		return category;
	}
	@RequestMapping(value="/drug",method=RequestMethod.PUT)
	public String test9(Drug drug) {
		drugService.updateDrug(drug);
		return "修改成功";
	}
	@RequestMapping(value="/drug",method=RequestMethod.DELETE)
	public String test10(@RequestParam("ids") int[] id) {
		for(int i=0;i<id.length;i++) {
			drugService.deleteDrug(id[i]);
		}
		return "OK";
	}
}
