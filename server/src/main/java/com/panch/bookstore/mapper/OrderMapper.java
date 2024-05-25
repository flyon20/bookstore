package com.panch.bookstore.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.panch.bookstore.entity.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {

    List<Order> getList();

    List<Order> getUserOrderList(String userId, String status);
}
