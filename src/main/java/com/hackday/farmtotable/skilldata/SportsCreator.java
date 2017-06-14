package com.hackday.farmtotable.skilldata;

public class SportsCreator implements SkillDataCreator {

	@Override
	public SkillData create(String data) {
		SportsData sportsData = new SportsData(data);
		return sportsData;
	}

}
