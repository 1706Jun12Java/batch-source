package com.revature.client;
import java.util.ArrayList;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.revature.domain.BatType;

public class BatClient {
	
	private String resourceUrl;
	private RestTemplate restTemplate;
	
	public void setResourceUrl(String resourceUrl){
		this.resourceUrl = resourceUrl;
	}
	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public ArrayList<BatType> getBatTypes(){
		ResponseEntity<? extends ArrayList<BatType>> response = 
				this.restTemplate.getForEntity(this.resourceUrl+"/type/all", (Class<? extends ArrayList<BatType>>)ArrayList.class);
		return response.getBody();
	}
	
	public BatType saveBatType(BatType batType){
		HttpEntity<BatType> request = new HttpEntity<BatType>(batType);
		return this.restTemplate.postForObject(this.resourceUrl+"/type",request,BatType.class);
	}

}
