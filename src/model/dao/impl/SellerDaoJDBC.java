package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao {

	private Connection conn;
	
	public SellerDaoJDBC (Connection conn) {
		this.conn = conn;
	}
	@Override
	public void insert(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Seller findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT seller.*,department.name as dep_name\n"
					+ "FROM seller INNER JOIN department\n"
					+ "ON seller.department_id = department.id\n"
					+ "WHERE seller.id = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			if(rs.next()) {
				Department dep = instantiateDepartment(rs);
				Seller seller = instantiateSeller(dep, rs);
				return seller;
			}
			return null;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResusltSet(rs);
		}
	}

	private Seller instantiateSeller(Department dep, ResultSet rs) throws SQLException {
		Seller seller = new Seller();
		seller.setId(rs.getInt("id"));
		seller.setName(rs.getString("name"));
		seller.setEmail(rs.getString("email"));
		seller.setBrithDate(rs.getDate("birth_date"));
		seller.setBaseSalary(rs.getDouble("base_salary"));
		seller.setDepartment(dep);
		return seller;
	}
	private Department instantiateDepartment(ResultSet rs) throws SQLException {
		Department dep = new Department();
		dep.setId(rs.getInt("department_id"));
		dep.setName(rs.getString("dep_name"));
		return dep;
	}
	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
