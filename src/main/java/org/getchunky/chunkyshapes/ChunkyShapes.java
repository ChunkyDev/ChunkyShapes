package org.getchunky.chunkyshapes;

import org.bukkit.event.Event;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.getchunky.chunkyshapes.commands.Draw;
import org.getchunky.chunkyshapes.commands.SaveShape;
import org.getchunky.chunkyshapes.events.PlayerEvents;

public class ChunkyShapes extends JavaPlugin {
    public void onDisable() {
        // TODO: Place any custom disable code here.
        System.out.println(this + " is now disabled!");
    }

    public void onEnable() {
        getCommand("draw").setExecutor(new Draw());
        getCommand("saveshape").setExecutor(new SaveShape());
        PluginManager pm = getServer().getPluginManager();
        PlayerEvents pe = new PlayerEvents();
        pm.registerEvent(Event.Type.PLAYER_MOVE, pe,Event.Priority.Normal, this);
        pm.registerEvent(Event.Type.PLAYER_INTERACT, pe,Event.Priority.Normal, this);
        System.out.println(this + " is now enabled!");
    }
}
