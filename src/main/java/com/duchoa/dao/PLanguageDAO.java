package com.duchoa.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.duchoa.entity.PLanguage;

@Repository
public class PLanguageDAO {

	@Autowired
	private JdbcTemplate jdbc;

	/**
	 * Thêm mới một thực thể
	 */
	public void insert(PLanguage language) {
		String sql = "INSERT INTO PLanguages(Id, Name, Description) VALUES(?,?,?)";
		jdbc.update(sql, language.getId(), language.getName(), language.getDescription());
	}

	/**
	 * Cập nhật một thực thể
	 */
	public void update(PLanguage language) {
		String sql = "UPDATE PLanguages SET Name=?, Description=? WHERE Id=?";
		jdbc.update(sql, language.getName(), language.getDescription(), language.getId());
	}

	/**
	 * Xóa một thực thể
	 */
	public void delete(Serializable id) {
		String sql = "DELETE FROM PLanguages WHERE Id = ?";
		jdbc.update(sql, id);
	}

	/**
	 * Truy vấn thực thể theo mã
	 */
	public PLanguage getById(Serializable id) {
		String sql = "SELECT * FROM PLanguages WHERE Id = ?";
		return jdbc.queryForObject(sql, getRowMapper(), id);

	}

	public List<PLanguage> getAll() {
		String sql = "SELECT * FROM PLanguages";
		return getBySql(sql);
	}

	public List<PLanguage> getBySql(String sql) {

		return jdbc.query(sql, getRowMapper());
	}

	@SuppressWarnings("unchecked") 		
	public List<PLanguage> getByName(String name) {
		String sql = "SELECT * FROM PLanguages WHERE Name LIKE ?";
		return (List<PLanguage>) jdbc.queryForObject(sql, getRowMapper(), "%" + name + "%");
	}
	
	private RowMapper<PLanguage> getRowMapper(){
		return new BeanPropertyRowMapper<PLanguage>(PLanguage.class);
	}
}
