package com.zzkj.xyw.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zzkj.xyw.model.Remark;
import com.zzkj.xyw.model.Topic;
import com.zzkj.xyw.service.IRemarkService;
import com.zzkj.xyw.service.ITopicService;

@Controller
public class TopicControlller {

	@Autowired
	private ITopicService topicService;
	@Autowired
	private IRemarkService remarkService;
	
	// 添加评论
	@RequestMapping(value = "/user/addTopic")
	public String addTopic(Topic topic, Model model, HttpSession session) {
		
		
		topicService.create(topic);
//		try {
//			topicService.create(topic);
//			model.addAttribute("msg", "发布评论成功！");
//		} catch (Exception e) {
//			// TODO: handle exception
//			model.addAttribute("msg", "发布评论失败！");
//		}
		return "/success";
	}
	
	
	// 添加回复
	@RequestMapping(value = "/user/addRemark")
	public String addRemark(Remark remark, Model model, HttpSession session) {
		
		
		remarkService.create(remark);
//			try {
//				topicService.create(topic);
//				model.addAttribute("msg", "发布评论成功！");
//			} catch (Exception e) {
//				// TODO: handle exception
//				model.addAttribute("msg", "发布评论失败！");
//			}
		return "/success";
	}
	
	// 删除评论
	@RequestMapping(value = "/user/deleteTopic")
	public String deleteTopic(String[] tpid, Model model) {

		try {
			topicService.delete(tpid);
			model.addAttribute("msg", "删除评论成功！");
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("msg", "删除评论失败！");
		}
		
		return "/success";
	}
	
	// 删除回复
	@RequestMapping(value = "/user/deleteRemark")
	public String deleteRemark(String[] rid, Model model) {

		try {
			remarkService.delete(rid);
			model.addAttribute("msg", "删除回复成功！");
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("msg", "删除回复失败！");
		}
		
		return "/success";
	}
}
