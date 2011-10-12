package org.getchunky.chunkyshapes.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.getchunky.chunky.locale.Language;
import org.getchunky.chunkyshapes.DrawingManager;

public class SaveShape implements CommandExecutor{
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if(!(sender instanceof Player)) {
            Language.IN_GAME_ONLY.bad(sender);
            return false;
        }

        Player player = (Player)sender;

        if(!DrawingManager.isDrawer(player.getName())) {
            return false;
        }

        DrawingManager.saveShape(player);
        return true;
    }
}
