package com.hackday.farmtotable.skilldata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SportsCreator implements SkillDataCreator {

	private static final Logger LOGGER = LoggerFactory.getLogger(SportsCreator.class);
	
	@Override
	public SkillData create(String data) {
		SportsData sportsData = new SportsData();
		sportsData.setData(data);
		LOGGER.info(data);
		return sportsData;
	}

}
