package com.web.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.web.model.User;
import com.web.util.ConnectionUtil;

public class UserDao implements DaoContract<User, Integer> {
	static Logger log = Logger.getLogger(UserDao.class);

	public static void main(String[] args) {
		UserDao ud = new UserDao();
		User u = ud.findByName("validUser");
		System.out.println(u.getUsername());
	}

	@Override
	public List<User> findAll() {
		List<User> users = new LinkedList<>();
		try (Connection conn = ConnectionUtil.getInstance().getConnection()) {
			Statement s = conn.createStatement();
			String sql = "select * from user_acc";
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7)));

			}
			rs.close();
			s.close();

		} catch (SQLException e) {
			log.error("SQL exception for User.findAll: " + e.getMessage());
			e.printStackTrace();
		}
		return users;

	}

	@Override
	public User findById(Integer i) {
		User user = null;
		try (Connection conn = ConnectionUtil.getInstance().getConnection()) {
			String sql = "select * from user_acc where user_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7));
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
			log.error("SQL exception for User.findById: " + e.getMessage());

			e.printStackTrace();
		}
		return user;
	}

	@Override
	public String create(User t) {
		try (Connection conn = ConnectionUtil.getInstance().getConnection()) {
			String sql = "insert into user_acc (username, password, first,last, email, role_id) values (?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, t.getUsername());
			ps.setString(2, t.getPassword());
			ps.setString(3, t.getFirstName());
			ps.setString(4, t.getLastName());
			ps.setString(5, t.getEmail());
			ps.setInt(6, t.getRoleId());
			int updated = ps.executeUpdate();
			log.info("USer created" + t);
		} catch (SQLException e) {
			log.error("Error while creating user: " + e.getMessage());
			e.printStackTrace();

		}
		return null;
	}

	@Override
	public String delete(Integer i) {
		try (Connection conn = ConnectionUtil.getInstance().getConnection()) {
			String sql = "delete from user_acc where user_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, i);
			int rs = ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			log.error("Error while deleting user: " + e.getMessage());

			e.printStackTrace();
		}
		return null;
	}

	public User findByName(String name) {
		User user = null;
		try (Connection conn = ConnectionUtil.getInstance().getConnection()) {
			String sql = "select * from user_acc where username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7));
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
			log.error("SQL exception for User.findByName: " + e.getMessage());

			e.printStackTrace();
		}
		return user;

	}

}
