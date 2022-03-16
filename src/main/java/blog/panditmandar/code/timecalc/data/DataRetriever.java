package blog.panditmandar.code.timecalc.data;

import java.util.Set;

import blog.panditmandar.code.timecalc.constant.SingleTime;
import blog.panditmandar.code.timecalc.process.TimeCalculationProcessor;

public interface DataRetriever {

	Set<SingleTime> retrieveTimeData(TimeCalculationProcessor calcProcessor);

}
