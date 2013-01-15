package com.runeholmgren.tyrvingpoengkalkulator;

import android.provider.SyncStateContract.Constants;

public class Calculator {
	public int calculateScore(int result, Event event,Class p_class, TyrvingConstants constants) {
		
		if(constants.getConstant(p_class, event)[0]==0) return -1;
		if(result==0){
			return 0;
		}
		
		// This picks the calculator for the event
		if(event == event.hk100 || event == event.hk110_1000 || event == event.hk110_1067 || event == event.hk200 || 
				event == event.hk300 || event == event.hk400 || event == event.hk60 || event == event.hk80 || 
				event == event.l100 || event == event.l200 || event == event.l300 || event == event.l40 || 
				event == event.l400 || event == event.l60 || event == event.l80) { //15
			return shortRace(result, event, p_class, constants);
		} else if (event == event.hi1500 || event == event.hi2000 || event == event.hi3000 || event == event.k1000 || 
				event == event.k10000 || event == event.k2000 || event == event.k20000 || event == event.k3000 || 
				event == event.k4000 || event == event.k5000 || event == event.l1000 || event == event.l10000 || 
				event == event.l1500 || event == event.l2000 || event == event.l3000 || event == event.l5000 || 
				event == event.l600 || event == event.l800) {//18
			return longRace(result, event, p_class, constants);
		} else if (event == event.HOYDE || event == event.HOYDE_UTEN_TILLOP || event == event.LENGDE
				|| event == event.LENGDE_UTEN_TILLOP || event == event.STAV || event == event.TRESTEG) {//6
			return jump(result, event, p_class, constants);
		} else if (event == event.DISKOS || event == event.KULE || event == event.LITEN_BALL || event == event.SLEGGE || 
				event == event.SLENGBALL || event == event.SPYD) {//6
			return throwEvents(result, event, p_class, constants);
		}
		return -2;
	}
	private int shortRace(int result, Event event, Class p_class, TyrvingConstants constants){
		//All races up to 400 m
		double m = result;
		double n = 100*constants.getConstant(p_class, event)[0];
		double o = n-m;
		double p = 1000 + o*constants.getConstant(p_class, event)[1];
		int score = (int)(Math.floor(p));
		if(score<0)	return 0;
		else return score;
	}
	private int longRace(int result, Event event, Class p_class, TyrvingConstants constants) {
		//All races over 600 m
		double m = result/10;
		double n = 10*constants.getConstant(p_class, event)[0];
		double o = n-m;
		double p = 1000 + o*constants.getConstant(p_class, event)[1];
		int score = (int)(Math.floor(p));
		if(score<0)	return 0;
		else return score;
	}
	private int jump(int result, Event event, Class p_class, TyrvingConstants constants) {
		// This does not include STAV
		double m = (double)result;
		double n = 100 * constants.getConstant(p_class, event)[0];
		double o = n-m;
		double p = 1000 - o*constants.getConstant(p_class, event)[1];
		int score = (int)(Math.floor(p));
		if(score<0)	return 0;
		else return score;
	}
	private int throwEvents(int result, Event event, Class p_class, TyrvingConstants constants) {
		// This (wierdly) include STAV
		double q;
		if(result/100>constants.getConstant(p_class, event)[0]) {			
			q = constants.getConstant(p_class, event)[2];
		} else {
			q = constants.getConstant(p_class, event)[3];
		}
		double i;
		if(result/100<0.8*constants.getConstant(p_class, event)[0]) {
			i = constants.getConstant(p_class, event)[4];
		} else {
			i = q;
		}
		double m = result;
		double n = 100*constants.getConstant(p_class, event)[0];
		double o = n - m ;
		double p;
		if(result/100<0.8*constants.getConstant(p_class, event)[0]) {
			p = 1000 - ((n-0.8*n)*constants.getConstant(p_class, event)[3] + (o - (n-n*0.8))*constants.getConstant(p_class, event)[4]);
		} else {
			p = 1000-o*i;
		}
		int score = (int)(Math.floor(p+0.000001));
		if(score<0)	return 0;
		else return score;
	}
}