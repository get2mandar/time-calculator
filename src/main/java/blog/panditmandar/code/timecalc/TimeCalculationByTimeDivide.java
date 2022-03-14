package blog.panditmandar.code.timecalc;

public class TimeCalculationByTimeDivide extends TimeCalculationProcessor {

	@Override
	protected SingleTime buildSingleTime(SingleTime sTime, String[] timeSplits, int index) {
		if (index < timeSplits.length) {
			String timeStr = timeSplits[index].toLowerCase();
			if (timeStr.endsWith("s")) {
				String[] splitSec = timeStr.split("s");
				sTime.setSecond(Integer.parseInt(splitSec[0]));
			}
			if (timeStr.endsWith("m")) {
				String[] splitMin = timeStr.split("m");
				sTime.setMinute(Integer.parseInt(splitMin[0]));
			}
			if (timeStr.endsWith("h")) {
				String[] splitHr = timeStr.split("h");
				sTime.setHour(Integer.parseInt(splitHr[0]));
			}
			if (timeStr.endsWith("d")) {
				String[] splitDay = timeStr.split("d");
				sTime.setDay(Integer.parseInt(splitDay[0]));
			}
			buildSingleTime(sTime, timeSplits, ++index);
		}
		return sTime;
	}
}
