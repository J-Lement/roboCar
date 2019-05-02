package com.dao;

import com.pojo.Video;

import java.util.List;

public interface VideoDao {
    Video queryCarVideo(int cId);

    List<Video> queryAllVideo();
}
