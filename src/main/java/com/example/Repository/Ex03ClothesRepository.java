package com.example.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Ex03ClothesDomain;

@Repository
public class Ex03ClothesRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Ex03ClothesDomain> EX03CLOTHESDOMAIN_ROW_MAPPER
	=new BeanPropertyRowMapper<>(Ex03ClothesDomain.class);

	public List<Ex03ClothesDomain> loadByColorAndGender(Integer gender,String color){
		String sql = "SELECT id,category, genre, gender, color, price, size "
				+ "FROM clothes WHERE gender=:gender AND color=:color ORDER BY id;";
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("gender",gender).addValue("color",color);
		
		List<Ex03ClothesDomain> clothesList = template.query(sql, param, EX03CLOTHESDOMAIN_ROW_MAPPER);
		return clothesList;
		
	}
	
	
}
