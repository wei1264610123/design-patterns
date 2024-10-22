package com.combination;

/**
 * 组合模式
 */
public class Client {
    public static void main(String[] args) {
        //创建菜单树
        MenuComponent menu1 = new Menu("菜单管理", 2);
        menu1.add(new MenuItem("页面访问", 3));
        menu1.add(new MenuItem("展开菜单", 3));
        menu1.add(new MenuItem("编辑菜单", 3));
        menu1.add(new MenuItem("删除菜单", 3));
        menu1.add(new MenuItem("新增菜单", 3));

        MenuComponent menu2 = new Menu("权限管理", 2);
        menu2.add(new MenuItem("页面访问", 3));
        menu2.add(new MenuItem("提交保存", 3));

        MenuComponent menu3 = new Menu("角色管理", 2);
        menu3.add(new MenuItem("页面访问", 3));
        menu3.add(new MenuItem("新增角色", 3));
        menu3.add(new MenuItem("修改角色", 3));


        MenuComponent menu4 = new Menu("角色管理", 3);
        menu4.add(new MenuItem("页面访问", 4));
        menu4.add(new MenuItem("新增角色", 4));
        menu4.add(new MenuItem("修改角色", 4));


        //创建一级菜单
        MenuComponent menuComponent = new Menu("系统管理",1);
        //将二级菜单添加到一级菜单中
        menuComponent.add(menu1);
        menuComponent.add(menu2);
        menuComponent.add(menu3);
        menu2.add(menu4);

        //打印菜单名称（如果有子菜单一块打印）
        menuComponent.print();

    }
}
