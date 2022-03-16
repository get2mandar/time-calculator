package blog.panditmandar.code.timecalc.process;

import blog.panditmandar.code.timecalc.constant.SingleTime;
import blog.panditmandar.code.timecalc.data.TimeDataRetriever;

public class TimeCalculationByTotalSeconds extends TimeCalculationProcessor {

	public TimeCalculationByTotalSeconds(TimeDataRetriever timeDataRetriever) {
		super(timeDataRetriever);
	}

	@Override
	protected SingleTime buildSingleTime(SingleTime sTime, String[] timeSplits, int index) {
		if (index < timeSplits.length) {
			String timeStr = timeSplits[index].toLowerCase();
			if (timeStr.endsWith("s")) {
				String[] splitSec = timeStr.split("s");
				sTime.setSecond(sTime.getSecond() + Integer.parseInt(splitSec[0]));
			}
			if (timeStr.endsWith("m")) {
				String[] splitMin = timeStr.split("m");
				sTime.setSecond(sTime.getSecond() + (Integer.parseInt(splitMin[0]) * 60));
			}
			if (timeStr.endsWith("h")) {
				String[] splitHr = timeStr.split("h");
				sTime.setSecond(sTime.getSecond() + (Integer.parseInt(splitHr[0]) * 60 * 60));
			}
			if (timeStr.endsWith("d")) {
				String[] splitDay = timeStr.split("d");
				sTime.setSecond(sTime.getSecond() + (Integer.parseInt(splitDay[0]) * 24 * 60 * 60));
			}
			buildSingleTime(sTime, timeSplits, ++index);
		}
		return sTime;
	}
}
