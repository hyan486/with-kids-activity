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

	static ApplicationContext applicationContext;
	public static ApplicationContext getApplicationContext(){
		return applicationContext;
	}

	public static void main(String[] args) {
		applicationContext = SpringApplication.run(ActivityApplication.class, args);
		Activity activity = new Activity();
		insertActivity(activity);
		insertPersonalActivity(activity);
	}
	
	public static void insertActivity(Activity activity) {
		ActivityRepository activityRepository = applicationContext.getBean(ActivityRepository.class);
		
		activity.setTitle("재밌는 공연1");
		activity.setDesc("very educational performance...");
		activity.setLocation(Location.seoul);
		activity.setCreateDt(new Date());
		activity.setUpdateDt(new Date());
		activityRepository.save(activity);
		
		System.out.println(activity.checkLoction());
		
		activityRepository.findAll().forEach(item -> {
			System.out.println(item);
		});
		
	} 

	public static void insertPersonalActivity(Activity activity) {
		PersonalActivityRepository personalActivityRepository = applicationContext.getBean(PersonalActivityRepository.class);
		
		PersonalActivity personalActivity = new PersonalActivity();
		personalActivity.setCanceled(false);
		personalActivity.setActivityId(activity.getId());
		personalActivity.setReserveDt("20220222");
		personalActivity.setUpdateDt(new Date());
		personalActivity.setCreateDt(new Date());
		personalActivityRepository.save(personalActivity);
		
		personalActivityRepository.findAll().forEach(item -> {
			System.out.println(item);
		});
	} 
}
