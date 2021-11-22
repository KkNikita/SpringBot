import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

import java.util.logging.Logger;


public class Main {
    private static final Logger LOG = Logger.getLogger(Main.class.toString());

    public static void main(String[] args) {
        try {
            ApiContextInitializer.init();
            TelegramBotsApi botsApi = new TelegramBotsApi();
            botsApi.registerBot();
        } catch (TelegramApiRequestException exception) {
            LOG.info(exception.getMessage());
        }
    }
}
