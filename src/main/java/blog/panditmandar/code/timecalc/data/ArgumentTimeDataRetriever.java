package blog.panditmandar.code.timecalc.data;

import java.util.Set;

import blog.panditmandar.code.timecalc.constant.SingleTime;
import blog.panditmandar.code.timecalc.constant.TimeValueSeperator;

public class ArgumentTimeDataRetriever extends TimeDataRetriever {

	public ArgumentTimeDataRetriever(String sourceData, SourceReader dataReader,
			TimeValueSeperator timeValueSeperator) {
		super(sourceData, dataReader, timeValueSeperator);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Set<SingleTime> retrieveTimeData() {
		// TODO Auto-generated method stub
		this.getCalcProcessor();
		String[] strings = dataReader.readSourceData(getSourceData());

		if (strings != null && strings.length > 0) {
			for (String singleTime : strings) {
				SingleTime parsedSingleTime = getCalcProcessor().parseSingleTime(singleTime);
				if (parsedSingleTime != null) {
					getTimeSet().add(parsedSingleTime);
				}
			}
			System.out.println("timeList: " + getTimeSet());
		} else {
			System.out.println("SourceData is NULL or Empty");
		}

		return getTimeSet();
	}

}
