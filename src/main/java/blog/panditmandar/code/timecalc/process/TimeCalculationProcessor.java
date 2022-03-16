package blog.panditmandar.code.timecalc.process;

import java.util.LinkedHashSet;
import java.util.Set;

import blog.panditmandar.code.timecalc.constant.SingleTime;
import blog.panditmandar.code.timecalc.data.TimeDataRetriever;

public abstract class TimeCalculationProcessor {

	private TimeDataRetriever timeDataRetriever;

	private Set<SingleTime> timeSet;

	public TimeCalculationProcessor(TimeDataRetriever timeDataRetriever) {
		this.timeDataRetriever = timeDataRetriever;
		this.timeSet = new LinkedHashSet<>();
		this.processTimeDataSource();
	}

	public void processTimeDataSource() {
		if (timeDataRetriever.getTimeValueFormat().toString().equals("CSV")) {
			String[] strings = timeDataRetriever.getSourceData().split(",");
			processTimeDataSource(strings);
		}
	}

	private void processTimeDataSource(String... timeSources) {

		if (timeSources != null && timeSources.length > 0) {
			for (String singleTime : timeSources) {
				SingleTime parsedSingleTime = parseSingleTime(singleTime);
//				parsedSingleTime.setSource(singleTime);
				if (parsedSingleTime != null) {
					timeSet.add(parsedSingleTime);
				}
			}
			System.out.println("timeList: " + timeSet);
		} else {
			System.out.println("timeSources is NULL or Empty");
		}
	}

	private SingleTime parseSingleTime(String singleTime) {
		if (singleTime != null && singleTime.length() > 0) {

			String[] timeSplits = singleTime.split(timeDataRetriever.getTimeValueSeperator().getSeperator());

			SingleTime sTime = new SingleTime();

			return buildSingleTime(sTime, timeSplits, 0);

		} else {
			System.out.println("singleTime " + singleTime + " is NULL or Empty");
		}
		return null;
	}

	protected abstract SingleTime buildSingleTime(SingleTime sTime, String[] timeSplits, int index);

	/**
	 * To Get Total Result Time
	 * 
	 * @return
	 */
	public SingleTime getTotalTime() {
		SingleTime resultTime = new SingleTime();
		for (SingleTime sTime : timeSet) {
			resultTime.setSecond(resultTime.getSecond() + sTime.getSecond());
			resultTime.setMinute(resultTime.getMinute() + sTime.getMinute());
			resultTime.setHour(resultTime.getHour() + sTime.getHour());
			resultTime.setDay(resultTime.getDay() + sTime.getDay());
		}

		if (resultTime.getSecond() >= 60) {
			int secValue = resultTime.getSecond();
			int actualSec = secValue % 60;
			resultTime.setSecond(actualSec);
			int secToMin = (secValue - 60) / 60;
			resultTime.setMinute(resultTime.getMinute() + (secToMin + 1));
		}

		if (resultTime.getMinute() >= 60) {
			int minValue = resultTime.getMinute();
			int actualMin = minValue % 60;
			resultTime.setMinute(actualMin);
			int minToHr = (minValue - 60) / 60;
			resultTime.setHour(resultTime.getHour() + (minToHr + 1));
		}

		if (resultTime.getHour() >= 24) {
			int hrValue = resultTime.getHour();
			int actualHr = hrValue % 24;
			resultTime.setHour(actualHr);
			int hrToDay = (hrValue - 24) / 24;
			resultTime.setDay(resultTime.getDay() + (hrToDay + 1));
		}

		return resultTime;
	}
}
