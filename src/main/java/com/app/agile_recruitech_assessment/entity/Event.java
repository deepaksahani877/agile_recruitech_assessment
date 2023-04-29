package com.app.agile_recruitech_assessment.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;


@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private int uId;

    @Column(name = "even_name", nullable = false)
    private String eventName;

    @Column(name = "tag_line", nullable = false)
    private String tagLine;

    @Column(name = "scheduled_date", nullable = false)
    private LocalDate scheduleDate;

    @Column(name = "scheduled_start_time", nullable = false, columnDefinition = "TIME")
    @Temporal(TemporalType.TIME)
    private Date scheduleStartTime;

    @Column(name = "scheduled_end_time", nullable = false, columnDefinition = "TIME")
    @Temporal(TemporalType.TIME)
    private Date scheduleEndTime;

    @Column(nullable = false)
    private String description;

    @Lob
    @Column(name = "image_file", nullable = false, length = Integer.MAX_VALUE)
    private byte[] imageFile;

    @Column(nullable = false)
    private String moderator;

    @Column(name = "event_category", nullable = false)
    private String eventCategory;

    @Column(name = "event_subcategory", nullable = false)
    private String eventSubCategory;

    @Column(name = "rigor_rank", nullable = false)
    private int rigorRank;

}
