package br.com.caelum.fj91.rest;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;

public class Cliente {

	public static void main(String[] args) throws HttpException, IOException {

//		String url = "http://localhost:8080/users/1";
		String url = "http://localhost:8080/users";
		
		HttpClient client = new HttpClient();
		GetMethod get = new GetMethod(url);
		client.executeMethod(get);
		
		String response = get.getResponseBodyAsString();

		System.out.println(response);
		
		// CLI:
		// curl -i -X GET http://localhost:8080/users/1
		// curl -i -X GET http://localhost:8080/users
	}

}
