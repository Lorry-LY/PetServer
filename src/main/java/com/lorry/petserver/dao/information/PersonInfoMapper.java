package com.lorry.petserver.dao.information;

import com.alibaba.fastjson.JSONObject;
import com.lorry.petserver.utils.file.ImageLoader;
import jakarta.annotation.Resource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public JSONObject getUserInfo(String id) {
        String sql = String.format("select * from userInfo where id='%s'",id);
        List<JSONObject> userInfos = jdbcTemplate.query(sql, (rs, rowNum) -> {
            JSONObject userInfo = new JSONObject();
            userInfo.put("name",rs.getString("name"));
            userInfo.put("number",rs.getString("number"));
            userInfo.put("description",rs.getString("description"));
            userInfo.put("sex",rs.getString("sex"));
            userInfo.put("occupation",rs.getString("occupation"));
            userInfo.put("region",rs.getString("region"));
            userInfo.put("school",rs.getString("school"));
            userInfo.put("level",rs.getString("level"));
            return userInfo;
        });
        return userInfos.size() == 0 ? null : userInfos.get(0);
    }

    @Override
    public JSONObject getUserAvatarImage(String id) throws Exception {
        JSONObject jsonObject = new JSONObject();
        String number = id.split("_")[1];
        String imagePath = "static/user/image/avatar/"+number+".png";
        String path = new ClassPathResource(imagePath).getURL().getPath();
        byte[] imageByte = ImageLoader.getImageByte(path);
        jsonObject.put("data", imageByte);
        return jsonObject;
    }

    @Override
    public JSONObject getUserBackgroundImage(String id) throws Exception {
        JSONObject jsonObject = new JSONObject();
        String number = id.split("_")[1];
        String imagePath = "static/user/image/background/"+number+".png";
        String path = new ClassPathResource(imagePath).getURL().getPath();
        jsonObject.put("data", ImageLoader.getImageByte(path));
        return jsonObject;
    }
}
