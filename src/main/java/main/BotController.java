package main;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.api.objects.Update;

@RestController
public class BotController {
    private final BotModel botModel;

    public BotController(BotModel botModel) {
        this.botModel = botModel;
    }

    @PostMapping("/")
    public void onUpdateReceived(@RequestBody Update update) {
        botModel.onUpdateReceived(update);
    }
}
