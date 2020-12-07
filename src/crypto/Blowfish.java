package crypto;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

//import javax.swing.JOptionPane; //no sera necesario mas adelante

public class Blowfish {
	private static Blowfish instance = null;
	/* Se crea un generador de claves */
	private static KeyGenerator keygen = null;
	/* Se crea una clave */
	private static SecretKey secretkey = null;
	/* Se crea un cifrador basado en Blowfish */
	private static Cipher cip = null;

	private static void changeToEncryptMode(SecretKey key) {
		/* Se inicializa el cifrador con la clave generada en modo encriptado */
		try {
			cip.init(Cipher.ENCRYPT_MODE, key);
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void changeToDecryptMode(SecretKey key) {
		/* Se inicializa el cifrador con la clave generada en modo desencriptado */
		try {
			cip.init(Cipher.DECRYPT_MODE, key);
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static byte[] encrypt(String input) {
		/* El texto ingresado es encriptado */
		byte[] encrypted = null;
		changeToEncryptMode(secretkey);
		try {
			encrypted = cip.doFinal(input.getBytes());
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return encrypted;
	}

	public static String decrypt(byte[] input) {
		String decrypted = "";
		changeToDecryptMode(secretkey);
		try {
			decrypted = new String(cip.doFinal(input));

		} catch (IllegalBlockSizeException | BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return decrypted;
	}

	public static byte[] encrypt(String input, SecretKey key) {
		/* El texto ingresado es encriptado */
		byte[] encrypted = null;
		changeToEncryptMode(key);
		try {
			encrypted = cip.doFinal(input.getBytes());
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return encrypted;
	}

	public static String decrypt(byte[] input, SecretKey key) {
		String decrypted = "";
		changeToDecryptMode(key);
		try {
			decrypted = new String(cip.doFinal(input));

		} catch (IllegalBlockSizeException | BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return decrypted;
	}

	private Blowfish() {
		try {
			keygen = KeyGenerator.getInstance("Blowfish");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String key="q2gRE#$%FidfsdfFS#$@wDjfB3evf$&%";
		byte[] keyData = key.getBytes();
		secretkey = new SecretKeySpec(keyData,"Blowfish");
		try {
			cip = Cipher.getInstance("Blowfish");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static Blowfish getInstance() {
		if (instance == null) {
			instance = new Blowfish();
		}
		return instance;
	}

}
