package com.example.board.DTO.Travel;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "travel_general_travel")
public class GeneralTravel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRAVEL_SEQ")
    private Integer travelSeq; // Primary Key

    @Column(name = "USER_SEQ")
    private Integer userSeq; //

    @Column(name = "ACCOM_COUNT", length = 255)
    private String accomCount; // 수용인원

    @Column(name = "CHK_BABY_CARRIAGE", length = 255)
    private String chkBabyCarriage; // 유모차 대여 여부

    @Column(name = "CHK_CREDIT_CARD", length = 255)
    private String chkCreditCard; // 신용카드 사용 가능 여부

    @Column(name = "CHK_PET", length = 255)
    private String chkPet; // 애완동물 동반 가능 여부

    @Column(name = "EXP_AGE_RANGE", length = 255)
    private String expAgeRange; // 체험 가능 연령

    @Column(name = "INFO_CENTER", length = 255)
    private String infoCenter; // 문의 및 안내

    @Column(name = "OPEN_DATE", length = 255)
    private String openDate; // 개장일

    @Column(name = "REST_DATE", length = 255)
    private String restDate; // 쉬는 날

    @Column(name = "USE_SEASON", length = 255)
    private String useSeason; // 이용 시기

    @Column(name = "USE_TIME", length = 255)
    private String useTime; // 이용 시간

    @Column(name = "ADDRESS", length = 255)
    private String address; //주소

    @Column(name = "PLACE", length = 255)
    private String place;   //장소

    @Column(name = "IMAGE", length = 255)
    private String image;   //이미지

    @Column(name = "CONTENT_ID", length = 255)
    private String contentId; // contentId

    @Column(name = "CONTENT_TYPE_ID", length = 255)
    private String contentTypeId; // contentTypeId

    @Column(name = "CREATE_ID", length = 100)
    private String createId; // 데이터 생성자 ID

    @Column(name = "CREATE_DT")
    private LocalDateTime createDt; // 데이터 생성 시간
}
