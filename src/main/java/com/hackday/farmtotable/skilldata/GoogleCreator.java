package com.hackday.farmtotable.skilldata;

public class GoogleCreator implements SkillDataCreator {

	@Override
	public SkillData create(String data) {
		GoogleData googleData = new GoogleData(data);
		googleData.setUrl(formatUrl(data));
		return googleData;
	}

	private String formatUrl(String data) {
		String formatted = data.replace(" ", "%20");
		return "http://lmgtfy.com/?q=" + formatted;
	}
}
