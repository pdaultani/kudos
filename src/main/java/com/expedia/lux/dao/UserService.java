package com.expedia.lux.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.expedia.lux.model.KudosData;
import com.expedia.lux.model.User;

@Service("userService")
@Transactional
public class UserService {
	protected static Logger logger = Logger.getLogger("service");
	  
	 private JdbcTemplate jdbcTemplate;
	  
	 @Resource(name="dataSource")
	 public void setDataSource(DataSource dataSource) {
	     this.jdbcTemplate = new JdbcTemplate(dataSource);
	 }
	 

		public void create(Integer teamId, String username) {
			String SQL = "insert into Users (username, teamId) values (?, ?)";
		      
			jdbcTemplate.update( SQL, username, teamId);
		      System.out.println("Created Record Name = " + username + " Team Id = " + teamId);
		      return;
			
		}


		public User getUser(Integer id) {
			String sql = "select * from Users where id = ?";
		      
			RowMapper<User> mapper = new RowMapper<User>() {  
		         public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		        	 User user = new User();
		        	 
		        	 user.setId(rs.getInt("id"));
		     		user.setTeamId(rs.getInt("teamId"));
		     		user.setUsername(rs.getString("username"));
		             return user;
		         }
		     };
		     User user = jdbcTemplate.queryForObject(sql, 
                     new Object[]{id}, mapper);
		     
		     return user;
		}

		public User getUser(String username) {
			String sql = "select * from Users where username = ?";
		      
			RowMapper<User> mapper = new RowMapper<User>() {  
		         public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		        	 User user = new User();
		        	 
		        	 user.setId(rs.getInt("id"));
		     		user.setTeamId(rs.getInt("teamId"));
		     		user.setUsername(rs.getString("username"));
		             return user;
		         }
		     };
		     User user = jdbcTemplate.queryForObject(sql, 
                     new Object[]{username}, mapper);
		     
		     return user;
		}

		public void delete(Integer id) {
			 String SQL = "delete from Users where id = ?";
			 jdbcTemplate.update(SQL, id);
		      System.out.println("Deleted Record with ID = " + id );
		      return;
			
		}


		public void update(Integer id, Integer teamId, String username) {
			 String SQL = "update Users set username = ? where id = ?";
			 jdbcTemplate.update(SQL, username, id);
		      System.out.println("Updated Record with ID = " + id );
		      return;
			
		}
}
