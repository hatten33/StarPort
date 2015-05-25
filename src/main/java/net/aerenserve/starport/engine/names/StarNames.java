package net.aerenserve.starport.engine.names;

import java.util.Random;

public class StarNames {
	private static final String[] nm1 = {"a","e","i","o","u","","","","","","","","","","","","","",""};
	private static final String[] nm2 = {"b","c","d","f","g","h","j","k","l","m","n","p","q","r","s","t","v","w","x","y","z","br","cr","dr","gr","kr","pr","sr","tr","str","vr","zr","bl","cl","fl","gl","kl","pl","sl","vl","zl","ch","sh","ph","th"};
	private static final String[] nm3 = {"a","e","i","o","u","a","e","i","o","u","a","e","i","o","u","ae","ai","ao","au","aa","ea","ei","eo","eu","ee","ia","io","iu","oa","oi","oo","ua","ue"};
	private static final String[] nm4 = {"b","c","d","f","g","h","j","k","l","m","n","p","q","r","s","t","v","w","x","y","z","br","cr","dr","gr","kr","pr","sr","tr","str","vr","zr","bl","cl","fl","hl","gl","kl","ml","nl","pl","sl","tl","vl","zl","ch","sh","ph","th","bd","cd","gd","kd","ld","md","nd","pd","rd","sd","zd","bs","cs","ds","gs","ks","ls","ms","ns","ps","rs","ts","ct","gt","lt","nt","st","rt","zt","bb","cc","dd","gg","kk","ll","mm","nn","pp","rr","ss","tt","zz"};
	private static final String[] nm5 = {"","","","","","","","","","","b","c","d","f","g","h","k","l","m","n","p","r","s","t","x","y","cs","ds","fs","gs","hs","ks","ls","ms","ns","ps","rs","ts","ys","cz","tz","sz","ct","ft","kt","lt","nt","ph","sh","th"};

	public static String gen() {
		String name;
		int i = new Random().nextInt(10);
		if(i < 5) {
			int rnd = new Random().nextInt(nm1.length);
			int rnd2 = new Random().nextInt(nm2.length);
			int rnd3 = new Random().nextInt(nm3.length);
			int rnd6 = new Random().nextInt(nm5.length);
			name = nm1[rnd] + nm2[rnd2] + nm3[rnd3] + nm5[rnd6];
		} else {
			int rnd = new Random().nextInt(nm1.length);
			int rnd2 = new Random().nextInt(nm2.length);
			int rnd3 = new Random().nextInt(nm3.length);
			int rnd4 = new Random().nextInt(nm1.length);
			int rnd5 = new Random().nextInt(nm3.length);
			if(rnd3 > 14) {
				while(rnd5 > 14) {
					rnd5 = new Random().nextInt(nm3.length);
				}
			}
			int rnd6 = new Random().nextInt(nm5.length);
			name = nm1[rnd] + nm2[rnd2] + nm3[rnd3] + nm4[rnd4] + nm3[rnd5] + nm5[rnd6];
		}
		return name;
	}
}
