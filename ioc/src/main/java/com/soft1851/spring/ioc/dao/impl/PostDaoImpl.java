package com.soft1851.spring.ioc.dao.impl;

import com.soft1851.spring.ioc.dao.PostDao;
import com.soft1851.spring.ioc.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Tao
 * @version 1.0
 * @ClassName PostDaoImpl
 * @Description TODO
 * @date 2020-03-17 15:24
 **/
@Repository
public class PostDaoImpl implements PostDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(Post post) {
        String sql = "INSERT INTO t_post VALUES (NULL,?,?,?,?,?)";
        Object[] args = {post.getForumId(), post.getTitle(),
                post.getContent(), post.getThumbnail(), post.getPostTime()};
        return jdbcTemplate.update(sql,args);
    }

    @Override
    public int[] batchInsert(List<Post> posts) {
        final List<Post> postList = posts;
        String sql = "INSERT INTO t_post VALUES (NULL,?,?,?,?,?)";
        return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                preparedStatement.setInt(1,postList.get(i).getForumId());
                preparedStatement.setString(2,postList.get(i).getTitle());
                preparedStatement.setString(3,postList.get(i).getContent());
                preparedStatement.setBytes(4,postList.get(i).getThumbnail());
                preparedStatement.setString(5,postList.get(i).getPostTime().toString());
            }
            @Override
            public int getBatchSize() {
                return postList.size();
            }
        });
    }

    @Override
    public int delete(int postId) {
        String sql = "DELETE FROM t_post WHERE post_id = ?";
        Object[] args = {postId};
        return jdbcTemplate.update(sql,args);
    }

    @Override
    public int batchDelete(int[] posts) {
        int i=0;
        for(i=0;i<posts.length;i++){
            delete(posts[i]);
        }
        return i;
    }

    @Override
    public Post get(int postId) {
        String sql = "SELECT * FROM t_post WHERE post_id = ? ";
        Object[] args = {postId};
        return jdbcTemplate.queryForObject(sql,args,new BeanPropertyRowMapper<>(Post.class));
    }

    @Override
    public List<Post> getAllByKey(String key1) {
        String sql = "SELECT * FROM t_post WHERE title LIKE '%"+key1+"%'";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Post.class));
    }


    @Override
    public int update(Post post) {
        String sql = "UPDATE t_post SET title = ? WHERE post_id = ? ";
        Object[] args = {post.getTitle(),post.getPostId()};
        return jdbcTemplate.update(sql,args);
    }

    @Override
    public int counts(int frontId) {
        String sql = "SELECT * FROM t_post WHERE forum_id = ? ";
        Object[] args = {frontId};
        List<Post> postList = jdbcTemplate.query(sql,args,new BeanPropertyRowMapper<>(Post.class));
        return postList.size();
    }

}
