package com.joe.pizzamessagegeneratorservice.resources;

import com.joe.pizzamessagegeneratorservice.models.PizzaMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/pizzaMessage")
public class PizzaController {

    Logger logger = LogManager.getLogger(PizzaController.class);

    @RequestMapping("/pizza")
    public PizzaMessage getPizzaOrder() {

        List<PizzaMessage> messages = Arrays.asList(
                new PizzaMessage("margherita", 1, 20),
                new PizzaMessage("stuffedCrust", 1, 30),
                new PizzaMessage("hawaiian", 1, 16),
                new PizzaMessage("veggieLover", 1, 15)
                );

        Random random = new Random();
        int randomInt = random.nextInt(4);

        PizzaMessage msg = messages.get(randomInt);
        logger.info("Message created " + msg);

       return msg ;
    }
}
