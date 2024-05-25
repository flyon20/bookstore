package com.panch.bookstore.controller;

import com.panch.bookstore.common.APIResponse;
import com.panch.bookstore.common.ResponeCode;
import com.panch.bookstore.entity.OpLog;
import com.panch.bookstore.service.OpLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
/**
 * @author xsj
 */
// 负责操作日志和登录日志
@RestController
@RequestMapping("/opLog")
public class OpLogController {

    private final static Logger logger = LoggerFactory.getLogger(OpLogController.class);

    @Autowired
    OpLogService service;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public APIResponse list(){
        List<OpLog> list =  service.getOpLogList();
        return new APIResponse(ResponeCode.SUCCESS, "查询成功", list);
    }

    @RequestMapping(value = "/loginLogList", method = RequestMethod.GET)
    public APIResponse loginLogList(){
        List<OpLog> list =  service.getLoginLogList();
        return new APIResponse(ResponeCode.SUCCESS, "查询成功", list);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @Transactional
    public APIResponse create(OpLog opLog) throws IOException {
        service.createOpLog(opLog);
        return new APIResponse(ResponeCode.SUCCESS, "创建成功");
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public APIResponse delete(String ids){
        System.out.println("ids===" + ids);
        // 批量删除
        String[] arr = ids.split(",");
        for (String id : arr) {
            service.deleteOpLog(id);
        }
        return new APIResponse(ResponeCode.SUCCESS, "删除成功");
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @Transactional
    public APIResponse update(OpLog opLog) throws IOException {
        service.updateOpLog(opLog);
        return new APIResponse(ResponeCode.SUCCESS, "更新成功");
    }

}
