package model;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class BotModel extends TelegramLongPollingBot {

    private String BOT_INFO;
    private String botUsername;
    private String botToken;

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
                    .setText(BOT_INFO);
            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    public void setBotUsername(String botUsername) {
        this.botUsername = botUsername;
    }

    public void setBotToken(String botToken) {
        this.botToken = botToken;
    }

    public String getBOT_INFO() {
        return BOT_INFO;
    }

    public void setBOT_INFO(String BOT_INFO) {
        this.BOT_INFO = BOT_INFO;
    }
}
