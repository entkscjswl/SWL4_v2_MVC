package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDAOImpl extends DAOBase implements ProductDAO {
	private static ProductDAOImpl instance=new ProductDAOImpl();
	public static ProductDAOImpl getInstance(){
		return instance;
	}
	private ProductDAOImpl() {}
	
	@Override
	public int create(ProductVO vo) throws SQLException{
		Connection conn=null;
		PreparedStatement pstmt = null;
		int rs = 0;
		String sql = null;
		try {
			conn = getConnection();
			sql = "insert into product values (?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getCode());
			pstmt.setString(2, vo.getPname());
			pstmt.setInt(3, vo.getCost());
			pstmt.setInt(4, vo.getPnum());
			pstmt.setInt(5, vo.getJnum());
			pstmt.setInt(6, vo.getSale());
			pstmt.setString(7, vo.getGcode());
			rs = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDBResources(pstmt, conn);
		}
		return rs;
	}
	
	@Override
	public ProductVO readOne(ProductVO vo) throws SQLException{
		Connection conn=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
//		ArrayList<ProductVO> products = new ArrayList<ProductVO>();
		ProductVO pdt = new ProductVO();
		try {
			conn = getConnection();
			sql = "select * from product where code=?";
			pstmt = conn.prepareStatement(sql);
			if(vo.getCode()!=null) {
				pstmt.setString(1, vo.getCode());
			} else
				pstmt.setString(1, " ");
			rs = pstmt.executeQuery();
			if(rs.next()) {
				pdt.setCode(rs.getString(1));
				pdt.setPname(rs.getString(2));
				pdt.setCost(rs.getInt(3));
				pdt.setPnum(rs.getInt(4));
				pdt.setJnum(rs.getInt(5));
				pdt.setSale(rs.getInt(6));
				pdt.setGcode(rs.getString(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDBResources(rs, pstmt, conn);
		}
		return pdt;
	}
	
	@Override
	public ArrayList<ProductVO> readList() throws SQLException{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		ArrayList<ProductVO> products = new ArrayList<ProductVO>();
		try {
			conn = getConnection();
			sql = "Select * from product";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
					ProductVO pdt = new ProductVO();
					pdt.setCode(rs.getString(1));
					pdt.setPname(rs.getString(2));
					pdt.setCost(rs.getInt(3));
					pdt.setPnum(rs.getInt(4));
					pdt.setJnum(rs.getInt(5));
					pdt.setSale(rs.getInt(6));
					pdt.setGcode(rs.getString(7));
					products.add(pdt);
				} while (rs.next());
			}
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			closeDBResources(rs, pstmt, conn);
		}
		return products;
	}
	public ArrayList<ProductVO> readPProductList() throws SQLException{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		ArrayList<ProductVO> products = new ArrayList<ProductVO>();
		try {
			conn = getConnection();
			sql = "Select * from product where jnum<pnum*0.2";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
					ProductVO pdt = new ProductVO();
					pdt.setCode(rs.getString(1));
					pdt.setPname(rs.getString(2));
					pdt.setCost(rs.getInt(3));
					pdt.setPnum(rs.getInt(4));
					pdt.setJnum(rs.getInt(5));
					pdt.setSale(rs.getInt(6));
					pdt.setGcode(rs.getString(7));
					products.add(pdt);
				} while (rs.next());
			}
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			closeDBResources(rs, pstmt, conn);
		}
		return products;
	}
	public ArrayList<ProductVO> readProfitList() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		ArrayList<ProductVO> products = new ArrayList<ProductVO>();
		try {
			conn = getConnection();
			sql = "Select * from product order by jnum*(sale-cost)";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
					ProductVO pdt = new ProductVO();
					pdt.setCode(rs.getString(1));
					pdt.setPname(rs.getString(2));
					pdt.setCost(rs.getInt(3));
					pdt.setPnum(rs.getInt(4));
					pdt.setJnum(rs.getInt(5));
					pdt.setSale(rs.getInt(6));
					pdt.setGcode(rs.getString(7));
					products.add(pdt);
				} while (rs.next());
			}
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			closeDBResources(rs, pstmt, conn);
		}
		return products;
	}
	public ArrayList<ProductVO> readGroupList() throws SQLException{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		ArrayList<ProductVO> products = new ArrayList<ProductVO>();
		try {
			conn = getConnection();
			sql = "select g.gname, sum(p.jnum), p.gcode from product p, groupcode g "
					+ "where g.gcode=p.gcode "
					+ "group by p.gcode, g.gname";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
					ProductVO pdt = new ProductVO();
					pdt.setGname(rs.getString(1));
					pdt.setJnum(rs.getInt(2));
					pdt.setGcode(rs.getString(3));
					products.add(pdt);
				} while (rs.next());
			}
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			closeDBResources(rs, pstmt, conn);
		}
		return products;
	}
	
	@Override
	public int update(ProductVO vo) throws SQLException{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rs = 0;
		String sql = null;
		try {
			conn = getConnection();
			sql = "update product set pname=?, cost=?, pnum=?, jnum=?, sale=?, gcode=? where code=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPname());
			pstmt.setInt(2, vo.getCost());
			pstmt.setInt(3, vo.getPnum());
			pstmt.setInt(4, vo.getJnum());
			pstmt.setInt(5, vo.getSale());
			pstmt.setString(6, vo.getGcode());
			pstmt.setString(7, vo.getCode());
			rs = pstmt.executeUpdate();
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			closeDBResources(pstmt, conn);
		}
		return rs;
	}
	
	@Override
	public int delete(ProductVO vo) throws SQLException{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rs = 0;
		String sql = null;
		try {
			conn = getConnection();
			sql = "delete from product where code=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getCode());
			rs = pstmt.executeUpdate();
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			closeDBResources(pstmt, conn);
		}
		return rs;
	}
	
	
	public ArrayList<GroupcodeVO> gcodeList() throws SQLException{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		ArrayList<GroupcodeVO> gcodes = new ArrayList<GroupcodeVO>();
		try {
			conn = getConnection();
			sql = "Select * from groupcode";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
					GroupcodeVO gcode = new GroupcodeVO();
					gcode.setGcode(rs.getString(1));
					gcode.setGname(rs.getString(2));
					gcodes.add(gcode);
				} while (rs.next());
			}
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			closeDBResources(rs, pstmt, conn);
		}
		return gcodes;
	}
}
