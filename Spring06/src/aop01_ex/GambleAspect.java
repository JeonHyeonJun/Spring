package aop02;

import org.aspectj.lang.ProceedingJoinPoint;

public class GambleAspect {
	public void doBefore(){
		System.out.println("10억에 빛이 생김");
		System.out.println("마지막 희망을 걸고 도박하러감");
	}
	public void doAfterReturning(){
		System.out.println("손모가지날아감");
	}
	public void doAfterThrowing(){
		System.out.println("경찰뜸");
	}
	public void doAfter(){
		System.out.println("파산");
	}
	
	public void around(ProceedingJoinPoint jp){
		doBefore();
		try {
			jp.proceed();
			doAfterReturning();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			doAfterThrowing();
			e.printStackTrace();
		}
		finally {
			doAfter();
		}
	}
}
