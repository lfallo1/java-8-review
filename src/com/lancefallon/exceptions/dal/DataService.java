package com.lancefallon.exceptions.dal;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

import com.lancefallon.exceptions.model.Suit;
import com.lancefallon.exceptions.model.Superhero;

public class DataService {

	private Set<Superhero> superheroes;
	private final HeroDao heroDao = new HeroDao();
	private final SuitDao suitDao = new SuitDao();

	private static DataService instance;

	private DataService() {
		this.deserialize();
	}

	public static DataService getInstance() {
		if (instance == null) {
			instance = new DataService();
		}
		return instance;
	}

	public Set<Superhero> getSuperheroes() {
		return superheroes;
	}
	
	public void serialize(Set<Superhero> superheroes){
		//write to binary file
		try(DataOutputStream dos_super = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("/Users/lancefallon/Desktop/data_source_heroes.bin")));
				DataOutputStream dos_suits = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("/Users/lancefallon/Desktop/data_source_suits.bin")))){
			
			heroDao.serialize(dos_super, superheroes);
			
			Set<Suit> suits = superheroes.stream()
					.flatMap(superhero->superhero.getSuits().stream())
					.collect(Collectors.toSet());
			suitDao.serialize(dos_suits, suits);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void deserialize(){
		try(DataInputStream dis_super = new DataInputStream(new BufferedInputStream(new FileInputStream("/Users/lancefallon/Desktop/data_source_heroes.bin")));
				DataInputStream dis_suits = new DataInputStream(new BufferedInputStream(new FileInputStream("/Users/lancefallon/Desktop/data_source_suits.bin")))){
			
			this.superheroes = heroDao.deserialize(dis_super);
			Set<Suit> suits = suitDao.deserialize(dis_suits);
			for(Superhero s : superheroes){
				for(Suit suit : suits){
					if(suit.getSuperheroId().equals(s.getId())){
						s.addSuit(suit);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
