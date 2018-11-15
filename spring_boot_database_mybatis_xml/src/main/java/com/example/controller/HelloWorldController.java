package com.example.controller;

import com.example.mapper.*;
import com.example.model.*;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping("/hello")    
    public List<User> index() { 		
		List<User> data =userMapper.getAll();
		
		if(data==null)
			data = new ArrayList<User>();
		
		
        return data;
		        
		//return "string";
    }
	
	@RequestMapping("/getOne")
	public User getOne(String userName)
	{
		User data = userMapper.getOne(userName);
		
		if(data==null)
			data = new User();
		
		return data;
	}
	
	@RequestMapping("/insert")    
	public User insert(String userName)
	{
		User data = new User();
		data.setEmail(userName+"@abc.com");
		data.setNickName(userName);
		data.setPassWord("123");
		data.setRegTime("2018-10-22");
		data.setUserName(userName);
				
		userMapper.insert(data);
		
//		if(result>0)
//			return "插入成功";
//		else return "插入失败";
		
		return data;
	}
	
	@RequestMapping("/update")    
	public String update(Long id,String userName,String nickName)
	{
		User data = new User();
		data.setId(id);
		data.setUserName(userName);
		data.setNickName(nickName);
		
		userMapper.update(data);
		return "更新成功";
	}
	
	@RequestMapping("/delete")    
	public String delete(Long id)
	{
		userMapper.delete(id);
		
		return "删除成功";
	}
}
