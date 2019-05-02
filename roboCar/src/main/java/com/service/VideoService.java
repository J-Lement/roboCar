package com.service;

import com.pojo.Video;

import java.util.List;

public interface VideoService {
    Video queryCarVideo(int cId);

    List<Video> queryAllVideo();

    int operation(int order, int cId);
}
