package com.example.board.DTO.Travel;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "travel_lodging")
public class Lodging {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRAVEL_SEQ")
    private Integer travelSeq;

    @Column(name = "USER_SEQ")
    private Integer userSeq;

    @Column(name = "ACCOM_COUNT_LODGING", length = 255, nullable = false)
    private String accomCountLodging = "정보 없음";

    @Column(name = "BENIKIA", length = 255, nullable = false)
    private String benikia = "정보 없음";

    @Column(name = "CHECK_IN_TIME", length = 255, nullable = false)
    private String checkInTime = "정보 없음";

    @Column(name = "CHECK_OUT_TIME", length = 255, nullable = false)
    private String checkOutTime = "정보 없음";

    @Column(name = "CHK_COOKING", length = 255, nullable = false)
    private String chkCooking = "정보 없음";

    @Column(name = "INFO_CENTER_LODGING", length = 255, nullable = false)
    private String infoCenterLodging = "정보 없음";

    @Column(name = "PARKING_LODGING", length = 255, nullable = false)
    private String parkingLodging = "정보 없음";

    @Column(name = "ROOM_COUNT", length = 20, nullable = false)
    private String roomCount;

    @Column(name = "RESERVATION_LODGING", length = 255, nullable = false)
    private String reservationLodging = "정보 없음";

    @Column(name = "SCALE_LODGING", length = 255, nullable = false)
    private String scaleLodging = "정보 없음";

    @Column(name = "REFUND_REGULATION", length = 255, nullable = false)
    private String refundRegulation = "정보 없음";

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
