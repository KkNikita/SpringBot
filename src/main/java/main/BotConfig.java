package main;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.ApiContext;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

import java.util.logging.Logger;

@Configuration
@ConfigurationProperties(prefix = "botmodel")
public class BotConfig {
    private static final Logger LOG = Logger.getLogger(Main.class.toString());

    private String BOT_INFO;
    private String botUsername;
    private String botToken;

    @Bean
    public BotModel MySuperTelegramBot() {
        BotModel botModel = new BotModel();
        botModel.setBotUsername(getBotUsername());
        botModel.setBotToken(getBotToken());
        botModel.setBOT_INFO(getBOT_INFO());
        registerBot(botModel);
        return botModel;
    }

    private void registerBot(BotModel botModel) {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi();
            botsApi.registerBot(botModel);
        } catch (TelegramApiRequestException exception) {
            LOG.info(exception.getMessage());
        }
    }

    public String getBOT_INFO() {
        return BOT_INFO;
    }

    public void setBOT_INFO(String BOT_INFO) {
        this.BOT_INFO = BOT_INFO;
    }

    public String getBotUsername() {
        return botUsername;
    }

    public void setBotUsername(String botUsername) {
        this.botUsername = botUsername;
    }

    public String getBotToken() {
        return botToken;
    }

    public void setBotToken(String botToken) {
        this.botToken = botToken;
    }
}
