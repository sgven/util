package demo.java.util;

import demo.java.util.utils.TimeUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UtilApplicationTests {

	@Test
	void contextLoads() {
		testMill();
	}

	private void testMill() {
		double naco = TimeUtil.toNanos(1, TimeUtil.MILLISECOND);
		double micro = TimeUtil.toMicros(1, TimeUtil.MILLISECOND, 3);
		double seconde = TimeUtil.toSeconds(959, TimeUtil.MILLISECOND, 3);
		double minute = TimeUtil.toMinutes(3600000, TimeUtil.MILLISECOND, 2);
		double hour = TimeUtil.toHours(7200000, TimeUtil.MILLISECOND, 2);
		double day = TimeUtil.toDays(7200000, TimeUtil.MILLISECOND, 2);
		System.out.println("naco:"+naco);
		System.out.println("micro:"+micro);
		System.out.println("second:"+seconde);
		System.out.println("min:"+minute);
		System.out.println("hour:"+hour);
		System.out.println("day:"+day);
	}

}
