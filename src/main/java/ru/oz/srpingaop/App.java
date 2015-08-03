package ru.oz.srpingaop;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {

        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        SimpleService simpleService = context.getBean(SimpleService.class);
        simpleService.printNameId();
        System.out.println("--------------");
        try {
            simpleService.setName("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            simpleService.checkName();
            System.out.println("конец сценария с без ошибки и её логировании ошибки");

            simpleService.setName("xxxx");
            simpleService.checkName();
            System.out.println("конец сценария с логированием ошибки");
        } catch(Exception e){
            System.out.println("SimpleService: Method checkName() exception thrown..");
        }
        System.out.println("--------------");
//        simpleService.sayHello("Javacodegeeks");
//        context.close();

    }
}
