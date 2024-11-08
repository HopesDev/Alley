package dev.revere.alley.profile.division.command.impl;

import dev.revere.alley.Alley;
import dev.revere.alley.util.chat.CC;
import dev.revere.alley.api.command.BaseCommand;
import dev.revere.alley.api.command.Command;
import dev.revere.alley.api.command.CommandArgs;
import org.bukkit.entity.Player;

/**
 * @author Remi
 * @project Alley
 * @date 6/2/2024
 */
public class DivisionListCommand extends BaseCommand {
    @Command(name = "division.list", permission = "alley.admin")
    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        player.sendMessage("");
        player.sendMessage(CC.translate("     &b&lDivision List &f(" + Alley.getInstance().getDivisionRepository().getDivisions().size() + "&f)"));
        if (Alley.getInstance().getDivisionRepository().getDivisions().isEmpty()) {
            player.sendMessage(CC.translate("      &f● &cNo Divisions available."));
        }
        Alley.getInstance().getDivisionRepository().getDivisions().forEach(division -> player.sendMessage(CC.translate("      &f● &b" + division.getName() + " " + division.getLevel().getName().replace("Level ", "") + " &f(&b" + division.getLevel().getName() + "&f) (&b" + division.getEloMin() + " &f- &b" + division.getEloMax() + "&f)")));
        player.sendMessage("");

    }
}
