package com.lancefallon.generics3;

import java.util.ArrayList;
import java.util.List;

public class Tray {

	private List<Glass<?, ?>> items = new ArrayList<>();

	public void addToTray(Glass<?, ?> glass) {
		System.out.println("Adding glass to tray");
		items.add(glass);
	}
	
	/**
	 * accept any type of CokeGlaxx<T> where T lower bound is CokeDiet...
	 * any type from CokeDiet and moving UP the hiearchy - not down - is valid.
	 * Said another way, CokeDiet or any super type of CokeDiet can be used as type parameter.
	 * i.e., CokeDiet, Coke are valid... CokeZero, which is a subclass of CokeDiet, is not valid)
	 * @param coke
	 */
	public void cokeTray(CokeGlass<? super CokeDiet>cokeGlass){
		cokeGlass.showSoda();
	}

	public List<Glass<?, ?>> getItems() {
		return items;
	}

}
