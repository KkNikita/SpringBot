package telegrambot.entry;

import org.telegram.telegrambots.bots.DefaultBotOptions;
import telegrambot.commands.Command;

import java.util.HashMap;
import java.util.Map;

public class TelegramBotEntry {
    private String webHookPath;
    private String botUserName;
    private String botToken;
    private DefaultBotOptions botOptions;
    private static final Map<String, Command> commands = new HashMap<>();
    private static BotState botState;

    public void addCommand(Command command) {
        commands.put(command.toString(), command);
    }

    public void addCommands(Map<String, Command> commands) {
        TelegramBotEntry.commands.putAll(commands);
    }

    public Map<String, Command> getCommands() {
        return commands;
    }

    public Command getCommand(String command) {
        return commands.get(command);
    }

    public BotState getBotState() {
        return botState;
    }

    public void setBotState(BotState botState) {
        TelegramBotEntry.botState = botState;
    }

    public enum BotState {
        SEND("/send"),
        REGISTER("/register"),
        AVAILABLE("/available");

        private String state;

        BotState(String state) {
            this.state = state;
        }

        public BotState setState(String state) {
            this.state = state;
            return this;
        }

        public BotState getState(){
            return this;
        }

        @Override
        public String toString() {
            return this.state;
        }
    }

    public String getWebHookPath() {
        return webHookPath;
    }

    public void setWebHookPath(String webHookPath) {
        this.webHookPath = webHookPath;
    }

    public String getBotUserName() {
        return botUserName;
    }

    public void setBotUserName(String botUserName) {
        this.botUserName = botUserName;
    }

    public String getBotToken() {
        return botToken;
    }

    public void setBotToken(String botToken) {
        this.botToken = botToken;
    }

    public DefaultBotOptions getBotOptions() {
        return botOptions;
    }

    public void setBotOptions(DefaultBotOptions botOptions) {
        this.botOptions = botOptions;
    }
}
