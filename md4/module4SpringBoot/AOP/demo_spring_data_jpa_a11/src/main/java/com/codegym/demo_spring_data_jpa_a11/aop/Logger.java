package com.codegym.demo_spring_data_jpa_a11.aop;


import com.codegym.demo_spring_data_jpa_a11.dto.StudentDto;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
    private static int count=0;
//
//    @Before("execution(* com.codegym.demo_spring_data_jpa_a11.controller.StudentController.*(..))")
//    public void count(){
//        count++;
//        System.out.println("So luong truy cap :"+ count);
//    }
//    @After("execution(* com.codegym.demo_spring_data_jpa_a11.controller.StudentController.save(..))")
//    public void loggingCreate(JoinPoint joinPoint){
//         Object[] args = joinPoint.getArgs();
//        StudentDto studentDto = (StudentDto) args[0];
//        // ghi vào file
//        System.out.println("Tên người mới thêm : " + studentDto.getName());
//    }
    @Around("execution(* com.codegym.demo_spring_data_jpa_a11.controller.StudentController.save(..))")
    public Object loggingCreate(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println(" làm gì đó trước khi thực hiện thêm mới");
        Object object = proceedingJoinPoint.proceed();
        System.out.println("Công việc thực hiện sau khi thêm mới");
      return object;
    }
}
