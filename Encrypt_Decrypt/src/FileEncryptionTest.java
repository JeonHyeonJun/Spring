import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class FileEncryptionTest {
	public static void main(String[] args) {
		String originPath = "Wildlife.wmv";
		String encryptPath = "Wildlife_encrypt.wmv";
		BufferedInputStream bi = null;
		BufferedOutputStream bo = null;
		
		Cipher cipher = null;
		String key = "abcdefghijklmnop";
		byte[] keyByte = key.getBytes();
		try {
			cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			SecretKeySpec keySpec = new SecretKeySpec(keyByte, "AES");
			IvParameterSpec ivSpec = new IvParameterSpec(keyByte);
			cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NoSuchPaddingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try{
			bi = new BufferedInputStream(new FileInputStream(originPath));
			bo = new BufferedOutputStream(new FileOutputStream(encryptPath));
			byte[] buf = new byte[512];
			
			int length;
			while((length = bi.read(buf, 0, 512)) != -1){
				byte[] encBuf = cipher.doFinal(buf, 0, length);
				System.out.println(encBuf.length);
				System.out.println(length);
				bo.write(encBuf, 0, encBuf.length);
			}
			bo.flush();
			
		} catch(IOException e){
			
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(bi != null)
					bi.close();
				if(bo != null)
					bo.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
