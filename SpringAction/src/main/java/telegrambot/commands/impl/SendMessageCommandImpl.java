package telegrambot.commands.impl;

import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import telegrambot.commands.Command;

public class SendMessageCommandImpl extends DefaultAbsSender implements Command {

    private final String botToken;

    public SendMessageCommandImpl(DefaultBotOptions options, String botToken) {
        super(options);
        this.botToken = botToken;
    }

    @Override
    public String getBotToken() {
        return this.botToken;
    }

    @Override
    public void executeCommand(Update update) throws TelegramApiException {
        String chat_id = Long.toString(update.getMessage().getChatId());
        execute(new SendMessage(chat_id, "Greeting!!"));
    }

    @Override
    public String toString() {
        return "/send";
    }
}
