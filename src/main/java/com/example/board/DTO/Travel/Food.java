package com.example.board.DTO.Travel;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "travel_food")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRAVEL_SEQ")
    private Integer travelSeq;

    @Column(name = "USER_SEQ")
    private Integer userSeq;

    @Column(name = "INFO_CENTER_FOOD", length = 255, nullable = false)
    private String infoCenterFood = "정보 없음";

    @Column(name = "FIRST_MENU", length = 255, nullable = false)
    private String firstMenu = "정보 없음";

    @Column(name = "OPEN_TIME_FOOD", length = 255, nullable = false)
    private String openTimeFood = "정보 없음";

    @Column(name = "PACKING", length = 255, nullable = false)
    private String packing = "정보 없음";

    @Column(name = "PARKING_FOOD", length = 255, nullable = false)
    private String parkingFood = "정보 없음";

    @Column(name = "TREAT_MENU", length = 255, nullable = false)
    private String treatMenu = "정보 없음";

    @Column(name = "SEAT", length = 20)
    private String seat;

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
