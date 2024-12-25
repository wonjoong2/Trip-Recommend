package com.example.board.service;

import java.util.Map;

public interface TravelService {

    int InsertGeneralTravel(Map<String, Object> params);
    int InsertCulture(Map<String, Object> params);

    int InsertEvent(Map<String, Object> params);

    int InsertTourCourse(Map<String, Object> params);

    int InsertLeisureSports(Map<String, Object> params);

    int InsertLodging(Map<String, Object> params);

    int InsertShopping(Map<String, Object> params);

    int InsertFood(Map<String, Object> params);
}
