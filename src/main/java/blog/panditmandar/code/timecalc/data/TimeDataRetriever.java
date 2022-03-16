package blog.panditmandar.code.timecalc.data;

import java.util.LinkedHashSet;
import java.util.Set;

import blog.panditmandar.code.timecalc.constant.SingleTime;
import blog.panditmandar.code.timecalc.constant.TimeValueSeperator;

public abstract class TimeDataRetriever implements DataRetriever {

	private String sourceData;
	protected DataReader dataReader;
	private TimeValueSeperator timeValueSeperator;

	private Set<SingleTime> timeSet;

	protected TimeDataRetriever(String sourceData, DataReader dataReader, TimeValueSeperator timeValueSeperator) {
		this.sourceData = sourceData;
		this.dataReader = dataReader;
		this.timeValueSeperator = timeValueSeperator;
		this.timeSet = new LinkedHashSet<>();
	}

	protected DataReader getDataReader() {
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
}
