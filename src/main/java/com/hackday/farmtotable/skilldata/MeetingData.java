package com.hackday.farmtotable.skilldata;

import java.time.LocalDateTime;

public class MeetingData extends SkillData {

	private LocalDateTime start;
	private LocalDateTime end;
	
	public LocalDateTime getStart() {
		return start;
	}
	
	public void setStart(LocalDateTime start) {
		this.start = start;
	}
	
	public LocalDateTime getEnd() {
		return end;
	}
	
	public void setEnd(LocalDateTime end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return "MeetingData [start=" + start + ", end=" + end + "]";
	}
	
}
