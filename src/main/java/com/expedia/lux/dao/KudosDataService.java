package com.expedia.lux.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.expedia.lux.model.KudosData;
import com.expedia.lux.model.User;

import javax.sql.DataSource;

@Service("kudosDataService")
@Transactional
public class KudosDataService {

	protected static Logger logger = Logger.getLogger(KudosDataService.class);
	  
	 private JdbcTemplate jdbcTemplate;
	 private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	 
	 @Resource(name="userService")
	 private UserService userService;
	 
	 @Resource(name="dataSource")
	 public void setDataSource(DataSource dataSource) {
	     this.jdbcTemplate = new JdbcTemplate(dataSource);
	     this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	 }
	 
	 public void add(String kudos_sent_to, String kudos_sent_from, String kudos_content){
		 User from = userService.getUser(kudos_sent_from);
		 //get user id's from usernames. if not found then create them. 
		 try{
			 
			 User sent_to = userService.getUser(kudos_sent_to);
		 }
		 catch (Exception e){
			 logger.info("user is not found so try to create a new one");
			 userService.create(1, kudos_sent_to); //figure out how to get the team id here.
			 
		 }
		 User sent_to = userService.getUser(kudos_sent_to);
		 
		// Prepare our SQL statement using Named Parameters style
		 
		  String sql = "insert into kudosData(kudosSentUserId, kudosRecvdUserId, kudosContent, dateSent) values " +
		    "(:sent_id, :recvd_id, :content, :date_sent)";
		   
		  // Assign values to parameters
		  Map<String, Object> parameters = new HashMap<String, Object>();
		  
		  parameters.put("sent_id", from.getId());
		  parameters.put("recvd_id", sent_to.getId());
		  parameters.put("content", kudos_content);
		  parameters.put("date_sent", new Date());
		  logger.info("Coming hhere to save the records");
		  
		  // Save
		  namedParameterJdbcTemplate.update(sql, parameters);

	 }
	 
	 public List<KudosData> getAll(Integer user_id) {
		  logger.debug("Retrieving all kudosdata");
		  	
		  User user = userService.getUser(user_id);
		  String sql = "select t.manager, k.kudoscontent, k.dateSent, u1.username, u2.username from teams t inner join users u1 on t.id=u1.teamid inner join kudosdata k on k.kudossentuserid = u1.id inner join users u2 on k.kudosrecvduserid = u2.id where u1.teamId= ?";
		  		  		  
		  Object[] get_team_info_params = new Object[] {user.getTeamId()};

		  
		  // Maps a SQL result to a Java object
		  RowMapper<KudosData> mapper = new RowMapper<KudosData>() {  
		         public KudosData mapRow(ResultSet rs, int rowNum) throws SQLException {
		        	 KudosData kudosdata = new KudosData();
		        	
		        	 kudosdata.setKudosSentUserId(rs.getInt("kudosSentUserId"));
		        	 kudosdata.setKudosRecvdUserId(rs.getInt("kudosRecvdUserId"));
		        	 kudosdata.setDateSent(rs.getDate("dateSent"));
		        	 kudosdata.setKudosContent(rs.getString("kudosContent"));
		             return kudosdata;
		         }
		     };
		   
		     KudosDataResultSetExtractor extractor = new KudosDataResultSetExtractor();
		     return jdbcTemplate.query(sql, get_team_info_params, extractor);
		     		  
		 }
		  
}
