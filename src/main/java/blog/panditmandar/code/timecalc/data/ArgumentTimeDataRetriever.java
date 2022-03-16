package blog.panditmandar.code.timecalc.data;

import java.util.Set;

import blog.panditmandar.code.timecalc.constant.SingleTime;
import blog.panditmandar.code.timecalc.constant.TimeValueSeperator;
import blog.panditmandar.code.timecalc.process.TimeCalculationProcessor;

public class ArgumentTimeDataRetriever extends TimeDataRetriever {

	public ArgumentTimeDataRetriever(String sourceData, DataReader dataReader, TimeValueSeperator timeValueSeperator) {
		super(sourceData, dataReader, timeValueSeperator);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Set<SingleTime> retrieveTimeData(TimeCalculationProcessor calcProcessor) {
		// TODO Auto-generated method stub
		String[] strings = dataReader.readSourceData(getSourceData());

		if (strings != null && strings.length > 0) {
			for (String singleTime : strings) {
				SingleTime parsedSingleTime = calcProcessor.parseSingleTime(singleTime);
				if (parsedSingleTime != null) {
					getTimeSet().add(parsedSingleTime);
				}
			}
			System.out.println("timeList: " + getTimeSet());
		} else {
			System.out.println("timeSources is NULL or Empty");
		}

		return getTimeSet();
	}

}
