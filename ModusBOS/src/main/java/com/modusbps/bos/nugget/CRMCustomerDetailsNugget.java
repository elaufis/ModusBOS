package com.modusbps.bos.nugget;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class CRMCustomerDetailsNugget extends AbstractNugget {
	private String mobilePhoneNumber;
	
	public CRMCustomerDetailsNugget(String mobilePhoneNumber) {
		this.mobilePhoneNumber = mobilePhoneNumber;
	}

	@Override
	
	public Object process(String URL) throws IOException {
		// First parse the HTML
		Document doc = Jsoup.connect(URL).get();
		System.out.println(doc.body().toString());
		
		
		return null;
	}

}
