package com.demo.service;

import com.demo.domain.President;

import java.util.List;
import java.util.Map;

public interface PresidentService {
    List<President>findPresidentByPresName(String presName);
    List<Map<String,Object>>findPresidentByListMap(String presName);
    List<President>findAll();
    President insert(President president);
    void insertByJsonObject(String  json);
    President update(President president);
    void delete(Long presId);
}
