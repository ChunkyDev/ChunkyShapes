package org.getchunky.chunkyshapes.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.getchunky.chunky.locale.Language;
import org.getchunky.chunky.module.ChunkyCommand;
import org.getchunky.chunkyshapes.DrawingManager;

public class Draw implements CommandExecutor{

    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if(!(sender instanceof Player)) {
            Language.IN_GAME_ONLY.bad(sender);
            return false;
        }

        if(DrawingManager.toggleDrawer(sender.getName())) {
            Language.sendMessage(sender,"Please trace your shape.");
            return true;}

        Language.sendMessage(sender,"Stopped drawing.");
        return true;
    }
}
