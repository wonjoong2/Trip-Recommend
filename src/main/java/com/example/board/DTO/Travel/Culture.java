package com.example.board.DTO.Travel;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "travel_culture")
public class Culture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRAVEL_SEQ")
    private Integer travelSeq;

    @Column(name = "USER_SEQ")
    private Integer userSeq;

    @Column(name = "INFO_CENTER_CULTURE", length = 255, nullable = false)
    private String infoCenterCulture = "정보 없음";

    @Column(name = "PARKING_CULTURE", length = 255, nullable = false)
    private String parkingCulture = "정보 없음";

    @Column(name = "USE_FEE", length = 255, nullable = false)
    private String useFee = "정보 없음";

    @Column(name = "SCALE", length = 255, nullable = false)
    private String scale = "정보 없음";

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
