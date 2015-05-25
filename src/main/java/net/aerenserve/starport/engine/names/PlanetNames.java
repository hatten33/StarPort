package net.aerenserve.starport.engine.names;

import java.util.Random;

public class PlanetNames {

	private static final String[] nm1 = {"b","c","d","f","g","h","i","j","k","l","m","n","p","q","r","s","t","v","w","x","y","z","","","","",""};
	private static final String[] nm2 = {"a","e","o","u"};
	private static final String[] nm3 = {"br","cr","dr","fr","gr","pr","str","tr","bl","cl","fl","gl","pl","sl","sc","sk","sm","sn","sp","st","sw","ch","sh","th","wh"};
	private static final String[] nm4 = {"ae","ai","ao","au","a","ay","ea","ei","eo","eu","e","ey","ua","ue","ui","uo","u","uy","ia","ie","iu","io","iy","oa","oe","ou","oi","o","oy"};
	private static final String[] nm5 = {"turn","ter","nus","rus","tania","hiri","hines","gawa","nides","carro","rilia","stea","lia","lea","ria","nov","phus","mia","nerth","wei","ruta","tov","zuno","vis","lara","nia","liv","tera","gantu","yama","tune","ter","nus","cury","bos","pra","thea","nope","tis","clite"};
	private static final String[] nm6 = {"una","ion","iea","iri","illes","ides","agua","olla","inda","eshan","oria","ilia","erth","arth","orth","oth","illon","ichi","ov","arvis","ara","ars","yke","yria","onoe","ippe","osie","one","ore","ade","adus","urn","ypso","ora","iuq","orix","apus","ion","eon","eron","ao","omia"};

	public static String gen() {		
		String name;	
		int i = new Random().nextInt(10);
		if(i < 2) {
			int rnd = new Random().nextInt(nm1.length);
			int rnd2 = new Random().nextInt(nm2.length);
			int rnd3 = new Random().nextInt(nm3.length);
			int rnd4 = new Random().nextInt(nm4.length);
			int rnd5 = new Random().nextInt(nm5.length);
			name = nm1[rnd] + nm2[rnd2] + nm3[rnd3] + nm4[rnd4] + nm5[rnd5];
		} else if(i < 4) {
			int rnd = new Random().nextInt(nm1.length);
			int rnd2 = new Random().nextInt(nm2.length);
			int rnd3 = new Random().nextInt(nm3.length);
			int rnd4 = new Random().nextInt(nm6.length);
			name = nm1[rnd] + nm2[rnd2] + nm3[rnd3] + nm6[rnd4];
		} else if(i < 6) {
			int rnd = new Random().nextInt(nm1.length);
			int rnd4 = new Random().nextInt(nm4.length);
			int rnd5 = new Random().nextInt(nm5.length);
			name = nm1[rnd] + nm4[rnd4] + nm5[rnd5];
		} else if(i < 8) {
			int rnd2 = new Random().nextInt(nm2.length);
			int rnd3 = new Random().nextInt(nm3.length);
			int rnd4 = new Random().nextInt(nm2.length);
			int rnd5 = new Random().nextInt(nm5.length);
			name = nm3[rnd3] + nm2[rnd2] + nm1[rnd2] + nm2[rnd4] + nm5[rnd5];
		} else {
			int rnd = new Random().nextInt(nm3.length);
			int rnd2 = new Random().nextInt(nm6.length);
			name = nm3[rnd] + nm6[rnd2];
		}
		return name;
	}
}
