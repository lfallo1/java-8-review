package com.lancefallon.exceptions.dal;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.lancefallon.exceptions.model.Superhero;

public class HeroDao implements ObjectSerializer<Superhero, Set<Superhero>> {

	private static final String DATA_LOC_HEROES = "/Users/lancefallon/Desktop/data_source_heroes.txt";
	private static final String DELIMITTER = ";";
	
	public Map<Integer, Superhero> getAll(){
		Map<Integer, Superhero> superheroes = new HashMap<>();
		try(Scanner s = new Scanner(new BufferedReader(new FileReader(DATA_LOC_HEROES)))){
			while(s.hasNextLine()){
				String[] line = s.nextLine().replaceAll("\"", "").split(DELIMITTER);
				Integer id = Integer.parseInt(line[0]);
				superheroes.put(id, new Superhero(id, line[1], line[2], line[3]));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return superheroes;
	}

	@Override
	public void serialize(DataOutputStream dos, Set<Superhero> list) throws IOException {
		for(Superhero s : list){
			dos.writeInt(s.getId());
			dos.writeUTF(s.getAlias());
			dos.writeUTF(s.getFirstName());
			dos.writeUTF(s.getLastName());
		}
	}

	@Override
	public Set<Superhero> deserialize(DataInputStream dis) throws IOException {
		Set<Superhero> superheroes = new HashSet<>();
		
		try{
			while(true){
				Integer id = dis.readInt();
				String alias = dis.readUTF();
				String firstName = dis.readUTF();
				String lastName = dis.readUTF();
				superheroes.add(new Superhero(id, alias, firstName, lastName));
			}
		} catch(EOFException e){
			System.out.println("Reached end of superhero file");
		}
		
		return superheroes;
	}
	
	
}
