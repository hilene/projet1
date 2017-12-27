package com.formation.proxibanque.presentation;

import com.formation.proxibanque.model.Conseiller;
import com.formation.proxibanque.service.ServiceClient;
import com.formation.proxibanque.service.ServiceCompteCourant;
import com.formation.proxibanque.service.ServiceCompteEpargne;
import com.formation.proxibanque.service.ServiceConseiller;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServiceClient servClient = new ServiceClient();
		ServiceCompteCourant  servCompteC = new ServiceCompteCourant();
		ServiceConseiller servConseil = new ServiceConseiller();
		
		//INSTANCE CLIENT TEST		
		//Client c2 = new Client(2,"Lin","Hilene", "12 avenue George", 75016, "Paris", "0148913893","hilene.lin@gmail.com",TypeClient.PARTICULIER);			
		//servC.insert(c2);
		/*
		Client c1 = servClient.selectById(2);
		
		System.out.println(c1.getIdClient());
		CompteCourant CC = new CompteCourant(300000,"18/12/2017",1200);
		CC.setIdClient(c1.getIdClient());
		//CC.setIdClient(c1.getIdClient());
		System.out.println(CC.getIdClient());
		//servCompteC.insert();
		servCompteC.insert(CC);
		
		
		for(Client c1 : servConseil.selectMyClients(1)) {
			System.out.println(c1.toString());
		}
		
		servConseil.addMyClient(2, 1);
		
		for(Client c1 : servConseil.selectMyClients(1)) {
			System.out.println(c1.toString());
		}
		*/
		/*
		
		
		ServiceConseiller servCons = new ServiceConseiller();
		
		
		Conseiller c1 = servCons.findMyConseiller("Kogu", "1234");
		System.out.println(":" + c1.getIdEmploye() + ": " + c1.getLogin() + ":" + c1.getMdp());
		*/
		
		ServiceCompteEpargne serCE = new ServiceCompteEpargne();
		
		System.out.println(serCE.selectByIdClient(1).getIdClient());
	}

}
