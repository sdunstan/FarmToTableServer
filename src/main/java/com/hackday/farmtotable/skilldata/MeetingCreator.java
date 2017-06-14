package com.hackday.farmtotable.skilldata;

public class MeetingCreator implements SkillDataCreator {

	@Override
	public SkillData create(String data) {
		MeetingData meetingData = new MeetingData();
		meetingData.setData("It worked! Woo!");
		return meetingData;
	}

}
