package com.example.board.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface EmailMapper {
    String mailIdFind(Map<String, Object> params);

    int mailPwFind(Map<String, Object> params);
}
