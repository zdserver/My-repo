package com.briup.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.bean.Region;
import com.briup.service.RegionService;

@RestController
public class RegionController {
	String msg=null;
	@Autowired
	private RegionService regionser;
	@RequestMapping(value="/insert")
	public String test() throws ParseException {
		Region region=new Region(null,"北京","儿童医院","二甲",new SimpleDateFormat("yyyy-MM-dd").parse("2018-09-12"));
		regionser.addRegion(region);
		return "插入成功";
	}
	@RequestMapping(value="/update")
	public String test1() throws ParseException {
		Region region=new Region(1,"上海","儿童医院","二甲",new SimpleDateFormat("yyyy-MM-dd").parse("2018-09-12"));
		regionser.updateRegion(region);
		return "更新成功";
	}
	@RequestMapping(value="/delete")
	public String test2() {
		Region region = regionser.getRegion(1);
		if(region==null) {
			msg="该用户不存在";
		}else {
			regionser.deleteRegion(1);
			msg="删除成功";
		}
		return msg;
	}
	@RequestMapping(value="/select")
	public String test3() {
		Region region = regionser.getRegion(1);
		if(region==null) {
			msg="查询不到";
		}else {
			msg="查询成功";
		}
		return region.toString();
	}
	@RequestMapping(value="/selects")
	public String test4() {
		List<Region> list = regionser.findAllRegions();
		for(Region r:list) {
			System.out.println(r);
		}
		return "OK";
	}
	
}
