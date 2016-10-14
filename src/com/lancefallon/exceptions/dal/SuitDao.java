package com.lancefallon.exceptions.dal;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.lancefallon.exceptions.model.Suit;

public class SuitDao implements ObjectSerializer<Suit, Set<Suit>> {
	private static final String DATA_LOC_SUITS = "/Users/lancefallon/Desktop/data_source_suits.txt";
	private static final String DELIMITTER = ";";
	
	public Set<Suit> getAll(){
		Set<Suit> suits = new HashSet<>();
		try(Scanner s = new Scanner(new BufferedReader(new FileReader(DATA_LOC_SUITS)))){
			while(s.hasNextLine()){
				String[] line = s.nextLine().replaceAll("\"", "").split(DELIMITTER);
				suits.add(new Suit(Integer.parseInt(line[0]), line[1], line[2], Integer.parseInt(line[3])));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return suits;
	}

	@Override
	public void serialize(DataOutputStream dos, Set<Suit> list) throws IOException {
		for(Suit s : list){
			dos.writeInt(s.getId());
			dos.writeUTF(s.getMaterial());
			dos.writeUTF(s.getColor());
			dos.writeInt(s.getSuperheroId());
		}
	}

	@Override
	public Set<Suit> deserialize(DataInputStream dis) throws IOException {
		Set<Suit> suits = new HashSet<>();
		
		try{
			while(true){
				Integer id = dis.readInt();
				String material = dis.readUTF();
				String color = dis.readUTF();
				Integer superheroId = dis.readInt();
				
				suits.add(new Suit(id, color, material, superheroId));
			}
		} catch(EOFException e){
			System.out.println("Reached end of superhero file");
		}
		
		return suits;
	}
	
}
