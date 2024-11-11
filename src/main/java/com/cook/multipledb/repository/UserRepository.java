package com.cook.multipledb.repository;

import com.cook.multipledb.config.DataSourceInfo;
import com.cook.multipledb.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Slf4j
@Repository
public class UserRepository {

    private final Map<String, JdbcTemplate> jdbcTemplateMap;

    @Autowired
    public UserRepository(Map<String, JdbcTemplate> jdbcTemplateMap) {
        this.jdbcTemplateMap = jdbcTemplateMap;
    }

    public List<User> getUsers(DataSourceInfo config) {
        try {
            JdbcTemplate jdbcTemplate = jdbcTemplateMap.get(config.name());
            String query = buildGetUsersQuery(config);
            List<User> data = jdbcTemplate.query(query, (rs, row) -> parseUser(rs));

            log.info("Retrieved {} users from db: {}, strategy: {}", data.size(), config.name(), config.strategy());

            return data;
        } catch (Exception e) {
            log.error("Error during fetching users from database : {}, error: {} ", config.name(), e.getMessage());
            return Collections.emptyList();
        }
    }

    private String buildGetUsersQuery(DataSourceInfo config) {
        Map<String, String> mapping = config.mapping();
        return String.format("SELECT %s AS id, %s AS username, %s AS name, %s AS surname FROM %s",
                mapping.get("id"),
                mapping.get("username"),
                mapping.get("name"),
                mapping.get("surname"),
                config.table());
    }

    private User parseUser(ResultSet rs) {
        try {
            return new User(
                    rs.getString("id"),
                    rs.getString("username"),
                    rs.getString("name"),
                    rs.getString("surname")
            );
        } catch (SQLException e) {
            log.error("Error during parsing user : {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

}
