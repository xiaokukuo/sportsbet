package com.sport.bet.common.utils;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpTool {
	
	/**
	 * 创建 json的 HttpGet请求
	 * @param url
	 * @param jsonData
	 * @return
	 */
	private static HttpGet newHttpGet365(String url){
		
		String cookie = "aps03=oty=2&cg=0&cst=0&tzi=27&hd=N&lng=10&cf=N&ct=42; rmbs=3; pstk=F29C56B7654B43B1B45E5F8151659114000003; bs=bt=1&mo=0&fs=0||&; session=processform=0&id=%7B7A229C4E%2DDA6F%2D4F3D%2DB6C4%2DC745A3CC6EE8%7D&fms=1";
		HttpGet request = new HttpGet(url); // 创建httget
		request.addHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:60.0) Gecko/20100101 Firefox/60.0");
		request.addHeader("Cookie",cookie);
		request.addHeader("Host", "www.365sport365.com");
		request.addHeader("Accept", "*/*");
		
		request.addHeader("Accept-Language", "zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2");
		request.addHeader("Accept-Encoding", "gzip, deflate, br*");
		request.addHeader("Referer", "https://www.365sport365.com/");
		
		return request;
	}
	
	public static String getSport365(String url){
		HttpGet request = newHttpGet365(url);
		try {
			
			HttpClient httpclient = HttpClients.createDefault(); // 创建httpclient
			HttpResponse response = httpclient.execute(request);
			
			StatusLine statusLine = response.getStatusLine();

			if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
				HttpEntity entity = response.getEntity();
				String responseStr = EntityUtils.toString(entity);
				return responseStr;
			} 
			
			System.err.println("发送失败");
		
		} catch (IOException e) {
			System.err.println("发送失败"+e);
		}
		return null;
	}
	
}
