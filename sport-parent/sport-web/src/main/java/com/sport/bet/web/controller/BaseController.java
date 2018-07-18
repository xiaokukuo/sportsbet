package com.sport.bet.web.controller;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sport.bet.common.test.ANSIMacBySms4Utils;
import com.sport.bet.common.test.Hex;

@RestController
public class BaseController {

	private static String key = "11111111111111111111111111111111";
	
	@RequestMapping("/")
	public String home(){
		
		return "Hello World!";
	}
	@ResponseBody
	@RequestMapping(value="/mactno")
	public Object allNotrim(@RequestBody String data) throws UnsupportedEncodingException{
		if(data.contains("\r") ||data.contains("\n") || data.contains("\r\n")|| data.contains("\t")){
		    System.out.println("yyyyyyy");
		}else{
		    System.out.println("nnnnnnn");
		}
		
		String macStr = ANSIMacBySms4Utils.getMac99(key, data);
		
		
		return macStr;
	}
	
	@ResponseBody
	@RequestMapping(value="/mactest")
	public Object all(@RequestBody String data) throws UnsupportedEncodingException{
		
		Pattern p = Pattern.compile("\\s{2,}|\t|\r|\n");
        Matcher m = p.matcher(data);
        data = m.replaceAll("");
        System.out.println(data.length());
        System.out.println(data);
		String macStr = ANSIMacBySms4Utils.getMac99(key, data);
		return macStr;
	}
	
	@ResponseBody
	@RequestMapping(value="/hex")
	public Object hex(@RequestBody String data) throws UnsupportedEncodingException, GeneralSecurityException{
		
		System.err.println("hex data:"+data);
		byte[] result99 = ANSIMacBySms4Utils.calculateANSIX9_9MAC(Hex.decode(key), Hex.decode(data)); 
	    String response = Hex.encode(result99);
	     
	    System.err.println("response:"+response);
		return response;
	}
	
}
