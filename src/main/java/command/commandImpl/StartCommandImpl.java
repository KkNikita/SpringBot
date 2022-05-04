package command.commandImpl;

import command.Command;


public class StartCommandImpl implements Command {

    private String botInfo;

    @Override
    public String execute(Long chatId) {
        return getBotInfo();
    }

    public String getBotInfo() {
        return botInfo;
    }

    public void setBotInfo(String botInfo) {
        this.botInfo = botInfo;
    }

}
