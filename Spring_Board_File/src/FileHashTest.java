import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;

public class FileHashTest {
	public static void main(String[] args) throws Exception{
		//MD5, SHA-1, ShA-256, SHA-512
		
		//자바에서 해시함수 사용하기
		//1. MessageDigest객체를 획득
		MessageDigest md = MessageDigest.getInstance("MD5");
		
		//2. 해시함수의 입력값으로 사용할 데이터를 md객체의 update메소드를 이용해 쭉쭉 넣는다
//		String msg = "Hello";
//		md.update(msg.getBytes());
//		md.update("good bye".getBytes());
		FileInputStream fi = null;
		BufferedInputStream bi = null;
		try{
			fi = new FileInputStream("WebContent/WEB-INF/rootContext.xml");
			bi = new BufferedInputStream(fi);
			byte[] readBuf = new byte[1024];
			int length;
			while( (length = bi.read(readBuf)) != -1){
				md.update(readBuf, 0, length);//1024바이트가 안되도 다 읽었으면 그만두라는 명령\
			}
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			bi.close();
		}
		//3. md객체의 digest메소드를 호출하여 해시함수의 출력값을 받는다.
		byte[] result = md.digest();
		
		//4. (옵션)출력값은 바이트배열로 나오므로, 보기 좋게 16진수 문자열로 변환한다
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<result.length; i++){
			sb.append(Integer.toHexString(0xFF & result[i]));
		}
		System.out.println(sb.toString());
		//26e672284e852ef1f2cf8154a04b3d3
	}
}
