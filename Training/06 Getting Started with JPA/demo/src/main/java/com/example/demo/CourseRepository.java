package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static String INSERT_QUERY = """
					INSERT INTO COURSES (id, name, author)
					VALUES (1, 'WEB DEV 2024', 'ANGELA YU')

			""";
	
	private static String DELETE_QUERY = """
			DELETE FROM COURSES WHERE
			ID = '1';

	""";
	
	public void create() {
		 String sql = "CREATE TABLE courses (" +
                 "id BIGINT NOT NULL, " +
                 "name VARCHAR(1000), " +
                 "author VARCHAR(250), " +
                 "PRIMARY KEY(id)" +
                 ")";
		 jdbcTemplate.execute(sql);
	}

	public void insert() {
		jdbcTemplate.update(INSERT_QUERY);
	}
	
	public void delete() {
		jdbcTemplate.update(DELETE_QUERY);
	}
}
