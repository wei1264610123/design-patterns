package com.prototype;

/**
 * PrototypePatternDemo 使用 ShapeCache 类获取存储在 Hashtable 中的形状的克隆
 */
public class PrototypePatternDemo {
    public static void main(String[] args) {
        ShapeCache.loadCache();
        Shape clonedShape = (Shape) ShapeCache.getShape("1");
        System.out.println("Shape : " + clonedShape.getType());

        Shape clonedShape2 = (Shape) ShapeCache.getShape("2");
        System.out.println("Shape : " + clonedShape2.getType());

        Shape clonedShape3 = (Shape) ShapeCache.getShape("3");
        System.out.println("Shape : " + clonedShape3.getType());


        System.out.println(clonedShape);
        System.out.println(clonedShape2);
        System.out.println(clonedShape3);
    }
}
