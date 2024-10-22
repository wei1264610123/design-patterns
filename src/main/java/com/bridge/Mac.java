package com.bridge;

/**
 * 4. mac 操作系统
 * 扩展抽象类角色
 */
public class Mac extends OpSystem {
    public Mac(VideoFile videoFile) {
        super(videoFile);
    }

    @Override
    public void play(String fileName) {
        videoFile.decode(fileName);
    }
}
