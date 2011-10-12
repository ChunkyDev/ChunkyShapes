package org.getchunky.chunkyshapes;

import org.getchunky.chunkyshapes.objects.ChunkyShape;

import java.awt.*;
import java.util.HashMap;

public class PointManager {

    private static HashMap<Point,ChunkyShape> shapes = new HashMap<Point, ChunkyShape>();

    public static void registerPoint(int x, int z, ChunkyShape shape) {
        Point point = new Point(x,z);
        shapes.put(point,shape);
    }

    public static ChunkyShape getShape(Point point) {
        return shapes.get(point);
    }
}
