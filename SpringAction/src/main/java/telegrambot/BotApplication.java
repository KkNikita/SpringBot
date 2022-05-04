package telegrambot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import telegrambot.commands.Command;
import telegrambot.commands.impl.SendMessageCommandImpl;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class BotApplication {

    public static void main(String[] args) {
        SpringApplication.run(BotApplication.class, args);
    }
}
