package com.du.dubbolearn.provider.dao;

import com.du.dubbolearn.serviceapi.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

/**
 * @author dushengwei@duoshengbu.com
 * @since 2019/7/19
 */
@Repository
public class UserDao {
    private static final BeanPropertyRowMapper<User> rowMapper = BeanPropertyRowMapper.newInstance(User.class);
    private static final String TB_NAME = "`t_user`";

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public Long addUser(User user) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update("insert into " + TB_NAME + " (`name`,`age`) values (:name, :age)", new BeanPropertySqlParameterSource(user),keyHolder);

        return keyHolder.getKey().longValue();
    }
}
