package com.app.agile_recruitech_assessment.dto;


import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class EventDto {

    private Long id;

    private String type;

    private int uId;

    private String eventName;

    private String tagLine;

    private LocalDate scheduleDate;

    private String scheduleStartTime;

    private String scheduleEndTime;

    private String description;

    private String imageBase64;

    private String moderator;

    private String eventCategory;

    private String eventSubCategory;

    private int rigorRank;

}
