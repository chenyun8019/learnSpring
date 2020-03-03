package com.yy.youhua;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GetCookise {
	
	private String url;
	private ResourceBundle bd; 
	
	@BeforeTest
	public void getCookies(){
		bd=ResourceBundle.getBundle("shuxing",Locale.CHINA);
		url=bd.getString("test.uri");
	}
	
	@Test
	public void testGet() throws ClientProtocolException, IOException{
		String res;
		String testUrl=url+"/"+bd.getString("withpara.uri");
		System.out.println(testUrl);
		HttpGet hg=new HttpGet(testUrl);
		DefaultHttpClient hc=new DefaultHttpClient ();
		HttpResponse resp=hc.execute(hg);
		res=EntityUtils.toString(resp.getEntity(),"utf-8");
		System.out.println(res);
		
		CookieStore cook=hc.getCookieStore();
		List<Cookie> CookList=cook.getCookies(); 
		int s=CookList.size();
		System.out.println(s);
		
		for(Cookie cook1:CookList){
			String name=cook1.getName();
			String value=cook1.getValue();
			System.out.println("Cook的Key是:"+name+"; Cook的Value是:"+value);
		}
		
	}
}
