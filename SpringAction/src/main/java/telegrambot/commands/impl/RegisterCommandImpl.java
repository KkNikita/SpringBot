package telegrambot.commands.impl;

import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import telegrambot.commands.Command;
import telegrambot.entry.TelegramBotEntry;
import telegrambot.entry.TelegramBotEntry.BotState;

public class RegisterCommandImpl extends DefaultAbsSender implements Command {

    private final TelegramBotEntry telegramBotEntry;
    private final User user = new User();

    public RegisterCommandImpl(TelegramBotEntry telegramBotEntry) {
        super(telegramBotEntry.getBotOptions());
        this.telegramBotEntry = telegramBotEntry;
    }

    @Override
    public String getBotToken() {
        return telegramBotEntry.getBotToken();
    }

    @Override
    public void executeCommand(Update update) throws TelegramApiException {
        String chat_id = Long.toString(update.getMessage().getChatId());
        if (BotState.AVAILABLE.equals(telegramBotEntry.getBotState())) {
            execute(new SendMessage(chat_id, "please enter credentials\n username:"));
            telegramBotEntry.setBotState(BotState.REGISTER.setState("firstname"));
            return;
        }
        user.setUserName(update.getMessage().getText());
        if ("firstname".equals(telegramBotEntry.getBotState().getState().toString())) {
            execute(new SendMessage(chat_id, "please enter credentials\n firstname:"));
            telegramBotEntry.setBotState(BotState.REGISTER.setState("finish"));
            return;
        }
        user.setFirstName(update.getMessage().getText());
        //register
        execute(new SendMessage(chat_id, "you've successfully registered!)"));
        telegramBotEntry.setBotState(BotState.AVAILABLE);
    }

    @Override
    public String toString() {
        return "/register";
    }
}


