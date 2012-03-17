package br.com.caelum.fj91;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;


public class PegaXmlDoFlickr {
	public static void main(String[] args) throws HttpException, IOException {
		// Se a key estiver invalida, acesse:
		// http://www.flickr.com/services/api/explore/?method=flickr.interestingness.getList
		HttpClient client = new HttpClient();
		GetMethod get = new GetMethod("http://api.flickr.com/services/rest/?method=flickr.interestingness.getList" +
				"&api_key=81abd32cd0747e05b7e0b2ce0c804886");
		client.executeMethod(get);
		String xml = get.getResponseBodyAsString();
		System.out.println(xml);
	}
}