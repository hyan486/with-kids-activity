package com.mixx.withkids;

import java.util.Date;

import com.mixx.withkids.activity.domain.Activity;
import com.mixx.withkids.activity.domain.ActivityRepository;
import com.mixx.withkids.activity.domain.Location;
import com.mixx.withkids.personalactivity.domain.PersonalActivity;
import com.mixx.withkids.personalactivity.domain.PersonalActivityRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ActivityApplication {
	static int idx = 1;
	static ApplicationContext applicationContext;
	public static ApplicationContext getApplicationContext(){
		return applicationContext;
	}

	public static void main(String[] args) {
		applicationContext = SpringApplication.run(ActivityApplication.class, args);
		
		Long activityId = insertActivity();
		insertPersonalActivity(activityId);
		idx++;
		insertPersonalActivity(activityId);

		activityId = insertActivity();
		insertPersonalActivity(activityId);
		idx++;
		insertPersonalActivity(activityId);
	}
	
	public static Long insertActivity() {
		ActivityRepository activityRepository = applicationContext.getBean(ActivityRepository.class);
		Activity activity = new Activity();
		activity.setTitle("fun dance.." + Integer.toString(idx));
		activity.setDescription("very educational performance...");
		activity.setLocation(Location.seoul);
		activity.setCreateDt(new Date());
		activity.setUpdateDt(new Date());
		activityRepository.save(activity);
		
		System.out.println(activity.checkLoction());
		
		activityRepository.findAll().forEach(item -> {
			System.out.println(item);
		});

		return activity.getId();
		
	} 

	public static void insertPersonalActivity(Long activityId) {
		PersonalActivityRepository personalActivityRepository = applicationContext.getBean(PersonalActivityRepository.class);
		System.out.println("activityId "+activityId);
		PersonalActivity personalActivity = new PersonalActivity();
		personalActivity.setCanceled(false);
		personalActivity.setActivityId(activityId);
		
		personalActivity.setReserveDt("2022022"+Integer.toString(idx));
		personalActivity.setUpdateDt(new Date());
		personalActivity.setCreateDt(new Date());
		personalActivityRepository.save(personalActivity);
		
		personalActivityRepository.findAll().forEach(item -> {
			System.out.println(item);
		});
	} 
}
