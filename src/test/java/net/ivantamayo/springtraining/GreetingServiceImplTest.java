package net.ivantamayo.springtraining;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.*;
//import org.springframework.test.AbstractDependencyInjectionSpringContextTests;



public class GreetingServiceImplTest{
    private GreetingService greetingService;
    private ConfigurableApplicationContext context;
 
    public void setGreetingService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }
 
    
    @Before
	public void setUp() throws Exception {
    	context = new ClassPathXmlApplicationContext(
				"classpath:/META-INF/spring/app-context.xml" );
		// Get the bean to use to invoke the application
		greetingService = context.getBean(GreetingService.class);
	}
    
    @After
	public void tearDown() {
		// Context is closed so @PreDestroy annotated methods will be invoked
		context.close();	
	}
    
    @Test
    public void testEnglishWelcome() {
        Locale.setDefault(Locale.ENGLISH);
        String name = "Spring Community";
        String greeting = greetingService.greet(name);
        assertEquals("Welcome " + name, greeting);
    }
 
    @Test
    public void testGermanWelcome() {
        Locale.setDefault(Locale.GERMAN);
        String name = "Spring Community";
        String greeting = greetingService.greet(name);
        assertEquals("Willkommen " + name, greeting);
    }
    
}