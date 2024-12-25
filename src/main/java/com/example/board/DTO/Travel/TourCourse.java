package com.example.board.DTO.Travel;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "travel_tour_course")
public class TourCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRAVEL_SEQ")
    private Integer travelSeq;

    @Column(name = "USER_SEQ")
    private Integer userSeq;

    @Column(name = "DISTANCE", length = 255, nullable = false)
    private String distance = "정보 없음";

    @Column(name = "INFO_CENTER_TOUR_COURSE", length = 255, nullable = false)
    private String infoCenterTourCourse = "정보 없음";

    @Column(name = "SCHEDULE", length = 255, nullable = false)
    private String schedule = "정보 없음";

    @Column(name = "TAKE_TIME", length = 255, nullable = false)
    private String takeTime = "정보 없음";

    @Column(name = "THEME", length = 255, nullable = false)
    private String theme = "정보 없음";

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
