package com.prototype;

import java.util.Hashtable;

/**
 *  创建类 ShapeCache，从数据库获取实体类，并把它们存储在一个 Hashtable 中
 */
public class ShapeCache {
    private static Hashtable<String, Shape> hashtable = new Hashtable<String, Shape>();

    public static Shape getShape(String shapeId) {
        Shape shape = hashtable.get(shapeId);
        return (Shape) shape.clone();
    }

    // 对每种形状都运行数据库查询，并创建该形状
    // shapeMap.put(shapeKey, shape);
    // 例如，我们要添加三种形状
    public static void loadCache() {
        Square square = new Square();
        square.setId("1");
        hashtable.put(square.getId(), square);

        Circle circle = new Circle();
        circle.setId("2");
        hashtable.put(circle.getId(), circle);

        Rectangle rectangle = new Rectangle();
        rectangle.setId("3");
        hashtable.put(rectangle.getId(), rectangle);
    }
}
