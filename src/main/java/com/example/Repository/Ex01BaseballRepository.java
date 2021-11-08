package com.example.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Ex01BaseballDomain;


@Repository
public class Ex01BaseballRepository {
	
	private static final RowMapper<Ex01BaseballDomain> EX01BASEBALLDOMAIN_ROW_MAPPER
	=new BeanPropertyRowMapper<>(Ex01BaseballDomain.class);

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	public List<Ex01BaseballDomain> findAll(){
		
		String sql = "SELECT league_name, team_name, headquarters, inauguration, history "
				+ "FROM teams ORDER BY inauguration DESC";
		
		return template.query(sql, EX01BASEBALLDOMAIN_ROW_MAPPER);
		
	}
	
	public Ex01BaseballDomain load(Integer id) {
		
		String sql = "SELECT league_name, team_name, headquarters, inauguration, history "
				+ "FROM teams WHERE id=:id";
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("id",id);
		
		Ex01BaseballDomain ex01BaseballDomain = template.queryForObject(sql, param, EX01BASEBALLDOMAIN_ROW_MAPPER);
		return ex01BaseballDomain;
				
	}
	
	
}
