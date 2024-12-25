package com.example.board.service.impl;

import com.example.board.DTO.Travel.*;
import com.example.board.mapper.TravelRepository.*;
import com.example.board.service.TravelService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.FloatBuffer;
import java.time.LocalDateTime;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TravelServiceImpl implements TravelService {

    private final GeneralTravelRepository generalTravelRepository;
    private final CultureRepository cultureRepository;
    private final EventRepository eventRepository;
    private final TourCourseRepository tourCourseRepository;
    private final LeisureSportsRepository leisureSportsRepository;
    private final LodgingRepository lodgingRepository;
    private final ShoppingRepository shoppingRepository;
    private final FoodRepository foodRepository;

    @Override
    public int InsertGeneralTravel(Map<String, Object> params) {
        GeneralTravel gT = new GeneralTravel();
        Integer userSeq = (Integer) params.get("userSeq");
        gT.setUserSeq(userSeq);
        gT.setAccomCount((String) params.get("accomCount"));
        gT.setChkBabyCarriage((String) params.get("chkBabyCarriage"));
        gT.setChkCreditCard((String) params.get("chkCreditCard"));
        gT.setChkPet((String) params.get("chkPet"));
        gT.setExpAgeRange((String) params.get("expAgeRange"));
        gT.setInfoCenter((String) params.get("infoCenter"));
        gT.setOpenDate((String) params.get("openDate"));
        gT.setRestDate((String) params.get("restDate"));
        gT.setUseSeason((String) params.get("useSeason"));
        gT.setUseTime((String) params.get("useTime"));

        gT.setAddress((String) params.get("addr1"));
        gT.setImage((String) params.get("firstImage"));
        gT.setPlace((String) params.get("title"));
        gT.setContentId((String) params.get("contentId"));
        gT.setContentTypeId((String) params.get("contentTypeId"));

        gT.setCreateId((String) params.get("userId"));
        gT.setCreateDt(LocalDateTime.now());

        GeneralTravel saveGt = generalTravelRepository.save(gT);
        return saveGt.getUserSeq();
    }

    @Override
    public int InsertCulture(Map<String, Object> params) {
        Culture culture = new Culture();
        Integer userSeq = (Integer) params.get("userSeq");
        culture.setUserSeq(userSeq);

        culture.setInfoCenterCulture((String) params.get("infoCenterCulture"));
        culture.setParkingCulture((String) params.get("parkingCulture"));
        culture.setUseFee((String) params.get("useFee"));
        culture.setScale((String) params.get("scale"));

        culture.setAddress((String) params.get("addr1"));
        culture.setImage((String) params.get("firstImage"));
        culture.setPlace((String) params.get("title"));
        culture.setContentTypeId((String) params.get("contentTypeId"));
        culture.setContentId((String) params.get("contentId"));

        culture.setCreateId((String) params.get("userId"));
        culture.setCreateDt(LocalDateTime.now());

        Culture saveCulture = cultureRepository.save(culture);
        return saveCulture.getUserSeq();
    }

    @Override
    public int InsertEvent(Map<String, Object> params) {
        Event event = new Event();
        Integer userSeq = (Integer) params.get("userSeq");
        event.setUserSeq(userSeq);

        event.setEventPlace((String) params.get("eventPlace"));
        event.setEventStartDate((String) params.get("eventStartDate"));
        event.setEventEndDate((String) params.get("eventEndDate"));
        event.setPlayTime((String) params.get("playTime"));

        event.setAddress((String) params.get("addr1"));
        event.setImage((String) params.get("firstImage"));
        event.setPlace((String) params.get("title"));
        event.setContentTypeId((String) params.get("contentTypeId"));
        event.setContentId((String) params.get("contentId"));

        event.setCreateId((String) params.get("userId"));
        event.setCreateDt(LocalDateTime.now());

        Event saveEvent = eventRepository.save(event);
        return saveEvent.getUserSeq();
    }

    @Override
    public int InsertTourCourse(Map<String, Object> params) {
        TourCourse tc = new TourCourse();
        Integer userSeq = (Integer) params.get("userSeq");
        tc.setUserSeq(userSeq);

        tc.setDistance((String) params.get("distance"));
        tc.setInfoCenterTourCourse((String) params.get("infoCenterTourCourse"));
        tc.setSchedule((String) params.get("schedule"));
        tc.setTakeTime((String) params.get("takeTime"));
        tc.setTheme((String) params.get("theme"));

        tc.setAddress((String) params.get("addr1"));
        tc.setImage((String) params.get("firstImage"));
        tc.setPlace((String) params.get("title"));
        tc.setContentTypeId((String) params.get("contentTypeId"));
        tc.setContentId((String) params.get("contentId"));

        tc.setCreateId((String) params.get("userId"));
        tc.setCreateDt(LocalDateTime.now());

        TourCourse saveTc = tourCourseRepository.save(tc);
        return saveTc.getUserSeq();
    }

    @Override
    public int InsertLeisureSports(Map<String, Object> params) {
        System.out.println("============f12dsaf");
        System.out.println(params);
        LeisureSports ls = new LeisureSports();
        Integer userSeq = (Integer) params.get("userSeq");
        ls.setUserSeq(userSeq);

        ls.setAccomCountLeports((String) params.get("accomCountLeports"));
        ls.setChkBabyCarriageLeports((String) params.get("chkBabyCarriageLeports"));
        ls.setChkCreditCardLeports((String) params.get("chkCreditCardLeports"));
        ls.setExpAgeRangeLeports((String) params.get("expAgeRangeLeports"));
        ls.setInfoCenterLeports((String) params.get("infoCenterLeports"));
        ls.setOpenPeriod((String) params.get("openPeriod"));
        ls.setParkingFeeLeports((String) params.get("parkingFeeLeports"));
        ls.setParkingLeports((String) params.get("parkingLeports"));
        ls.setReservation((String) params.get("reservation"));
        ls.setRestDateLeports((String) params.get("restDateLeports"));
        ls.setScaleLeports((String) params.get("scaleLeports"));
        ls.setUseFeeLeports((String) params.get("useFeeLeports"));
        ls.setUseTimeLeports((String) params.get("useTimeLeports"));

        ls.setAddress((String) params.get("addr1"));
        ls.setImage((String) params.get("firstImage"));
        ls.setPlace((String) params.get("title"));
        ls.setContentTypeId((String) params.get("contentTypeId"));
        ls.setContentId((String) params.get("contentId"));

        ls.setCreateId((String) params.get("userId"));
        ls.setCreateDt(LocalDateTime.now());

        LeisureSports saveLs = leisureSportsRepository.save(ls);
        return saveLs.getUserSeq();
    }

    @Override
    public int InsertLodging(Map<String, Object> params) {
        Lodging lodging = new Lodging();
        Integer userSeq = (Integer) params.get("userSeq");
        lodging.setUserSeq(userSeq);

        lodging.setAccomCountLodging((String) params.get("accomCountLodging"));
        lodging.setBenikia((String) params.get("benikia"));
        lodging.setCheckInTime((String) params.get("checkInTime"));
        lodging.setCheckOutTime((String) params.get("checkOutTime"));
        lodging.setChkCooking((String) params.get("chkCooking"));
        lodging.setInfoCenterLodging((String) params.get("infoCenterLodging"));
        lodging.setParkingLodging((String) params.get("parkingLodging"));
        lodging.setRoomCount((String) params.get("roomCount"));
        lodging.setReservationLodging((String) params.get("reservationLodging"));
        lodging.setScaleLodging((String) params.get("scaleLodging"));
        lodging.setRefundRegulation((String) params.get("refundRegulation"));

        lodging.setAddress((String) params.get("addr1"));
        lodging.setImage((String) params.get("firstImage"));
        lodging.setPlace((String) params.get("title"));
        lodging.setContentTypeId((String) params.get("contentTypeId"));
        lodging.setContentId((String) params.get("contentId"));

        lodging.setCreateId((String) params.get("userId"));
        lodging.setCreateDt(LocalDateTime.now());

        Lodging saveLodging = lodgingRepository.save(lodging);
        return saveLodging.getUserSeq();
    }

    @Override
    public int InsertShopping(Map<String, Object> params) {
        Shopping shopping = new Shopping();
        Integer userSeq = (Integer) params.get("userSeq");
        shopping.setUserSeq(userSeq);

        shopping.setInfoCenterShopping((String) params.get("infoCenterShopping"));
        shopping.setOpenDateShopping((String) params.get("openDateShopping"));
        shopping.setOpenTime((String) params.get("openTime"));
        shopping.setParkingShopping((String) params.get("parkingShopping"));
        shopping.setSaleItem((String) params.get("saleItem"));
        shopping.setShopGuide((String) params.get("shopGuide"));

        shopping.setAddress((String) params.get("addr1"));
        shopping.setImage((String) params.get("firstImage"));
        shopping.setPlace((String) params.get("title"));
        shopping.setContentTypeId((String) params.get("contentTypeId"));
        shopping.setContentId((String) params.get("contentId"));

        shopping.setCreateId((String) params.get("userId"));
        shopping.setCreateDt(LocalDateTime.now());

        Shopping saveShopping = shoppingRepository.save(shopping);
        return saveShopping.getUserSeq();
    }

    @Override
    public int InsertFood(Map<String, Object> params) {
        Food food = new Food();
        Integer userSeq = (Integer) params.get("userSeq");
        food.setUserSeq(userSeq);

        food.setInfoCenterFood((String) params.get("infoCenterFood"));
        food.setFirstMenu((String) params.get("firstMenu"));
        food.setOpenTimeFood((String) params.get("openTimeFood"));
        food.setPacking((String) params.get("packing"));
        food.setParkingFood((String) params.get("parkingFood"));
        food.setTreatMenu((String) params.get("treatMenu"));
        food.setSeat((String) params.get("seat"));

        food.setAddress((String) params.get("addr1"));
        food.setImage((String) params.get("firstImage"));
        food.setPlace((String) params.get("title"));
        food.setContentTypeId((String) params.get("contentTypeId"));
        food.setContentId((String) params.get("contentId"));

        food.setCreateId((String) params.get("userId"));
        food.setCreateDt(LocalDateTime.now());

        Food saveFood = foodRepository.save(food);
        return saveFood.getUserSeq();
    }
}
