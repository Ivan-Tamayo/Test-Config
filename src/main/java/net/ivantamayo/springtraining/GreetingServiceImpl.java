package net.ivantamayo.springtraining;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GreetingServiceImpl implements GreetingService {
	
	//Autowired en el field
	@Autowired
	@Qualifier(value="jdbcMessageRepository")
    private MessageRepository messageRepository;
 
    // Constructor Autowired
    /**
    @Autowired
    public GreetingServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }
    */
    
    /**
    @Autowired
    public void setMessageRepository(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }
    */
 
    public String greet(String name) {
        Locale locale = Locale.getDefault();
        String message = messageRepository.getMessage(locale.getDisplayLanguage());
        return message + " " + name;
    }
}