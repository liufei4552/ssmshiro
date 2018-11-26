package com.beautifulsoup.shiro.ssmdemo.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/item")
@Controller
public class ItemController {
	
	@RequestMapping("/delete02")
	@RequiresPermissions("item:delete:02")
	public String itemDelete(){
		
		
		return "delete02item";
	}
	
	@RequiresPermissions("item:query")
	@RequestMapping("/query")
	public String ItemQuery(){
		return "itemquery";
	}
}
