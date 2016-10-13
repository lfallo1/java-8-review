package com.lancefallon.collectionsreview;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lancefallon.generics2.SoftwareDeveloper;

public class Driver {

	public static final long rowCount = 26;
	public static final long seatsPerRow = 99;
	public static final long totalSeats = rowCount*seatsPerRow;
	
	public static void main(String[] args) {
//		TheatreArrayList theatre = new TheatreArrayList("Lance Theatre", rowCount, seatsPerRow);
//		theatre.getAllSeats().stream()
//			.sorted((s1,s2)->{
//				int seat1 = Integer.parseInt(s1.getSeatNumber().substring(1));
//				int seat2 = Integer.parseInt(s2.getSeatNumber().substring(1));
//				return seat1 > seat2 ? 1 : seat1 < seat2 ? -1 : 0;
//			})
//			.forEach(seat->System.out.println(seat.getSeatNumber()));
//		doStuff(theatre.getAllSeats());
		
		Map<String, String> map = new HashMap<>();
		List<SoftwareDeveloper> idList = Arrays.asList(new SoftwareDeveloper("lance", "dev", 50000.0));
		MapDto<String, String, SoftwareDeveloper> dto = new MapDto<>(map, idList);
		List<SoftwareDeveloper> list = dto.getMyList();
//		list.set(0, new SoftwareDeveloper("something else", "dev", 50000.0));
		list.remove(0);
		
		list.stream().forEach(i->System.out.println(i.getName()));
		System.out.println("--\r\n\r\n");
		dto.getMyList().stream().forEach(i->System.out.println(i.getName()));
		
//		System.out.println("modified list size: " + list.size());
//		System.out.println("dto instance list size: " + dto.getMyList().size());
		
		
//		map.put("java", "java description");
//		map.put("objective c", "ios programming lang");
//		
//		System.out.println(map.get("java"));
//		map.replace("java", "something new");
//		System.out.println(map.get("java"));
//		map.put("java", "something new again");
//		System.out.println(map.get("java"));
	}
	
	public static void doStuff(Collection<? extends TheatreArrayList.Seat> list){
		System.out.println(list.size());
	}

}
