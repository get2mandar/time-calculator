package blog.panditmandar.code.timecalc.constant;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class SingleTime {

	private int day;
	private int hour;
	private int minute;
	private int second;

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
