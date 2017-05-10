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

public class FileDecryptionTest {
	public static void main(String[] args) {
		String encryptPath = "Wildlife_encrypt.wmv";
		String decryptPath = "Wildlife_decrypt.wmv";
		BufferedInputStream bi = null;
		BufferedOutputStream bo = null;
		
		Cipher cipher = null;
		String key = "abcdefghijklmnop";
		byte[] keyByte = key.getBytes();
		try {
			cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			SecretKeySpec keySpec = new SecretKeySpec(keyByte, "AES");
			IvParameterSpec ivSpec = new IvParameterSpec(keyByte);
			cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
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
			bi = new BufferedInputStream(new FileInputStream(encryptPath));
			bo = new BufferedOutputStream(new FileOutputStream(decryptPath));
			byte[] buf = new byte[512 + 16];	//암호화 한것은 용량이 늘어나기 때문에 그에 맞춰 읽는 용량도 늘려야함
			
			int length;
			while((length = bi.read(buf, 0, 512 + 16)) != -1){
				byte[] decBuf = cipher.doFinal(buf, 0, length);
				System.out.println(decBuf.length);
				System.out.println(length);
				bo.write(decBuf, 0, decBuf.length);
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
