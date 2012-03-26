package net.ivantamayo.springtraining;

import java.util.*;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

@Repository
public class StubMessageRepository implements MessageRepository {
    Map<String,String> messages = new HashMap<String,String>();
 
    @PostConstruct
    public void initialize() {
        messages.put("English", "Welcome");
        messages.put("Deutsch", "Willkommen");
    }
 
    public String getMessage(String language) {
        return messages.get(language);
    }
}