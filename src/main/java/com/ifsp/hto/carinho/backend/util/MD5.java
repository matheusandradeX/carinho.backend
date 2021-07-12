package com.ifsp.hto.carinho.backend.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
	
	
	 public static String stringToMD5(String entrada) {
		
	     
		try {
			MessageDigest m;
			m = MessageDigest.getInstance("MD5");
			 m.update(entrada.getBytes(),0,entrada.length());	     
		     
		     BigInteger cript = new BigInteger(1,m.digest());    
		     
		     String stringMD5 = cript.toString(16);
		     
			return stringMD5;
		} catch (NoSuchAlgorithmException e) {
			
			
			e.printStackTrace();
			return null;
		}
		
	    
		
	}

}
