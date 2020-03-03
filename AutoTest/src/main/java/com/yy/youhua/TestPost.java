package com.yy.youhua;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestPost {
	String url;
	String res;
	ResourceBundle bd;
	CookieStore cs;
	
	@BeforeTest
	public void beforeTest(){
		bd=ResourceBundle.getBundle("shuxing");
		url=bd.getString("test.uri");
		
	}
	
	@Test
	public void httpGet() throws ClientProtocolException, IOException { 
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
	public void testPost() throws ClientProtocolException, IOException{
		String testUrl;
		testUrl=url+"/"+bd.getString("post.uri");
		HttpPost post=new HttpPost(testUrl);
		DefaultHttpClient hc=new DefaultHttpClient();
		JSONObject json = new JSONObject();
		json.put("name", "cy");
		json.put("sex", "man");
		post.setHeader("content-type", "application/json");
		hc.setCookieStore(this.cs);
		StringEntity se=new StringEntity(json.toString(),"utf-8");
		post.setEntity(se);
		HttpResponse rs=hc.execute(post);
		
		res=EntityUtils.toString(rs.getEntity(),"utf-8");
		System.out.println(res);
		
		//响应结果判断
		JSONObject js=new JSONObject(res);
		String name=(String) js.get("name");
		System.out.println(name);
		String age=(String) js.get("age");
		System.out.println(age);
		Assert.assertEquals("chenyun", name);
		Assert.assertEquals("31", age);
		
		
		
		
	}

}
