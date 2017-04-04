package aop01_ex;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class GambleAspect {
	@Pointcut("execution(public * aop01_ex.*.result(..))")
	public void pt(){}
	
	@Before("pt()")
	public void doBefore(){
		System.out.println("10억에 빛이 생김");
		System.out.println("마지막 희망을 걸고 도박하러감");
	}
	@AfterReturning(pointcut = "pt()", returning="rt")
	public void doAfterReturning(String rt){
		System.out.println(rt + "손모가지날아감");
	}
	@AfterThrowing(pointcut = "pt()", throwing = "th")
	public void doAfterThrowing(Throwable th){
		System.out.println(th.getMessage() + "도망감");
	}
	@After("pt()")
	public void doAfter(){
		System.out.println("파산");
	}
	
//	@Around("pt()")
//	public void around(ProceedingJoinPoint jp){
//		doBefore();
//		try {
//			String rt = (String)jp.proceed();
//			doAfterReturning(rt);
//		} catch (Throwable e) {
//			// TODO Auto-generated catch block
//			doAfterThrowing(e);
//			e.printStackTrace();
//		}
//		finally {
//			doAfter();
//		}
//	}
}
