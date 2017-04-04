package aop02;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component	//이 클래스를 bean으로 등록
@Aspect		//이 클래스를 aspect로 사용
public class PersonAspect {
	@Pointcut("execution(public * aop02.*.doSomething(..))")
	public void pt(){
		
	}
	
	@Before("pt()")
	public void doBefore(){
		System.out.println("문을 열고 집에 들어간다");
	}
	@AfterReturning(pointcut = "pt()", returning="rt")
	public void doAfterReturning(String rt){
		System.out.println("불을 끄고 잔다"+rt);
	}
	@AfterThrowing(pointcut = "pt()", throwing = "th")
	public void doAfterThrowing(Throwable th){
		System.out.println(th.getMessage()+"119에 신고한다요");
	}
	@After("pt()")
	public void doAfter(){
		System.out.println("문을 열고 집을 나온다");
	}
}
