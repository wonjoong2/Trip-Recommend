package com.example.board.service.impl;

import com.example.board.mapper.MyPageRepository;
import com.example.board.mapper.TravelRepository.*;
import com.example.board.service.MyPageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class MyPageServiceImpl implements MyPageService {

    private final GeneralTravelRepository generalTravelRepository;
    private final CultureRepository cultureRepository;
    private final EventRepository eventRepository;
    private final TourCourseRepository tourCourseRepository;
    private final LeisureSportsRepository leisureSportsRepository;
    private final LodgingRepository lodgingRepository;
    private final ShoppingRepository shoppingRepository;
    private final FoodRepository foodRepository;

    @Override
    public Map<String, Object> myTravelList(Map<String, Object> params) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        String userSeqStr = (String) params.get("userSeq");
        Integer userSeq = Integer.parseInt(userSeqStr);
        map.put("myGeneralTravelList", generalTravelRepository.myGeneralTravelList(userSeq));
        map.put("myCultureList", cultureRepository.myCultureList(userSeq));
        map.put("myEventList", eventRepository.myEventList(userSeq));
        map.put("myTourCourseList", tourCourseRepository.myTourCourseList(userSeq));
        map.put("myLeisureSportsList", leisureSportsRepository.myLeisureSportsList(userSeq));
        map.put("myLodgingList", lodgingRepository.myLodgingList(userSeq));
        map.put("myShoppingList", shoppingRepository.myShoppingList(userSeq));
        map.put("myFoodList", foodRepository.myFoodList(userSeq));

        System.out.println("====================map");
        System.out.println(map);
        return map;
    }
}
