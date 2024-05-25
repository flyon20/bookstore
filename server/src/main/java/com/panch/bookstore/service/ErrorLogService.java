package com.panch.bookstore.service;


import com.panch.bookstore.entity.ErrorLog;

import java.util.List;

public interface ErrorLogService {
    List<ErrorLog> getErrorLogList();
    void createErrorLog(ErrorLog errorLog);
    void deleteErrorLog(String id);
    void updateErrorLog(ErrorLog errorLog);
}
