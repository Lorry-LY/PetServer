package com.lorry.petserver.dao.post;

import com.alibaba.fastjson.JSONObject;
import com.lorry.petserver.utils.file.ImageLoader;
import jakarta.annotation.Resource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostMapper implements PostMapperInterface{

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<JSONObject> getPostInfo() {
        String sql = "select * from postInfo";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            JSONObject postInfo = new JSONObject();
            postInfo.put("id",rs.getString("id"));
            postInfo.put("author_id",rs.getString("author_id"));
            postInfo.put("kind",rs.getString("kind"));
            postInfo.put("header_image",rs.getString("header_image"));
            postInfo.put("title",rs.getString("title"));
            return postInfo;
        });
    }

    @Override
    public JSONObject getPostInfo(String id) {
        String sql = String.format("select * from postInfo where id='%s'",id);
        List<JSONObject> userInfos = jdbcTemplate.query(sql, (rs, rowNum) -> {
            JSONObject userInfo = new JSONObject();
            userInfo.put("id",rs.getString("id"));
            userInfo.put("author_id",rs.getString("author_id"));
            userInfo.put("kind",rs.getString("kind"));
            userInfo.put("header_image",rs.getString("header_image"));
            userInfo.put("images",rs.getString("images"));
            userInfo.put("title",rs.getString("title"));
            userInfo.put("video",rs.getString("video"));
            userInfo.put("text",rs.getString("text"));
            userInfo.put("tags",rs.getString("tags"));
            userInfo.put("place",rs.getString("place"));
            userInfo.put("create_date",rs.getDate("create_time"));
            userInfo.put("remove_date",rs.getDate("remove_time"));
            userInfo.put("create_time",rs.getTime("create_time"));
            userInfo.put("remove_time",rs.getTime("remove_time"));
            return userInfo;
        });
        return userInfos.size() == 0 ? null : userInfos.get(0);
    }

    @Override
    public JSONObject getPostImage(String id, String image) throws Exception {
        JSONObject jsonObject = new JSONObject();
        String imagePath = String.format("static/post/%s/image/%s",id,image);
        String path = new ClassPathResource(imagePath).getURL().getPath();
        byte[] imageByte = ImageLoader.getImageByte(path);
        jsonObject.put("base64", imageByte);
        return jsonObject;
    }
}
