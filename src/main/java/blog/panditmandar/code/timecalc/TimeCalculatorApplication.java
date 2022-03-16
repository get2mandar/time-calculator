package blog.panditmandar.code.timecalc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import blog.panditmandar.code.timecalc.constant.TimeValueFormat;
import blog.panditmandar.code.timecalc.constant.SingleTime;
import blog.panditmandar.code.timecalc.constant.TimeValueSeperator;
import blog.panditmandar.code.timecalc.data.ArgumentTimeDataRetriever;
import blog.panditmandar.code.timecalc.process.TimeCalculationByTimeDivide;

@SpringBootApplication
public class TimeCalculatorApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TimeCalculatorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		args[0] = "19h 32m 42s,16h 6m 15s,11h 35m 35s,5h 11m 48s";

		ArgumentTimeDataRetriever retriever = new ArgumentTimeDataRetriever(args[0], TimeValueFormat.CSV,
				TimeValueSeperator.SPACE);
		TimeCalculationByTimeDivide tcp = new TimeCalculationByTimeDivide(retriever);

		SingleTime totalTime = tcp.getTotalTime();
		System.out.println("-----------------");
		System.out.println(totalTime);
		System.out.println("-----------------");
		System.out.println(totalTime.toSimpleString());

	}

}
