package com.panch.bookstore.service;


import com.panch.bookstore.entity.ThingWish;

import java.util.List;
import java.util.Map;

public interface ThingWishService {
    List<Map> getThingWishList(String userId);
    void createThingWish(ThingWish thingWish);
    void deleteThingWish(String id);

    ThingWish getThingWish(String userId, String thingId);
}
