package com.panch.bookstore.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.panch.bookstore.entity.Thing;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ThingMapper extends BaseMapper<Thing> {
//    List<Thing> getList();
//    boolean update(Thing thing);
}
