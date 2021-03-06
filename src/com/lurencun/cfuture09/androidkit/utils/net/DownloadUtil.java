/*
 * @(#)DownloadUtil.java		       Project:com.sinaapp.msdxblog.androidkit
 * Date:2012-3-17
 *
 * Copyright (c) 2011 CFuture09, Institute of Software, 
 * Guangdong Ocean University, Zhanjiang, GuangDong, China.
 * All rights reserved.
 */
package com.lurencun.cfuture09.androidkit.utils.net;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.lurencun.cfuture09.androidkit.utils.lang.Log4AK;

/**
 * 下载工具类。
 * 
 * @author Geek_Soledad (66704238@51uc.com)
 */
public class DownloadUtil {
	private static final Log4AK log = Log4AK.getLog(DownloadUtil.class);

	/**
	 * 下载指定的内容。
	 * 
	 * @param url
	 *            请求下载的地址。
	 */
	public static String downloadString(String url) {
		DefaultHttpClient client = null;
		try {
			client = new DefaultHttpClient();
			HttpGet request = new HttpGet(url);
			HttpResponse response = client.execute(request);
			return EntityUtils.toString(response.getEntity());
		} catch (IOException e) {
			log.w(e);
		} finally {
			if (client != null) {
				client.getConnectionManager().shutdown();
			}
		}
		return null;
	}
}
