package org.getchunky.chunkyshapes.objects;

import org.bukkit.Material;
import org.bukkit.World;
import org.getchunky.chunky.object.ChunkyObject;
import org.getchunky.chunky.util.Logging;
import org.getchunky.chunkyshapes.PointManager;
import org.json.JSONArray;
import org.json.JSONException;
import java.awt.*;

public class ChunkyShape extends ChunkyObject {

    Polygon shape = new Polygon();

    @Override
    public void load(String json) throws JSONException {
        super.load(json);
        loadShape();
    }

    private void loadShape() {
        JSONArray points = getArray("points");
        //for(int i=0;i<points.length();i++)
            //shape.addPoint(points.getInt(i),zs.getInt(i));
    }

    private JSONArray getArray(String key) {
        if(this.getData().has(key)) return this.getData().getJSONArray(key);
        JSONArray s = new JSONArray();
        this.getData().put(key,s);
        return s;
    }

    private boolean hasPoint(int x, int z) {
        JSONArray points = getArray("points");
        String key = x + "-" + z;
        for(int i=0;i<points.length();i++)
            if(points.getString(i).equals(key)) return true;
        return false;
    }

    public int addPoint(int x, int z) {
        if(hasPoint(x, z)) return -1;
        shape.addPoint(x,z);
        getArray("points").put(x+"-"+z);
        return shape.npoints;
        //save();
    }

    public void addAllPoints(World world) {
        Rectangle rectangle = shape.getBounds();
        Logging.debug("X: " + rectangle.getX() + "Y: " + rectangle.getY() +"Width: "+ rectangle.getWidth() + " Height: " + rectangle.getHeight());
        for(int x=(int)rectangle.getX();x< rectangle.getX() + rectangle.getWidth(); x++) {
            for(int z=(int)rectangle.getY();z< rectangle.getY() + rectangle.getHeight(); z++) {
                if(!shape.contains(x,z)) {
                    world.getBlockAt(x,90,z).setType(Material.STONE);
                    continue;};
                addPoint(x,z);
                PointManager.registerPoint(x,z,this);
                world.getBlockAt(x, 90, z).setType(Material.DIRT);}}

    }


}
