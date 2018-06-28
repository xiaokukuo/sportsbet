package com.sport.bet.common.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
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
	
	
	
	private static HttpPost newHttpPost188(String url){
		HttpPost request = new HttpPost(url); // 创建httget
		
		//request.addHeader("Accept", "*/*");
		/*request.addHeader("Accept-Encoding", "gzip, deflate, br");
		request.addHeader("Accept-Language", "zh-CN,zh;q=0.9");
		request.addHeader("Connection", "keep-alive");
		request.addHeader("Content-Length", "404");
		request.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		request.addHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.75 Safari/537.36");
		request.addHeader("Cookie",cookie);
		request.addHeader("Host", "landing-sb.prdasbb18a1.com");
		request.addHeader("Referer", "https://landing-sb.prdasbb18a1.com/zh-cn/sports/basketball/competition/full-time-asian-handicap-and-over-under");
		
		request.addHeader("Origin", "https://landing-sb.prdasbb18a1.com");
		request.addHeader("X-Requested-With", "XMLHttpRequest");*/
		
		return request;
	}
	
	public static String getSport188(String url){
		HttpPost request = newHttpPost188(url);
		
		Map<String,String> map = new HashMap<String,String>();
		/*map.put("CompetitionID", "-1");
		map.put("IsEventMenu",	"false");*/
		map.put("IsFirstLoad",	"true");
	/*	map.put("LiveCenterEventId", "0");
		map.put("LiveCenterSportId", "0");
		map.put("oIsFirstLoad",	"false");
		map.put("oIsInplayAll",	"false");
		map.put("oOddsType", "0");
		map.put("oPageNo",	"0");
		map.put("oSortBy",	"1");
		map.put("oVersion",	"63407");*/
		map.put("reqUrl",	"/zh-cn/sports/basketball/competition/full-time-asian-handicap-and-over-under");
	/*	map.put("SportID",	"1");
		map.put("VersionF",	"-1");
		map.put("VersionH",	"1:0,2:0,3:0,4:0,9:0,13:0,16:0");
		map.put("VersionL",	"-1");
		map.put("VersionS",	"-1");
		map.put("VersionT",	"-1");
		map.put("VersionU",	"0");*/
		
		ArrayList<BasicNameValuePair> pairs = new ArrayList<BasicNameValuePair>();// 用于存放表单数据.
		// 遍历map 将其中的数据转化为表单数据
		for (Map.Entry<String, String> entry : map.entrySet()) {
			pairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
		}
		//对表单数据进行url编码
       
		try {
			UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(pairs);
		    request.setEntity(urlEncodedFormEntity);
			
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
	
	
	private static HttpGet newHttpGetPin111(String url){
		HttpGet request = new HttpGet(url); // 创建httget
		request.addHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");
		return request;
	}
	
	public static String getSportPin111(String url){
		HttpGet request = newHttpGetPin111(url);
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
	
	
	private static HttpGet newHttpGetU16888(String url){
		
		String cookie = "_ga=GA1.2.935692521.1529271305; _gid=GA1.2.1130277983.1529271305; bs-info=; ASP.NET_SessionId=zhqey125fdzextjqozlxpitn; odnbv9=16843018.20480.0000; tag-id=/PTEyJHSN5ylUd6X00HK+g==; ting=3";
		
		HttpGet request = new HttpGet(url); // 创建httget
		request.addHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:60.0) Gecko/20100101 Firefox/60.0");
		request.addHeader("Cookie",cookie);
		request.addHeader("Host", "www.u16888.com");
		request.addHeader("Accept-Language", "zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2");
		request.addHeader("Accept-Encoding", "gzip, deflate");
		request.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		
		request.addHeader("Referer", "http://www.u16888.com/zh-cn/euro");
		request.addHeader("Origin", "https://landing-sb.prdasbb18a1.com");
		request.addHeader("Upgrade-Insecure-Requests", "1");
		
		return request;
	}
	
	public static String getSportU16888(String url){
		HttpGet request = newHttpGetU16888(url);
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
