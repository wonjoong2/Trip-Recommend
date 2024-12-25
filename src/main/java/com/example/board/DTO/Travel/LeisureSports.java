package com.example.board.DTO.Travel;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "travel_leisure_sports")
public class LeisureSports {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRAVEL_SEQ")
    private Integer travelSeq;

    @Column(name = "USER_SEQ")
    private Integer userSeq;

    @Column(name = "ACCOM_COUNT_LEPORTS", length = 255, nullable = false)
    private String accomCountLeports = "정보 없음";

    @Column(name = "CHK_BABY_CARRIAGE_LEPORTS", length = 255, nullable = false)
    private String chkBabyCarriageLeports = "정보 없음";

    @Column(name = "CHK_CREDIT_CARD_LEPORTS", length = 255, nullable = false)
    private String chkCreditCardLeports = "정보 없음";

    @Column(name = "EXP_AGE_RANGE_LEPORTS", length = 255, nullable = false)
    private String expAgeRangeLeports = "정보 없음";

    @Column(name = "INFO_CENTER_LEPORTS", length = 255, nullable = false)
    private String infoCenterLeports = "정보 없음";

    @Column(name = "OPEN_PERIOD", length = 255, nullable = false)
    private String openPeriod = "정보 없음";

    @Column(name = "PARKING_FEE_LEPORTS", length = 255, nullable = false)
    private String parkingFeeLeports = "정보 없음";

    @Column(name = "PARKING_LEPORTS", length = 255, nullable = false)
    private String parkingLeports = "정보 없음";

    @Column(name = "RESERVATION", length = 255, nullable = false)
    private String reservation = "정보 없음";

    @Column(name = "REST_DATE_LEPORTS", length = 255, nullable = false)
    private String restDateLeports = "정보 없음";

    @Column(name = "SCALE_LEPORTS", length = 255, nullable = false)
    private String scaleLeports = "정보 없음";

    @Column(name = "USE_FEE_LEPORTS", length = 255, nullable = false)
    private String useFeeLeports = "정보 없음";

    @Column(name = "USE_TIME_LEPORTS", length = 255, nullable = false)
    private String useTimeLeports = "정보 없음";

    @Column(name = "ADDRESS", length = 100)
    private String address;

    @Column(name = "IMAGE", length = 100)
    private String image;

    @Column(name = "PLACE", length = 100)
    private String place;

    @Column(name = "CONTENT_TYPE_ID", length = 20)
    private String contentTypeId;

    @Column(name = "CONTENT_ID", length = 20)
    private String contentId;

    @Column(name = "CREATE_ID", length = 100)
    private String createId;

    @Column(name = "CREATE_DT", nullable = false, updatable = false)
    private LocalDateTime createDt;
}
