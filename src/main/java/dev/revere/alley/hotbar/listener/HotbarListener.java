package dev.revere.alley.hotbar.listener;

import dev.revere.alley.Alley;
import dev.revere.alley.hotbar.HotbarItem;
import dev.revere.alley.hotbar.enums.HotbarType;
import dev.revere.alley.party.menu.duel.DuelOtherPartyMenu;
import dev.revere.alley.party.menu.event.PartyEventMenu;
import dev.revere.alley.visual.leaderboard.menu.personal.StatisticsMenu;
import dev.revere.alley.game.match.menu.CurrentMatchesMenu;
import dev.revere.alley.profile.Profile;
import dev.revere.alley.queue.menu.QueuesMenu;
import dev.revere.alley.queue.menu.RankedMenu;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author Remi
 * @project Alley
 * @date 5/27/2024
 */
public class HotbarListener implements Listener {
    private final Map<UUID, Long> lastInteraction = new HashMap<>();
    private static final long COOLDOWN_TIME = 300;

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Action action = event.getAction();
        if ((action != Action.RIGHT_CLICK_AIR && action != Action.RIGHT_CLICK_BLOCK)) {
            return;
        }

        Player player = event.getPlayer();
        UUID playerId = player.getUniqueId();
        long currentTime = System.currentTimeMillis();

        if (lastInteraction.containsKey(playerId) && (currentTime - lastInteraction.get(playerId)) < COOLDOWN_TIME) {
            return;
        }

        lastInteraction.put(playerId, currentTime);

        ItemStack item = player.getItemInHand();
        if (item == null || !item.hasItemMeta() || !item.getItemMeta().hasDisplayName()) {
            return;
        }

        Profile profile = Alley.getInstance().getProfileRepository().getProfile(player.getUniqueId());
        HotbarItem hotbarItem = Alley.getInstance().getHotbarRepository().getItemByStack(item);

        if (hotbarItem != null) {
            String command = hotbarItem.getHotbarItems().getCommand();
            if (command != null && !command.isEmpty()) {
                player.performCommand(command);
            } else {
                switch (profile.getState()) {
                    case LOBBY:
                        switch (hotbarItem.getHotbarItems()) {
                            case UNRANKED_QUEUES:
                                new QueuesMenu().openMenu(player);
                                break;
                            case RANKED_QUEUES:
                                new RankedMenu().openMenu(player);
                            case CURRENT_MATCHES:
                                new CurrentMatchesMenu().openMenu(player);
                                break;
                            case KIT_EDITOR:
                                break;
                            case LEADERBOARD:
                                new StatisticsMenu().openMenu(player);
                                break;
                            case OPTIONS_ENABLE:
                                Alley.getInstance().getHotbarRepository().applyHotbarItems(player, HotbarType.SETTINGS);
                                break;
                            case OPTIONS_DISABLE:
                                Alley.getInstance().getHotbarRepository().applyHotbarItems(player, HotbarType.LOBBY);
                                break;
                            case START_PARTY_EVENT:
                                new PartyEventMenu().openMenu(player);
                                break;
                            case FIGHT_OTHER_PARTY:
                                new DuelOtherPartyMenu().openMenu(player);
                                break;
                        }
                        break;
                }
            }
        }
    }
}