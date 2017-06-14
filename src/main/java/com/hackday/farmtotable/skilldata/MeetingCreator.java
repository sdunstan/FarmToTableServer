package com.hackday.farmtotable.skilldata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MeetingCreator implements SkillDataCreator {

	private static final Logger LOGGER = LoggerFactory.getLogger(MeetingCreator.class);
	
	@Override
	public SkillData create(String data) {
		MeetingData meetingData = new MeetingData();
		meetingData.setData(data);
		LOGGER.info(data);
		return meetingData;
	}

}
