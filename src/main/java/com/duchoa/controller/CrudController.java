package com.duchoa.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.duchoa.entity.PLanguage;
import com.duchoa.dao.PLanguageDAO;

@Controller
@RequestMapping(value="crud")
public class CrudController {
	
	@Autowired
	PLanguageDAO dao;
	
	@RequestMapping()
	public String initiate(ModelMap model) {
		model.addAttribute("forum", new PLanguage());
		model.addAttribute("forums", dao.getAll());
		return "index";
	}
	
	@RequestMapping(params ="insert", method= RequestMethod.POST)
	public String insert(@ModelAttribute("forum") PLanguage forum, ModelMap model) {
		try {
			PLanguage f = dao.getById(forum.getId());
			if(f != null) {
				model.addAttribute("message", "Tồn tại id");
				model.addAttribute("forums", dao.getAll());
				return "index";
			}
			dao.insert(forum);
			model.addAttribute("message", "Thêm mới thành công");
			
			
		}
		catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("message", "Thêm mới thất bại");
		}
		return initiate(model);

	}

	@RequestMapping(params ="update", method= RequestMethod.POST)
	public String update(@ModelAttribute("forum") PLanguage forum, ModelMap model) {
		try {
			dao.update(forum);
			model.addAttribute("forums", dao.getAll());
			model.addAttribute("message", "Cập nhật thành công");
		}
		catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("message", "Cập nhật thành công");
		}
		
		return "index";
	}
	
	@RequestMapping(params ="delete")
	public String delete(@RequestParam("id") Integer id, ModelMap model) {
		try {
			dao.delete(id);
			model.addAttribute("message", "Xóa thành công");
		}
		catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("message", "Xóa không thành công");
		}
		return initiate(model);
	}
	
	@RequestMapping(params ="edit")
	public String edit(@RequestParam("id") Integer id, ModelMap model) {
		try {
			PLanguage f = dao.getById(id);
			model.addAttribute("forum", f);
			model.addAttribute("forums", dao.getAll());
			
		}
		catch (Exception e) {
			// TODO: handle exception
			
		}
		
		return "index";
	}
}
