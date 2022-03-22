package blog.panditmandar.code.timecalc.data;

import java.util.LinkedHashSet;
import java.util.Set;

import blog.panditmandar.code.timecalc.constant.SingleTime;
import blog.panditmandar.code.timecalc.constant.TimeValueSeperator;
import blog.panditmandar.code.timecalc.process.TimeCalculationProcessor;

public abstract class TimeDataRetriever implements DataRetriever {

	private String sourceData;
	protected SourceReader dataReader;
	private TimeValueSeperator timeValueSeperator;

	private TimeCalculationProcessor calcProcessor;

	private Set<SingleTime> timeSet;

	protected TimeDataRetriever(String sourceData, SourceReader dataReader, TimeValueSeperator timeValueSeperator) {
//		System.out.println("TimeDataRetriever");
		this.sourceData = sourceData;
//		System.out.println("this.sourceData " + this.sourceData);
		this.dataReader = dataReader;
		this.timeValueSeperator = timeValueSeperator;
		this.timeSet = new LinkedHashSet<>();
	}

	protected SourceReader getDataReader() {
		return dataReader;
	}

	protected Set<SingleTime> getTimeSet() {
		return timeSet;
	}

	public String getSourceData() {
		return sourceData;
	}

	public TimeValueSeperator getTimeValueSeperator() {
		return timeValueSeperator;
	}

	public TimeCalculationProcessor getCalcProcessor() {
		return calcProcessor;
	}

	public void setCalcProcessor(TimeCalculationProcessor calcProcessor) {
		this.calcProcessor = calcProcessor;
	}
}
