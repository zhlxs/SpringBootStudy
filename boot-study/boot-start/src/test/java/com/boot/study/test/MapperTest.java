package com.boot.study.test;

import com.boot.study.dao.TBootUserMapper;
import com.boot.study.entity.TBootUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MapperTest {

    @Autowired
    private TBootUserMapper userMapper;

    @Test
    public void testUserMapper() {
        List<TBootUser> users = userMapper.selectList(null);
        System.out.println(users.size());
    }
}
