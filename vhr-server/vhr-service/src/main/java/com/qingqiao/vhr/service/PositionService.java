package com.qingqiao.vhr.service;

import com.qingqiao.vhr.bean.Position;

import java.util.List;

public interface PositionService {
    List<Position> getAllPosition();

    int insertPosition(Position position);

    int updatePosition(Position position);

    int deletePosition(Integer id);

    int deletePositionByIDS(Integer[] ids);
}
