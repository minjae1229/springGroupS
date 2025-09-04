package com.spring.springGroupS.aop;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@EnableAspectJAutoProxy
// @Aspect
@Component
public class AspectTest {

	// 문제1 : getAopServiceTest1() 메소드 '전/후' 메세지 출력하시오.
	@Around("execution(* com.spring.springGroupS.service.Study1Service.getAopServiceTest1(..))")
	public void aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {

		System.out.println("\n 1. 핵심코드 수행 전 \n");

		joinPoint.proceed(); // 여기를 기준으로 전/후

		System.out.println("\n 2. 핵심코드 수행 후 \n");
	}

	// 문제2 : getAopServiceTest3() 메소드 '전'에 메시지 출력하시오.
	@Before("execution(* com.spring.springGroupS.service.Study1Service.getAopServiceTest3(..))")
	public void beforeAdvice() {
		System.out.println("\n 1. 핵심코드 수행 전 \n");
	}

	// 문제3 : getAopServiceTest2() 메소드 수행결과 메소드에서의 반환값을 콘솔에 출력하시오.
	@AfterReturning(value = "execution(* com.spring.springGroupS.service.Study1Service.getAopServiceTest2(..))", returning = "result")
	public void afterReturningAdvice(JoinPoint joinPoint, Object result) {
		System.out.println("\n 이곳은 afterReturningAdvice() 메소드 입니다. \n");
		System.out.println("\n 핵심코드에서 반환된 값 : " + result.toString() + "\n");
	}

	// 문제4 : 모든 메소드( getAopServiceTest52(), getAopServiceTest53() )가 수행하는데 걸린 시간?

//	long startTime, endTime;
//
//	@Pointcut("execution(* com.spring.springGroupS.service.Study1Service.getAopServiceTest5*(..))")
//	private void cut() {
//	}
//
//	@Around("cut()")
//	public void aroundAdvice2(ProceedingJoinPoint joinPoint) throws Throwable {
//		startTime = System.nanoTime();
//
//		System.out.println("aroundAdvice2() (전) : " + joinPoint);
//		joinPoint.proceed();
//		System.out.println("aroundAdvice2() (후) : " + joinPoint);
//
//		endTime = System.nanoTime();
//
//		long res = endTime - startTime;
//		System.out.println("수행시간 : " + res);
//	}

	// 숙제 : study1Service 객체 안의 모든 메소드의 수행시간을 해당 메소드 이름과 함께 출력.

	@Pointcut("execution(* com.spring.springGroupS.service.Study1Service.*(..))")
	private void cut() {
	}

	@Around("cut()")
	public Object aroundAdviceAll(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.nanoTime();

		// 메소드 이름 가져오기
		String methodName = joinPoint.getSignature().getName();
		
		Object result = joinPoint.proceed(); // 메소드 실행

		long endTime = System.nanoTime();
		
		long res = endTime - startTime;
		
		System.out.println("메소드 이름 : " + methodName + ", 수행시간 : " + res);

		return result; // Around는 리턴을 반드시 해줘야함.
	}
}
