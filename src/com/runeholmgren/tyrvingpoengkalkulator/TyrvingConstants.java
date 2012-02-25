package com.runeholmgren.tyrvingpoengkalkulator;

import java.io.IOException;

import android.R.bool;
import android.widget.ArrayAdapter;

public class TyrvingConstants {
	
	Event[] eventlist = Event.values();
	Class[] classlist = Class.values();
	double[][][] constants = new double[classlist.length][eventlist.length][5];
	
	String temp = "";
	
	public void addClassConstants(ArrayAdapter input_constants, Class p_class) {
		int class_number = getClassNumber(p_class);
		for(int i=0;i<input_constants.getCount()/6;i++){
			for(int j=0;j<eventlist.length;j++){
				if(eventlist[j].toString().equals(input_constants.getItem(i*6).toString())){
					/*if(input_constants.getItem(i*6+1).toString().length()>0){
						double xxx = Double.parseDouble(input_constants.getItem(i*6+1).toString());
					}*/
					
					
					if(input_constants.getItem(i*6+1).toString().length()>0) constants[class_number][j][0] = Double.parseDouble(input_constants.getItem(i*6+1).toString());
					if(input_constants.getItem(i*6+2).toString().length()>0) constants[class_number][j][1] = Double.parseDouble(input_constants.getItem(i*6+2).toString());
					if(input_constants.getItem(i*6+3).toString().length()>0) constants[class_number][j][2] = Double.parseDouble(input_constants.getItem(i*6+3).toString());
					if(input_constants.getItem(i*6+4).toString().length()>0) constants[class_number][j][3] = Double.parseDouble(input_constants.getItem(i*6+4).toString());
					if(input_constants.getItem(i*6+5).toString().length()>0) constants[class_number][j][4] = Double.parseDouble(input_constants.getItem(i*6+5).toString());
				}
			}
		}
		//temp = Double.toString(constants[0][0][0]);
		//if(p_class==Class.G11) temp += constants[1][3][0] + " " + Double.parseDouble(input_constants.getItem(1).toString());
	}
	
	private int getClassNumber(Class p_class){
		int class_number;
		for(int i=0;i<classlist.length;i++)	{
			if(classlist[i].toString().equals(p_class.toString())){
				return i;
			}
		}
		return -1;
	}
	private int getEventNumber(Event event){
		int event_number;
		for(int i=0;i<eventlist.length;i++) {
			if(eventlist[i].toString().equals(event.toString())){
				return i;
			}
		}
		return -1;
	}
	public double[] getConstant(Class p_class, Event event) {
		try {
		    return constants[getClassNumber(p_class)][getEventNumber(event)];
		} catch (Exception e) {
			double[] dummy = {0,0,0,0,0};
			return dummy;
		}
	}
}