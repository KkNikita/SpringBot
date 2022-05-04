package telegrambot.commands;

import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public interface Command {

    void executeCommand(Update update) throws TelegramApiException;
}
