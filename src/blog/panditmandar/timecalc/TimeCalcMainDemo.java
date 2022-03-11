package blog.panditmandar.timecalc;

public class TimeCalcMainDemo {

	public static void main(String[] args) {

//		TimeCalculationProcessor tcp = new TimeCalculationProcessor();

//		TimeCalculationByTotalSeconds tcp = new TimeCalculationByTotalSeconds();

		TimeCalculationByTimeDivide tcp = new TimeCalculationByTimeDivide();

		// tcp.processTimeSources("41m 56s", "1h 27m 59s", "1h 19m 43s");

//		tcp.processTimeSources("85m 72s", "1h 59m 59s");

//		tcp.processTimeSources("41m 56s", "1h 27m 59s", "1h 19m 43s", "1h 47m", "2h 13m 26s");

//		tcp.processTimeSources("40m 30s", "1d 2h 20m 30s", "1h 30m");

		tcp.processTimeSources("54m 41s", "54m 11s", "41m 35s", "41m 46s", "54m 49s", "47m 10s", "35m 8s", "53m 44s",
				"25m 35s", "41m 40s", "29m 20s", "31m 47s", "20m 40s", "21m 2s", "51m 42s", "53m 56s");

		SingleTime totalTime = tcp.getTotalTime();
		System.out.println("-----------------");
		System.out.println(totalTime);
		System.out.println("-----------------");
		System.out.println(totalTime.toSimpleString());

	}

}
