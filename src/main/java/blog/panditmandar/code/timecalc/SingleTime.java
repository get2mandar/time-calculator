package blog.panditmandar.code.timecalc;

public class SingleTime {

	private int day;
	private int hour;
	private int minute;
	private int second;

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	@Override
	public String toString() {
		return "SingleTime [" + toSimpleString() + "]";
	}

	public String toSimpleString() {
		StringBuilder sb = new StringBuilder();
		if (day > 0) {
			sb.append(day).append("d ");
		}
		if (hour > 0) {
			sb.append(hour).append("h ");
		}
		if (minute > 0) {
			sb.append(minute).append("m ");
		}
		if (second > 0) {
			sb.append(second).append("s");
		}
		return sb.toString();
	}
}
