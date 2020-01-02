package com.example.segment;

import com.example.SegmentIDGen;
import com.example.common.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"}) //加载配置文件
public class SpringIDGenServiceTest {
    @Autowired
    SegmentIDGen idGen;

    @Test
    public void testGetId() {
        for (int i = 0; i < 100; i++) {
            Result r = idGen.get("leaf-segment-test");
            System.out.println(r);
        }
    }
}
