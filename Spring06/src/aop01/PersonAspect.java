package aop01;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class PersonAspect {
	public void doBefore(JoinPoint jp){
//		System.out.println(jp.getTarget());	//포인트컷 발생할 객체
//		System.out.println(jp.getSignature());	//포인트컷에서 실행하는 함수의 풀패키지명
		System.out.println("문이열리고멋진그대가들어오네요");
	}
	public void doAfterReturning(String rt){
		System.out.println("불을끄고잔다" + rt);
	}
	public void doAfterThrowing(Throwable th){
		System.out.println(th.getMessage()+ "119에신고한다");
	}
	public void doAfter(){
		System.out.println("문을 열고 집을 나온다");
	}
	
	
	public void around(ProceedingJoinPoint jp){
		doBefore(jp);
		try {
			String rt = (String)jp.proceed(); //포인트컷이 발생한 함수 실행
			doAfterReturning(rt);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			doAfterThrowing(e);
		}
		finally {
			doAfter();
		}
	}
}
