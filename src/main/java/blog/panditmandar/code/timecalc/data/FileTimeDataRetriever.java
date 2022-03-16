package blog.panditmandar.code.timecalc.data;

import java.util.Set;

import blog.panditmandar.code.timecalc.constant.SingleTime;
import blog.panditmandar.code.timecalc.constant.TimeValueSeperator;
import blog.panditmandar.code.timecalc.process.TimeCalculationProcessor;

public class FileTimeDataRetriever extends TimeDataRetriever {

	protected FileTimeDataRetriever(String sourceData, DataReader dataReader, TimeValueSeperator timeValueSeperator) {
		super(sourceData, dataReader, timeValueSeperator);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Set<SingleTime> retrieveTimeData(TimeCalculationProcessor calcProcessor) {
		// TODO Auto-generated method stub
		return null;
	}

}
