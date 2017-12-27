package com.formation.proxibanque.test;

import com.formation.proxibanque.model.Client;
import com.formation.proxibanque.model.TypeClient;
import com.formation.proxibanque.service.ServiceClient;

public class DaoClientTest {
	ServiceClient servC = new ServiceClient();
	
	//INSTANCE CLIENT TEST		
	Client c2 = new Client(2,"Lin","Hilene", "12 avenue George", 75016, "Paris", "0148913893","hilene.lin@gmail.com",TypeClient.PARTICULIER);	
	
		
	
	
}
