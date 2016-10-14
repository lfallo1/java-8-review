package com.lancefallon.binarydata;

public class Driver {
	
	private static final int MODE_VALUE_SHIFT = 24;
	private static final int MODE_MASK = 0x03;
	private static final int READING_MASK = 0xFC;
	private static final int MODE_OFF = 0;
	private static final int MODE_ON = 1;
	private static final int MODE_STANDBY = 2;
	private static final int MODE_LOADING = 3;
	private static final int READING_HIGH = 50;
	
	public static void processModeAndReading(int value){
		System.out.println(Integer.toBinaryString((value >> MODE_VALUE_SHIFT) & MODE_MASK));
		System.out.println(Integer.toBinaryString((value >> MODE_VALUE_SHIFT) & READING_MASK));
		int mode = (value >> MODE_VALUE_SHIFT) & MODE_MASK;
		switch (mode) {
		case MODE_OFF:
			System.out.println("Device is off");
			break;
		case MODE_ON:
			System.out.println("Device is on");
			break;
		case MODE_STANDBY:
			System.out.println("Device is in standby");
			break;
		case MODE_LOADING:
			System.out.println("Device is loading data");
			break;
		default:
			System.out.println("Device error, please restart");
			break;
		}
		
		int reading = (value >> MODE_VALUE_SHIFT) & READING_MASK;
		if(reading > READING_HIGH){
			System.out.println("WARNING High Reading: " + reading);
		} else{
			System.out.println("Reading: " + reading);
		}
		
	}
	
	public static void main(String[] args) {

		
//		int[] a = new int[10];
////		System.out.println(a[10]);
//		System.out.println(a[9]);
//		System.out.println(a.length);
//		for(int i = 0; i < a.length; i++){
//			System.out.println(a[i]);
//		}
		
		
		
//		int raw = 889775244; //raw
//		
//		processModeAndReading(raw);
//		
//		int a1 = (raw >> 24) & 0xff;
//		int a2 = (raw >> 16) & 0xff;
//		int a3 = (raw >> 8) & 0xff;
//		int a4 = (raw >> 0) & 0xff;
//		
//		String hex = String.format("%02x%02x%02x%02x", a1,a2,a3,a4);
//		System.out.println(hex);
//		
//		String binaryString = Integer.toBinaryString(raw);
//		StringBuilder sb = new StringBuilder();
//		for(int i = binaryString.length() - 1; i >=0; i--){
//			sb.append(binaryString.charAt(i));
//			if(i%8==0){
//				sb.append(" ");
//			}
//		}
//		
//		System.out.println(sb.toString());/ TODO Auto-generated method stub

	}

}
