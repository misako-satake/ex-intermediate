package com.example.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Ex02HotelDomain;

@Repository
public class Ex02HotelRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Ex02HotelDomain> EX02HOTELDOMAIN_ROW_MAPPER
	=new BeanPropertyRowMapper<>(Ex02HotelDomain.class);

	public List<Ex02HotelDomain> findAll(){
		String sql = "SELECT id, area_name, hotel_name, address, nearest_station, price, parking "
				+ "FROM hotels ORDER BY price;";
		
		return template.query(sql, EX02HOTELDOMAIN_ROW_MAPPER);
	}
	
	public List<Ex02HotelDomain> loadByLessThanPrice(Integer price){
			String sql ="SELECT  id, area_name, hotel_name, address, nearest_station, price, parking "
					+ "FROM hotels WHERE price<=:price";
			
			SqlParameterSource param = new MapSqlParameterSource().addValue("price",price);
			List<Ex02HotelDomain> hotelList= template.query(sql, param, EX02HOTELDOMAIN_ROW_MAPPER);
			return hotelList;
	}
	
}
