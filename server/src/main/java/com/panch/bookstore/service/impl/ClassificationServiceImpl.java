package com.panch.bookstore.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.panch.bookstore.mapper.ClassificationMapper;
import com.panch.bookstore.entity.Classification;
import com.panch.bookstore.service.ClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassificationServiceImpl extends ServiceImpl<ClassificationMapper, Classification> implements ClassificationService {

    @Autowired
    ClassificationMapper mapper;

    @Override
    public List<Classification> getClassificationList() {
        return mapper.selectList(new QueryWrapper<>());
    }

    @Override
    public void createClassification(Classification classification) {
        System.out.println(classification);
        classification.setCreateTime(String.valueOf(System.currentTimeMillis()));
        mapper.insert(classification);
    }

    @Override
    public void deleteClassification(String id) {
        mapper.deleteById(id);
    }

    @Override
    public void updateClassification(Classification classification) {
        mapper.updateById(classification);
    }
}
