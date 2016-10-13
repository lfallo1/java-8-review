package com.lancefallon.generics3;

public class Driver {

	public static void main(String[] args) {
		Glass<Liquid,Liquid> glass = new Glass<>(new Water("water", 43.33, "clear"), new OrangeJuice("orange juice", 89.5, "orange"));
		Glass<Liquid,Liquid> glass2 = new Glass<>(new Water("coke", 48.33, "dark"), new OrangeJuice("jack", 180.99, "amber"));
		Tray tray = new Tray();
		
		//add glass items to the tray
		tray.addToTray(glass);
		tray.addToTray(glass2);
		
		//mix each glass
		tray.getItems().stream().forEach(g->g.mix());
		
		tray.cokeTray(new CokeGlass<CokeDiet>(new CokeZero()));
	}

}
