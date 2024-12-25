package com.example.board.DTO.Travel;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "travel_shopping")
public class Shopping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRAVEL_SEQ")
    private Integer travelSeq;

    @Column(name = "USER_SEQ")
    private Integer userSeq;

    @Column(name = "INFO_CENTER_SHOPPING", length = 255, nullable = false)
    private String infoCenterShopping = "정보 없음";

    @Column(name = "OPEN_DATE_SHOPPING" , length = 255, nullable = false)
    private String openDateShopping = "정보 없음";

    @Column(name = "OPEN_TIME", length = 255, nullable = false)
    private String openTime = "정보 없음";

    @Column(name = "PARKING_SHOPPING", length = 255, nullable = false)
    private String parkingShopping = "정보 없음";

    @Column(name = "SALE_ITEM", length = 255, nullable = false)
    private String saleItem = "정보 없음";

    @Column(name = "SHOP_GUIDE", length = 255, nullable = false)
    private String shopGuide = "정보 없음";

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
