package telegrambot.appconfig;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.DefaultBotOptions.ProxyType;
import telegrambot.TelegramBot;
import telegrambot.commands.Command;
import telegrambot.commands.impl.RegisterCommandImpl;
import telegrambot.commands.impl.SendMessageCommandImpl;
import telegrambot.entry.TelegramBotEntry;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "telegrambot")
public class BotConfig {
    private String webHookPath;
    private String botUserName;
    private String botToken;

    private ProxyType proxyType;
    private String proxyHost;
    private int proxyPort;

    @Bean
    public TelegramBot telegramBotConfig() {
        DefaultBotOptions options = new DefaultBotOptions();
        options.setProxyHost(getProxyHost());
        options.setProxyPort(getProxyPort());
        options.setProxyType(getProxyType());

        TelegramBotEntry telegramBotEntry = new TelegramBotEntry();
        telegramBotEntry.setBotOptions(options);
        telegramBotEntry.setBotToken(getBotToken());
        telegramBotEntry.setBotUserName(getBotUserName());
        telegramBotEntry.setWebHookPath(getWebHookPath());
        telegramBotEntry.setBotState(TelegramBotEntry.BotState.AVAILABLE);

        final Map<String, Command> commands = new HashMap<>();
        //commands.put(SendMessageCommandImpl.class.toString(),new SendMessageCommandImpl(options,getBotToken()));
        telegramBotEntry.addCommand(new RegisterCommandImpl(telegramBotEntry));
        telegramBotEntry.addCommand(new SendMessageCommandImpl(options, getBotToken()));
        //telegramBotEntry.addCommands(commands);
        return new TelegramBot(telegramBotEntry);
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

    public ProxyType getProxyType() {
        return proxyType;
    }

    public void setProxyType(DefaultBotOptions.ProxyType proxyType) {
        this.proxyType = proxyType;
    }

    public String getProxyHost() {
        return proxyHost;
    }

    public void setProxyHost(String proxyHost) {
        this.proxyHost = proxyHost;
    }

    public int getProxyPort() {
        return proxyPort;
    }

    public void setProxyPort(int proxyPort) {
        this.proxyPort = proxyPort;
    }
}
