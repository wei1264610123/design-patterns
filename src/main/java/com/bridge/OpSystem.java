package com.bridge;

/**
 * 3. 抽象的操作系统类
 * 抽象化角色
 */
public abstract class OpSystem {

    //聚合实现化角色
    protected VideoFile videoFile;

    public OpSystem(VideoFile videoFile) {
        this.videoFile = videoFile;
    }

    public abstract void play(String fileName);
}
