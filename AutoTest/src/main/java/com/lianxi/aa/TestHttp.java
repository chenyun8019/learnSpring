package com.lianxi.aa;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

public class TestHttp {
	
	@Test
	public void httpGet() throws ClientProtocolException, IOException{
		String res;
		HttpGet hg=new HttpGet("http://localhost:8890/getwithoutpara");
//		HttpGet hg=new HttpGet("https://www.baidu.com/");
		HttpClient hc=new DefaultHttpClient();
		HttpResponse hp=hc.execute(hg);
		res=EntityUtils.toString(hp.getEntity(),"utf-8");
		System.out.println(res);
		
		
		
	}
}
