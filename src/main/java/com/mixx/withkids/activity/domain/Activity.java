package com.mixx.withkids.activity.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
// @Table(
//         name="Activity", 
//         uniqueConstraints=
//             @UniqueConstraint(columnNames={"ACTIVITY_ID"})
//     )
public class Activity {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String desc;
    private Location location;
    private String category;    // 카테코리
    private Date createDt;
    private Date updateDt;

    public boolean checkLoction() {
        if (location == Location.seoul) {
            return true;
        } else return false;
    }
}
