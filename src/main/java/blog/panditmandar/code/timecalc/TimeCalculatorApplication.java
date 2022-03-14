package blog.panditmandar.code.timecalc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TimeCalculatorApplication implements CommandLineRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(TimeCalculatorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		TimeCalculationProcessor tcp = new TimeCalculationProcessor();

//		TimeCalculationByTotalSeconds tcp = new TimeCalculationByTotalSeconds();

		TimeCalculationByTimeDivide tcp = new TimeCalculationByTimeDivide();

//		tcp.processTimeSources("41m 56s", "1h 27m 59s", "1h 19m 43s");

//		tcp.processTimeSources("85m 72s", "1h 59m 59s");

//		tcp.processTimeSources("41m 56s", "1h 27m 59s", "1h 19m 43s", "1h 47m", "2h 13m 26s");

//		tcp.processTimeSources("40m 30s", "1d 2h 20m 30s", "1h 30m");

		tcp.processTimeSources("10h 56m 16s","7h 53m 50s","11h 3m 15s","10h 23m 42s");

		SingleTime totalTime = tcp.getTotalTime();
		System.out.println("-----------------");
		System.out.println(totalTime);
		System.out.println("-----------------");
		System.out.println(totalTime.toSimpleString());
		
	}
	
	

}
