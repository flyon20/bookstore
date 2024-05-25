package com.panch.bookstore.service;


import com.panch.bookstore.entity.Notice;

import java.util.List;

public interface NoticeService {
    List<Notice> getNoticeList();
    void createNotice(Notice notice);
    void deleteNotice(String id);

    void updateNotice(Notice notice);
}
