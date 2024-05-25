package me.emmy.alley.queue.menu.unranked;

import lombok.AllArgsConstructor;
import me.emmy.alley.Alley;
import me.emmy.alley.queue.Queue;
import me.emmy.alley.queue.menu.queues.QueuesMenu;
import me.emmy.alley.utils.menu.Button;
import me.emmy.alley.utils.menu.Menu;
import me.emmy.alley.utils.menu.button.BackButton;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Emmy
 * Project: Alley
 * Discord: dsc.gg/emmiesa
 */

public class UnrankedMenu extends Menu {

    //private QueuesMenu previousMenu;

    @Override
    public String getTitle(Player player) {
        return "Unranked Queue";
    }

    @Override
    public Map<Integer, Button> getButtons(Player player) {
        Map<Integer, Button> buttons = new HashMap<>();

        //buttons.put(0, new BackButton(previousMenu));

        for (Queue queue : Alley.getInstance().getQueueRepository().getQueues()) {
            buttons.put(queue.getKit().getUnrankedslot(), new UnrankedButton(queue));
        }

        return buttons;
    }

    @Override
    public int getSize() {
        return 9 * 5;
    }
}