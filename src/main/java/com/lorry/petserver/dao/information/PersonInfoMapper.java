package com.lorry.petserver.dao.information;

import com.alibaba.fastjson.JSONObject;
import jakarta.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class PersonInfoMapper implements InformationMapper{

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public JSONObject getName() {
        String sql = "select * from visitorInfo";
        jdbcTemplate.query(sql, (RowMapper<JSONObject>) (rs, rowNum) -> {
            System.out.println(rs.getString("name"));
            System.out.println(rowNum);
            return null;
        });
        return null;
    }
}
