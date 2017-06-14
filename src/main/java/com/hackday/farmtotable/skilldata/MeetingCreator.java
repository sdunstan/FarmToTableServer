package com.hackday.farmtotable.skilldata;

public class MeetingCreator implements SkillDataCreator {

	@Override
	public SkillData create(String data) {
		return new MeetingData();
	}

}
