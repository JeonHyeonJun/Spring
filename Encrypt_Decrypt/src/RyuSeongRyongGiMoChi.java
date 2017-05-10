import java.io.File;
import java.io.FileInputStream;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class RyuSeongRyongGiMoChi {
	public static void main(String[] args) throws Exception{


		//암호화를 해주는 객체를 획득
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		
		//사용할 키. 16바이트 문자열 생성
		String key = "abcdefghijklmnop";	
		
		//키는 바이트배열로 전환
		byte[] keyByte = key.getBytes();
		
		//암호화하 고자 하는 원본
		String plainText = "류승룡기모찌";
		
		//원본 데이터도 바이트 배열로 준비
		byte[] plainByte = plainText.getBytes();
		
		//Key스펙을 준비하고 암호화 객체에 세팅
		SecretKeySpec keySpec = new SecretKeySpec(keyByte, "AES");
		IvParameterSpec ivSpec = new IvParameterSpec(keyByte);
		
		//암호화
		cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);	
		byte[] encryptData = cipher.doFinal(plainByte);
		
		System.out.println(new String(encryptData));
		
		//복호화
		cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
		byte[] decryptData = cipher.doFinal(encryptData);
		System.out.println(new String(decryptData));
	}
}
