package org.getchunky.chunkyshapes;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.getchunky.chunky.ChunkyManager;
import org.getchunky.chunkyshapes.objects.ChunkyShape;

import java.awt.*;
import java.util.HashMap;
import java.util.HashSet;

public class DrawingManager {

    private static HashMap<String, ChunkyShape> drawings = new HashMap<String, ChunkyShape>();

    public static boolean toggleDrawer(String player) {
        if(drawings.containsKey(player)) {
            drawings.remove(player);
            return false;
        }
        getShape(player);
        return true;
    }

    public static boolean isDrawer(String player) {
        return drawings.keySet().contains(player);
    }


    private static ChunkyShape getShape(String player) {
        if(drawings.containsKey(player)) return drawings.get(player);
        ChunkyShape shape = new ChunkyShape();
        shape.setOwner(ChunkyManager.getChunkyPlayer(player),true, false);
        drawings.put(player,shape);
        return shape;
    }

    public static int addPoint(Player player) {
        if(!isDrawer(player.getName())) return 0;
        ChunkyShape shape = getShape(player.getName());
        int i = shape.addPoint(player.getLocation().getBlockX(), player.getLocation().getBlockZ());
        player.getWorld().getHighestBlockAt(player.getLocation()).setType(Material.SNOW);
        return i;
    }

    public static void saveShape(Player player) {
        ChunkyShape shape = getShape(player.getName());
        shape.addAllPoints(player.getWorld());
        toggleDrawer(player.getName());
    }

}
