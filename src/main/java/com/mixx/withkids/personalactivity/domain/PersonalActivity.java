package com.mixx.withkids.personalactivity.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class PersonalActivity {
    @Id
    @GeneratedValue
    private Long id;
    private Long userId;
    private Long activityId;
    private String reserveDt;   // 예약일자
    private boolean isCanceled; // 취소 여부
    //private ReservedStatus reservedStatus;  //예약진행상태 (예약중, 예약완료, 결재완료, 결재취소 등)
    private Date createDt;
    private Date updateDt;
}
