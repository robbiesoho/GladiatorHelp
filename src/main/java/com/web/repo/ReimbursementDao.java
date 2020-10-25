package com.web.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.web.model.Reimbursement;
import com.web.util.ConnectionUtil;

public class ReimbursementDao implements DaoContract<Reimbursement, Integer> {
	static Logger log = Logger.getLogger(UserDao.class);

//	public static void main(String[] args) {
//		ReimbursementDao rd = new ReimbursementDao();
//		System.out.println(rd.findReimsByUsername("go4it"));
//
//	}

	@Override
	public List<Reimbursement> findAll() {
		List<Reimbursement> reims = new LinkedList<>();
		try (Connection conn = ConnectionUtil.getInstance().getConnection()) {
			Statement s = conn.createStatement();
			String sql = "select * from reimbursement";
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				reims.add(new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3).toLocalDateTime(),
						rs.getString(5), rs.getBytes(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10)));

			}
			rs.close();
			s.close();

		} catch (SQLException e) {
			log.error("SQL exception for Reimbursements.findAll: " + e.getMessage());
			e.printStackTrace();
		}
		return reims;

	}

	@Override
	public Reimbursement findById(Integer i) {
		Reimbursement reimb = null;
		try (Connection conn = ConnectionUtil.getInstance().getConnection()) {
			String sql = "select * from user_acc where user_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				reimb = new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3).toLocalDateTime(),
						rs.getString(5), rs.getBytes(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10));
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
			log.error("SQL exception for Reimbursement.findById: " + e.getMessage());

			e.printStackTrace();
		}
		return reimb;
	}

	@Override
	public int update(Reimbursement t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String create(Reimbursement t) {
		try (Connection conn = ConnectionUtil.getInstance().getConnection()) {
			String sql = "insert into reimbursement (amount, description, author_id, status_id, type_id) values (?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, t.getAmount());
			ps.setString(2, t.getDescription());
			ps.setInt(3, t.getAuthorId());
			ps.setInt(4, t.getStatusId());
			ps.setInt(5, t.getTypeId());
			int updated = ps.executeUpdate();
			log.info("Reimbursement created" + t);
		} catch (SQLException e) {
			log.error("Error while creating reimbursement: " + e.getMessage());
			e.printStackTrace();

		}
		return "";
	}

	@Override
	public String delete(Integer i) {
		try (Connection conn = ConnectionUtil.getInstance().getConnection()) {
			String sql = "delete from reimbursement where reim_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, i);
			int rs = ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			log.error("Error while deleting reimbursement: " + e.getMessage());

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Reimbursement findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

//	callable vs prepared
	public int approveReimbursement(Integer reimbId, Integer userId) {
		try (Connection conn = ConnectionUtil.getInstance().getConnection()) {
			String sql = "call approve_reimbursement(?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, reimbId);
			ps.setInt(2, userId);
			int rs = ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			log.error("Error while approving reimbursement: " + e.getMessage());

			e.printStackTrace();
		}
		return 1;
	}

	public int denyReimbursement(Integer reimbId, Integer userId) {
		try (Connection conn = ConnectionUtil.getInstance().getConnection()) {
			String sql = "call deny_reimbursement(?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, reimbId);
			ps.setInt(2, userId);
			int rs = ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			log.error("Error while denying reimbursement: " + e.getMessage());

			e.printStackTrace();
		}
		return 1;
	}

	public List<Reimbursement> findReimsByUserId(Integer id) {
		List<Reimbursement> reims = new LinkedList<>();
		try (Connection conn = ConnectionUtil.getInstance().getConnection()) {
			String sql = "select * from reimbursement where author_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				reims.add(new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3).toLocalDateTime(),
						rs.getString(5), rs.getBytes(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10)));

			}
			rs.close();
			ps.close();

		} catch (SQLException e) {
			log.error("SQL exception for Reimbursements.findReimsByUserId: " + e.getMessage());
			e.printStackTrace();
		}
		return reims;

	}

	public List<Reimbursement> findCompleteReimbursements() {
		List<Reimbursement> reims = new LinkedList<>();
		try (Connection conn = ConnectionUtil.getInstance().getConnection()) {
			Statement s = conn.createStatement();
			String sql = "select * from complete_reimbursement";
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
//				System.out.println(rs.getString(2));
				reims.add(new Reimbursement(rs.getInt(1), rs.getString(2), rs.getTimestamp(3).toLocalDateTime(),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7)));
			}
			rs.close();
			s.close();

		} catch (SQLException e) {
			log.error("SQL exception for Reimbursements.findAll: " + e.getMessage());
			e.printStackTrace();
		}
		return reims;

	}

	public List<Reimbursement> findCompletePendingReims() {
		List<Reimbursement> reims = new LinkedList<>();
		try (Connection conn = ConnectionUtil.getInstance().getConnection()) {
			Statement s = conn.createStatement();
			String sql = "select * from complete_reimbursement where status = 'pending'";
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
//				System.out.println(rs.getInt(1));
//				System.out.println(rs.getString(2));
//				System.out.println(rs.getString(4));
//				System.out.println(rs.getString(5));
//				System.out.println(rs.getString(6));
//				System.out.println(rs.getString(7));
				reims.add(new Reimbursement(rs.getInt(1), rs.getString(2), rs.getTimestamp(3).toLocalDateTime(),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7)));
			}
			rs.close();
			s.close();

		} catch (SQLException e) {
			log.error("SQL exception for Reimbursements.findAll: " + e.getMessage());
			e.printStackTrace();
		}
		return reims;

	}

	public List<Reimbursement> findReimsByUsername(String name) {
		List<Reimbursement> reims = new LinkedList<>();
		try (Connection conn = ConnectionUtil.getInstance().getConnection()) {
			String sql = "select * from complete_reimbursement where username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				reims.add(new Reimbursement(rs.getInt(1), rs.getString(2), rs.getTimestamp(3).toLocalDateTime(),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7)));
			}
			rs.close();
			ps.close();

		} catch (SQLException e) {
			log.error("SQL exception for Reimbursements.findAll: " + e.getMessage());
			e.printStackTrace();
		}
		return reims;

	}

}