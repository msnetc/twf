package com.taimeitech.platform;

import com.taimeitech.framework.cache.RedisDao;
import com.taimeitech.framework.common.TaimeiLogger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaimeiBootApplicationTests {

	@Autowired
	RedisDao redisDao;

	@Test
	public void TestRedis() throws Exception {
		redisDao.setObject("Tiantian","GoodMorning");
		System.out.println(redisDao.getObject("Tiantian"));
	}

	@Test
	public void TestLogger() throws Exception {
		try {
			int a=1/0;
		} catch (Exception ex) {
			TaimeiLogger.error(ex);
		}
		TaimeiLogger.info("World");
	}

}
