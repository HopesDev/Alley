package me.emmy.alley.profile.division.command.impl;

import me.emmy.alley.Alley;
import me.emmy.alley.utils.chat.CC;
import me.emmy.alley.utils.command.BaseCommand;
import me.emmy.alley.utils.command.Command;
import me.emmy.alley.utils.command.CommandArgs;
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
        player.sendMessage(CC.FLOWER_BAR);
        player.sendMessage(CC.translate("     &d&lDivision List &f(" + Alley.getInstance().getDivisionRepository().getDivisions().size() + "&f)"));
        if (Alley.getInstance().getDivisionRepository().getDivisions().isEmpty()) {
            player.sendMessage(CC.translate("      &f● &cNo Divisions available."));
        }
        Alley.getInstance().getDivisionRepository().getDivisions().forEach(division -> player.sendMessage(CC.translate("      &f● &d" + division.getName() + " &f(&d" + division.getLevel().getName() + "&f) (&d" + division.getEloMin() + " &f- &d" + division.getEloMax() + "&f)")));
        player.sendMessage(CC.FLOWER_BAR);
        player.sendMessage("");

    }
}