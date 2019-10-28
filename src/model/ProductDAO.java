package model;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ProductDAO {
	int create(ProductVO vo) throws SQLException;
	ProductVO readOne(ProductVO vo) throws SQLException;
	ArrayList<ProductVO> readList() throws SQLException;
	ArrayList<ProductVO> readPProductList() throws SQLException;
	ArrayList<ProductVO> readProfitList() throws SQLException;
	ArrayList<ProductVO> readGroupList() throws SQLException;
	int update(ProductVO vo) throws SQLException;
	int delete(ProductVO vo) throws SQLException;
	ArrayList<GroupcodeVO> gcodeList() throws SQLException;
}