package model;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class BotModel extends TelegramLongPollingBot {

    private static final String BOT_USERNAME = "testbot";
    private static final String BOT_TOKEN = "";


    @Override
    public void onUpdateReceived(Update update) {
        Long chatId = update.getMessage().getChatId();
        String inputText = update.getMessage().getText();
        sendMessageIfBotStart(inputText, chatId);
    }

    private void sendMessageIfBotStart(String inputText, Long chatId) {
        if (inputText.startsWith("/start")) {
            SendMessage message = new SendMessage()
                    .setChatId(chatId)
                    .setText("Hello. This is start message");
            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return BOT_USERNAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }
}
