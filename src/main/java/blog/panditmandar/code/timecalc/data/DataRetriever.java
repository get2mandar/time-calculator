package blog.panditmandar.code.timecalc.data;

import java.util.Set;

import blog.panditmandar.code.timecalc.constant.SingleTime;

public interface DataRetriever {

	Set<SingleTime> retrieveTimeData();

}
