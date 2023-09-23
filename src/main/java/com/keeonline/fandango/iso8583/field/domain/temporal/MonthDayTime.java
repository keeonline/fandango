package com.keeonline.fandango.iso8583.field.domain.temporal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;

public class MonthDayTime {
	
	private MonthDay monthDay;
	private LocalTime localTime;
	
	public MonthDayTime(int month, int day, int hour, int minute, int second){
		this.monthDay = MonthDay.of(month,day);
		this.localTime = LocalTime.of(hour, minute, second);
	}
	
	public static MonthDayTime now() {
		LocalDateTime ldt = LocalDateTime.now();
		return MonthDayTime.of(ldt.getMonthValue(),ldt.getDayOfMonth(),ldt.getHour(),ldt.getMinute(),ldt.getSecond());
	}

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("monthDay=" + monthDay.toString() + ", localTime=" + localTime.toString());
		return sb.toString();
	}

	/**
	 * Obtains an instance of MonthDayTime.
	 * @param month number of month
	 * @param day number of day
	 * @param hour number of hour
	 * @param minute number of minute
	 * @param second number of second
	 * @return MonthDayTime object with the value of input arguments
	 */
	public static MonthDayTime of(int month, int day, int hour, int minute, int second){
		return new MonthDayTime(month,day,hour,minute,second);
	}

	/**
	 * Obtains an instance of MonthDayTime from a text string using a specific formatter.
	 * @param value the month-day-time string formatted according to the formatter pattern
	 * @param formatter the formatter pattern matching the month-day-time string
	 * @return MonthDayTime object with the value of parsed value string
	 */
	public static LocalDateTime parse(String value,String pattern){
		String patternWithYear = "yyyy"+pattern;
		// TODO: handle year rollover
		String year = Integer.valueOf(LocalDate.now().getYear()).toString();
		LocalDateTime dateTime = 
			LocalDateTime.parse(year+value,DateTimeFormatter.ofPattern(patternWithYear));
		return dateTime;
	}

	/**
	 * Formats this month-day-time using the specified formatter.
	 * @param formatter DateTimeFormatter specifying the output format of the resultant string
	 * @return formatted string of this object value
	 */
	public String format(DateTimeFormatter formatter){
		LocalDateTime localDateTime = 
				LocalDateTime.of(LocalDate.now().getYear(),monthDay.getMonth(),monthDay.getDayOfMonth(),
						localTime.getHour(),localTime.getMinute(),localTime.getSecond());
		return localDateTime.format(formatter);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((monthDay == null) ? 0 : monthDay.hashCode());
		result = prime * result + ((localTime == null) ? 0 : localTime.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof MonthDayTime))
			return false;
		MonthDayTime other = (MonthDayTime) obj;
		if (monthDay == null) {
			if (other.monthDay != null)
				return false;
		} else if (!monthDay.equals(other.monthDay))
			return false;
		if (localTime == null) {
			if (other.localTime != null)
				return false;
		} else if (!localTime.equals(other.localTime))
			return false;
		return true;
	}

}
