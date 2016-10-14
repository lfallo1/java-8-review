package com.lancefallon.exceptions;

import com.lancefallon.exceptions.dal.DataService;

public class DriverSuper {

	public static void main(String[] args) {
		
		//get data service instance, and deserialize data
		DataService dataService = DataService.getInstance();
		dataService.deserialize();
		
		//get the list of superheroes
		dataService.getSuperheroes().stream().forEach(superhero->{
			System.out.println(superhero.toString());
		});
		
//		Suit suit = new Suit(6, "royal blue and gold", "metallic spandex", 1);
//		dataService.getSuperheroes().get(1).addSuit(suit);
//		dataService.serialize(dataService.getSuperheroes().values());
	}

}
