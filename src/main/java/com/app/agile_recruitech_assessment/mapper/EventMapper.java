package com.app.agile_recruitech_assessment.mapper;


import com.app.agile_recruitech_assessment.dto.EventDto;
import com.app.agile_recruitech_assessment.entity.Event;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

public class EventMapper {

    public static EventDto mapToEventDto(Event event) {
        return EventDto.builder()
                .id(event.getId())
                .type(event.getType())
                .uId(event.getUId())
                .eventName(event.getEventName())
                .tagLine(event.getTagLine())
                .scheduleDate(event.getScheduleDate())
                .scheduleStartTime(getParsedTime(event.getScheduleStartTime()))
                .scheduleEndTime(getParsedTime(event.getScheduleEndTime()))
                .description(event.getDescription())
                .imageBase64(Base64.getEncoder().encodeToString(event.getImageFile()))
                .moderator(event.getModerator())
                .eventCategory(event.getEventCategory())
                .eventSubCategory(event.getEventSubCategory())
                .rigorRank(event.getRigorRank())
                .build();
    }

    public static Event mapToEvent(EventDto eventDto) {
        return Event.builder()
                .id(eventDto.getId())
                .type(eventDto.getType())
                .uId(eventDto.getUId())
                .eventName(eventDto.getEventName())
                .tagLine(eventDto.getTagLine())
                .scheduleDate(eventDto.getScheduleDate())
                .scheduleStartTime(Time.valueOf(eventDto.getScheduleStartTime()))
                .scheduleEndTime(Time.valueOf(eventDto.getScheduleEndTime()))
                .description(eventDto.getDescription())
                .imageFile(Base64.getDecoder().decode(eventDto.getImageBase64()))
                .moderator(eventDto.getModerator())
                .eventCategory(eventDto.getEventCategory())
                .eventSubCategory(eventDto.getEventSubCategory())
                .rigorRank(eventDto.getRigorRank())
                .build();
    }


    private static String getParsedTime(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        return formatter.format(date);
    }

}
