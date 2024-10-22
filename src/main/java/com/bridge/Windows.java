package com.bridge;

/**
 * 4.扩展抽象化角色
 * windows 操作系统
 */
public class Windows extends OpSystem {
    public Windows(VideoFile videoFile) {
        super(videoFile);
    }

    @Override
    public void play(String fileName) {
        videoFile.decode(fileName);
    }
}
