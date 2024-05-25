package com.panch.bookstore.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.panch.bookstore.entity.ThingCollect;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ThingCollectMapper extends BaseMapper<ThingCollect> {


    List<Map> getThingCollectList(String userId);
}
