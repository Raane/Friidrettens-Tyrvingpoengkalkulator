package com.runeholmgren.tyrvingpoengkalkulator;

import junit.framework.Test;

public class AppInput {
	private Class picked_class;
	private Event event;
	private int result;
	private boolean isTime;
	
	public void interpretInput(int class_id, int event_id, String raw_result) {
		this.event = interpretEvent(event_id);
		this.picked_class = interpretClass(class_id);
		this.result = interpretResult(raw_result);
	}
	private Event interpretEvent(int event_id) {
		Event event = null;
		switch (event_id) {
		case 0: event = Event.HOYDE ; break;
		case 1: event = Event.HOYDE_UTEN_TILLOP ; break;
		case 2: event = Event.STAV ; break;
		case 3: event = Event.LENGDE ; break;
		case 4: event = Event.LENGDE_UTEN_TILLOP ; break;
		case 5: event = Event.TRESTEG ; break;
		case 6: event = Event.KULE ; break;
		case 7: event = Event.DISKOS ; break;
		case 8: event = Event.SLEGGE ; break;
		case 9: event = Event.SPYD ; break;
		case 10: event = Event.LITEN_BALL ; break;
		case 11: event = Event.SLENGBALL ; break;
		case 12: event = Event.l40 ; break;
		case 13: event = Event.l60 ; break;
		case 14: event = Event.l80 ; break;
		case 15: event = Event.l100 ; break;
		case 16: event = Event.l200 ; break;
		case 17: event = Event.l300 ; break;
		case 18: event = Event.l400 ; break;
		case 19: event = Event.l600 ; break;
		case 20: event = Event.l800 ; break;
		case 21: event = Event.l1000 ; break;
		case 22: event = Event.l1500 ; break;
		case 23: event = Event.l2000 ; break;
		case 24: event = Event.l3000 ; break;
		case 25: event = Event.l5000 ; break;
		case 26: event = Event.l10000 ; break;
		case 27: event = Event.hk60 ; break;
		case 28: event = Event.hk80 ; break;
		case 29: event = Event.hk100 ; break;
		case 30: event = Event.hk110_1000 ; break;
		case 31: event = Event.hk110_1067 ; break;
		case 32: event = Event.hk200; break;
		case 33: event = Event.hk300 ; break;
		case 34: event = Event.hk400 ; break;
		case 35: event = Event.hi1500 ; break;
		case 36: event = Event.hi2000 ; break;
		case 37: event = Event.hi3000 ; break;
		case 38: event = Event.k1000 ; break;
		case 39: event = Event.k2000 ; break;
		case 40: event = Event.k3000 ; break;
		case 41: event = Event.k4000 ; break;
		case 42: event = Event.k5000 ; break;
		case 43: event = Event.k10000 ; break;
		case 44: event = Event.k20000 ; break;
		}
		return event;
	}
	private Class interpretClass(int class_id) {
		Class picked_class = null;
		switch (class_id) {
		case 0: picked_class = Class.G10 ; break;
		case 1: picked_class = Class.G11 ; break;
		case 2: picked_class = Class.G12 ; break;
		case 3: picked_class = Class.G13 ; break;
		case 4: picked_class = Class.G14 ; break;
		case 5: picked_class = Class.G15 ; break;
		case 6: picked_class = Class.G16 ; break;
		case 7: picked_class = Class.G17 ; break;
		case 8: picked_class = Class.G18; break;
		case 9: picked_class = Class.G19 ; break;
		case 10: picked_class = Class.J10 ; break;
		case 11: picked_class = Class.J11 ; break;
		case 12: picked_class = Class.J12 ; break;
		case 13: picked_class = Class.J13 ; break;
		case 14: picked_class = Class.J14 ; break;
		case 15: picked_class = Class.J15 ; break;
		case 16: picked_class = Class.J16 ; break;
		case 17: picked_class = Class.J17 ; break;
		case 18: picked_class = Class.J18 ; break;
		case 19: picked_class = Class.J19 ; break;
		}
		return picked_class;
	}
	private int interpretResult(String raw_result) {
		String clean_result = cleanRawResult(raw_result);
		if(clean_result=="") return 0;
		if(event==Event.HOYDE || event==Event.HOYDE_UTEN_TILLOP || event==Event.STAV || event==Event.LENGDE || event==Event.LENGDE_UTEN_TILLOP || event==Event.TRESTEG || 
				event==Event.KULE || event==Event.DISKOS || event==Event.SLEGGE || event==Event.SPYD || event==Event.LITEN_BALL || event==Event.SLENGBALL){
			return iterpretDistanceResult(clean_result);
		}
		else return interpretTimeResult(clean_result);
	}
	private String cleanRawResult(String raw_result) {
		String clean_result = "";
		for(int i=0;i<raw_result.length();i++){
			if((raw_result.charAt(i)>='0'&&raw_result.charAt(i)<='9') || raw_result.charAt(i)==','){
				if(!(clean_result.length()==0 && raw_result.charAt(i)==',')){
					if(clean_result.length()==0 || !(clean_result.charAt(clean_result.length()-1)==',' && 
							raw_result.charAt(i)==',')){						
						clean_result += Character.toString(raw_result.charAt(i));
					}
				}
			}
		}
		return clean_result;
	}
	private int iterpretDistanceResult(String clean_result) {
		isTime = false;
		String[] result_array = clean_result.split(",");
		switch(result_array.length) {
		case 1: 
			result = Integer.parseInt(result_array[0]);
			break;
		case 2:
			if(result_array[1].length()==1) {
				result = Integer.parseInt(result_array[1])*10 + Integer.parseInt(result_array[0])*100;
			} else {
				result = Integer.parseInt(result_array[1]) + Integer.parseInt(result_array[0])*100;
			}
			break;
		}
		return result;
	}
	private int interpretTimeResult(String clean_result) {
		isTime = true;
		String[] result_array = clean_result.split(",");
		int result = 0;
		switch(result_array.length) {
		case 1: 
			result = Integer.parseInt(result_array[0]);
			break;
		case 2:
			if(result_array[1].length()==1) {
				result = Integer.parseInt(result_array[1])*10 + Integer.parseInt(result_array[0])*100;
			} else {
				result = Integer.parseInt(result_array[1]) + Integer.parseInt(result_array[0])*100;
			}
			break;
		case 3:
			result = 0;
			
			if (result_array[2].length()==1) result += Integer.parseInt(result_array[2])*10;
			else result += Integer.parseInt(result_array[2]);
			
			if (result_array[1].length()==1) result += Integer.parseInt(result_array[1])*100*10;
			else result += Integer.parseInt(result_array[1])*100;
			
			result += Integer.parseInt(result_array[0])*60*100;
			break;
		case 4:
			result = 0;
			
			if(result_array[3].length()==1) result += Integer.parseInt(result_array[3])*10;
			else result += Integer.parseInt(result_array[3])*10;
			
			if(result_array[2].length()==1) result += Integer.parseInt(result_array[2])*100*10;
			else result += Integer.parseInt(result_array[2])*100;
			
			if(result_array[1].length()==1) result += Integer.parseInt(result_array[1])*60*100*10;
			else result += Integer.parseInt(result_array[1])*60*100;
			
			result += Integer.parseInt(result_array[0])*60*60*100;
			break;
		}
		return result;
	}
	public Event getEvent() {
		return event;
	}
	
	public Class getPickedClass() {
		return picked_class;
	}
	public int getResult() {
		return result;
	}
	public String getResultString() {
		if(isTime) return getTimeResultString();
		else return getDistanceResultString();
	}
	private String getDistanceResultString() {
		String stringResult = Integer.toString(result/100);
		stringResult += " meter og ";
		stringResult += Integer.toString(result-(result/100)*100);
		stringResult += " centimeter";
		return stringResult;
	}
	private String getTimeResultString() {
		String stringResult = "";
		boolean ogUsed = false;
		if(result>=360000){
			stringResult += result/360000;
			stringResult += " timer og ";
		}
		if(result>=6000){
			stringResult += (result - (result/360000)*360000)/6000;
			stringResult += " minutter og ";
		}
		if(result>=100){
			stringResult += (result - (result/6000)*6000)/100;
			stringResult += " sekunder og ";
		}
		stringResult += (result - (result/100)*100);
		stringResult += " hundredeler";
		return stringResult;
	}
}