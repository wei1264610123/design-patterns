package com.bridge;

/**
 * 2.Rmvb 视频文件
 * 具体的实现化角色
 */
public class RmvbFile implements VideoFile {
    @Override
    public void decode(String fileName) {
        System.out.println("Rmvb 视频文件：" + fileName);
    }
}
