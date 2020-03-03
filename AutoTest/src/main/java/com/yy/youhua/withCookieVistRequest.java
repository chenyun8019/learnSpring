package com.yy.youhua;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class withCookieVistRequest {
	String res;
	CookieStore cs;
	ResourceBundle bd;
	String url;
	@BeforeTest
	public void beforeTest(){
		bd=ResourceBundle.getBundle("shuxing");
		url=bd.getString("test.uri");
	}
	@Test
	public void httpGet() throws ClientProtocolException, IOException{ 
		String testUrl;
		testUrl=url+"/"+bd.getString("withpara.uri");
		HttpGet get=new HttpGet(testUrl);
		DefaultHttpClient hc=new DefaultHttpClient();
		HttpResponse response=hc.execute(get);
		res=EntityUtils.toString(response.getEntity(),"utf-8");
		
		System.out.println(res);
		
		this.cs=hc.getCookieStore();
		List<Cookie> listCookie=cs.getCookies();
		System.out.println(listCookie.size());
		for(Cookie ck:listCookie){
			String name=ck.getName();
			String value=ck.getValue();
			System.out.println("name:"+name+" ;value:"+value);
		}
	}
	
	@Test(dependsOnMethods="httpGet")
	public void httpGet2() throws ClientProtocolException, IOException{ 
		String testUrl;
		testUrl=url+""+bd.getString("withoutpara.uri");
		HttpGet get=new HttpGet(testUrl);
		DefaultHttpClient hc=new DefaultHttpClient();
		hc.setCookieStore(this.cs);
		HttpResponse response=hc.execute(get);
		res=EntityUtils.toString(response.getEntity(),"utf-8");
		//获取response中的状态码
		int res1=response.getStatusLine().getStatusCode();
		
		System.out.println(res);
		System.out.println(res1);
		
//		this.cs=hc.getCookieStore();
//		List<Cookie> listCookie=cs.getCookies();
//		System.out.println(listCookie.size());
//		for(Cookie ck:listCookie){
//			String name=ck.getName();
//			String value=ck.getValue();
//			System.out.println("name:"+name+" ;value:"+value);
//		}
	}

}
