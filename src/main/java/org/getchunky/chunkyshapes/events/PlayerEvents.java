package org.getchunky.chunkyshapes.events;

import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.getchunky.chunkyshapes.DrawingManager;
import org.getchunky.chunkyshapes.PointManager;
import org.getchunky.chunkyshapes.objects.ChunkyShape;

import java.awt.*;

public class PlayerEvents extends PlayerListener {
    @Override
    public void onPlayerMove(PlayerMoveEvent event) {
        int i = DrawingManager.addPoint(event.getPlayer());
        if(i>0) event.getPlayer().sendMessage("Points:" + i);
    }

    @Override
    public void onPlayerInteract(PlayerInteractEvent event) {
        if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            Point p = new Point(event.getClickedBlock().getX(),event.getClickedBlock().getZ());
            ChunkyShape chunkyShape = PointManager.getShape(p);
            event.getPlayer().sendMessage(chunkyShape.getOwner().getName());
        }
    }
}
