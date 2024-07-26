package com.builder.demo2;

/**
 * 手机类
 */
public class Phone {
    private String cpu;
    private String screen;

    private String memory;

    private String mainboard;


    //私有构造方法
    private Phone(Builder build) {
        this.cpu = build.cpu;
        this.screen = build.screen;
        this.memory = build.memory;
        this.mainboard = build.mainboard;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "cpu='" + cpu + '\'' +
                ", screen='" + screen + '\'' +
                ", memory='" + memory + '\'' +
                ", mainboard='" + mainboard + '\'' +
                '}';
    }

    public static final class Builder {
        private String cpu;
        private String screen;

        private String memory;

        private String mainboard;

        public Builder cpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder screen(String screen) {
            this.screen = screen;
            return this;
        }

        public Builder memory(String memory) {
            this.memory = memory;
            return this;
        }

        public Builder mainboard(String mainboard) {
            this.mainboard = mainboard;
            return this;
        }

        //使用构建者创建Phone对象
        public Phone build() {
            return new Phone(this);
        }
    }

}
