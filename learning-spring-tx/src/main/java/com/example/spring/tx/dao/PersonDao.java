package com.example.spring.tx.dao;

import com.example.spring.tx.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.*;

/**
 * Created by puroc on 2017/8/28.
 */
@Repository
public class PersonDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(Person person) {
        final String sql = "INSERT INTO person(name,age) VALUES(?,?)";
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection conn)
                    throws SQLException {
                PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, person.getName());
                ps.setInt(2, person.getAge());
                return ps;
            }
        });
    }

    public void insertFailed(Person person) throws SQLException {
        throw new SQLException("insertFailed");
    }

    public Person getByName(String name) {
        String sql = "SELECT name,age FROM person WHERE name=?";
        final Person person = new Person();
        jdbcTemplate.query(sql, new Object[]{name},
                new RowCallbackHandler() {
                    public void processRow(ResultSet rs) throws SQLException {
                        person.setId(rs.getRow());
                        person.setName(rs.getString("name"));
                        person.setAge(rs.getInt("age"));
                    }
                });
        return person;
    }
}
