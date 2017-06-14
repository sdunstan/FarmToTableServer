package com.hackday.farmtotable.skilldata;

import java.time.LocalDateTime;

public class MeetingCreator implements SkillDataCreator {

	@Override
	public SkillData create(String data) {
		MeetingData meetingData = new MeetingData(data);
		meetingData.setStart(LocalDateTime.now());
		meetingData.setEnd(LocalDateTime.now().plusHours(1));
		return meetingData;
	}

}
