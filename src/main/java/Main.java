import model.BotModel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

import java.util.logging.Logger;


public class Main {
    private static final String SPRING_CONTEXT_XML = "spring.xml";
    private static final String SPRING_BEAN = "botModel";
    private static final Logger LOG = Logger.getLogger(Main.class.toString());

    public static void main(String[] args) {
        try {
            ApiContextInitializer.init();
            ApplicationContext ap = new ClassPathXmlApplicationContext(SPRING_CONTEXT_XML);
            BotModel botModel = ap.getBean(SPRING_BEAN, BotModel.class);
            TelegramBotsApi botsApi = new TelegramBotsApi();
            botsApi.registerBot(botModel);
        } catch (TelegramApiRequestException exception) {
            LOG.info(exception.getMessage());
        }
    }
}
