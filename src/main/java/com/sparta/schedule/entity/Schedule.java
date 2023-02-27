package com.sparta.schedule.entity;

import com.sparta.schedule.dto.request.CompleteRequestDto;
import com.sparta.schedule.dto.response.ScheduleRequestDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String date;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    private String contents;

    private boolean complete;

    @ManyToOne
    @JoinColumn(name = "User_Id", nullable = false)
    private User user;

    @Builder
    public Schedule(ScheduleRequestDto scheduleRequestDto, User user) {
        date = scheduleRequestDto.getDate();
        title = scheduleRequestDto.getTitle();
        author = scheduleRequestDto.getAuthor();
        contents = scheduleRequestDto.getContents();
        this.user = user;
    }

    public void update(ScheduleRequestDto scheduleRequestDto, User user) {
        date = scheduleRequestDto.getDate();
        title = scheduleRequestDto.getTitle();
        contents = scheduleRequestDto.getContents();
        this.user = user;
    }

    public void updateCompleteStatus(CompleteRequestDto requestDto) {
        this.complete = requestDto.isComplete();
    }

}
