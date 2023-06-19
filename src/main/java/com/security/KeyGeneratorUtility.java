package com.security;

import java.security.KeyPair;
import java.security.KeyPairGenerator;

public class KeyGeneratorUtility {

	public static KeyPair generatedRsaKey() {
		KeyPair keypair;
		
		try {
			KeyPairGenerator keyPairGenerator=KeyPairGenerator.getInstance("RSA");
			keyPairGenerator.initialize(2048);
			keypair=keyPairGenerator.generateKeyPair();
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
			throw new IllegalStateException();
			
		}
		return keypair;
	}
}
