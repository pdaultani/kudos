package com.expedia.lux.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import com.expedia.lux.model.KudosData;
import com.expedia.lux.model.Team;
import com.expedia.lux.model.User;

public class KudosDataResultSetExtractor  implements ResultSetExtractor<List<KudosData>> {

	private static final Logger logger = LoggerFactory.getLogger(KudosDataResultSetExtractor.class);
	
	@Override
	public List<KudosData> extractData(ResultSet rs) throws SQLException,
			DataAccessException {
		List<KudosData> kudosData = new ArrayList<KudosData>();
		
		 while(rs.next()){
			 KudosData kudos = new KudosData();			 
			 kudos.setKudosContent(rs.getString("kudosContent"));
			 kudos.setDateSent(rs.getDate("dateSent"));
        	 List<User> users = kudos.getUsers();  
        	 List<Team> teams = kudos.getTeams();  
        	 
        	 User user = new User();
        	 user.setUsername(rs.getString("u1.username"));
			 users.add(user);
			 
			 User user1 = new User();
        	 user1.setUsername(rs.getString("u2.username"));
        	 users.add(user1);
        	 
        	 Team team = new Team();
        	 team.setManager(rs.getString("t.manager"));
        	 teams.add(team);
        	 
        	 kudos.setUsers(users);
        	 kudos.setTeams(teams);
        	 kudosData.add(kudos);
	      }
	      return kudosData;
	}

}
