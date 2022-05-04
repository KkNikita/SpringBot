package telegrambot;

import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import telegrambot.commands.Command;
import telegrambot.entry.TelegramBotEntry;


public class TelegramBot extends TelegramWebhookBot {
    private final TelegramBotEntry telegramBotEntry;
    private Command command;


    public TelegramBot(TelegramBotEntry telegramBotEntry) {
        this.telegramBotEntry = telegramBotEntry;
    }

    @Override
    public String getBotToken() {
        return telegramBotEntry.getBotToken();
    }

    @Override
    public String getBotUsername() {
        return telegramBotEntry.getBotUserName();
    }

    @Override
    public String getBotPath() {
        return telegramBotEntry.getWebHookPath();
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        if (update.getMessage() != null && update.getMessage().hasText()) {
            try {
                if (TelegramBotEntry.BotState.AVAILABLE.equals(telegramBotEntry.getBotState())) {
                    command = telegramBotEntry.getCommand(update.getMessage().getText());
                }
                command.executeCommand(update);
                //execute(new SendMessage(Long.toString(update.getMessage().getChatId()), "Hi " + update.getMessage().getText()));
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
