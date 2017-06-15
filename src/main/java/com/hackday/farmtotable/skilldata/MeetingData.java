package com.hackday.farmtotable.skilldata;

public class MeetingData extends SkillData {

	private String start;
	private String end;

	public MeetingData(Object data) {
		super(data);
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return "MeetingData [start=" + start + ", end=" + end + ", getData()=" + getData() + "]";
	}

}
