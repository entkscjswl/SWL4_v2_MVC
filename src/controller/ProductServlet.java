package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

import model.*;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("*.do")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String uri=request.getRequestURI();
		System.out.println("################## uri:" + uri);
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex+1);
		System.out.println("################## action:" + action);
		String viewPage = null;

		if(action.equals("create.do")) {			
			ProductDAOImpl dao=ProductDAOImpl.getInstance();
			ArrayList<GroupcodeVO> gcodes = new ArrayList<GroupcodeVO>();
			try {
				gcodes = dao.gcodeList();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("gVO", gcodes);
			viewPage="create.jsp";
		}
		if(action.equals("createPro.do")) {			
			ProductDAOImpl dao=ProductDAOImpl.getInstance();
			ProductVO vo = new ProductVO();
			vo.setCode(request.getParameter("code"));
			vo.setPname(request.getParameter("pname"));
			vo.setCost(Integer.parseInt(request.getParameter("cost")));
			vo.setPnum(Integer.parseInt(request.getParameter("pnum")));
			vo.setJnum(Integer.parseInt(request.getParameter("jnum")));
			vo.setSale(Integer.parseInt(request.getParameter("sale")));
			vo.setGcode(request.getParameter("gcode"));
			int result = 0;
			try {
				result = dao.create(vo);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			request.setAttribute("cResult", result);
			viewPage="createPro.jsp";
		}
		if(action.equals("searchPro.do")) {
			ProductDAOImpl dao=ProductDAOImpl.getInstance();
			
			ProductVO vo = new ProductVO();
			vo.setCode(request.getParameter("code"));
			try {
				vo = dao.readOne(vo);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			request.setAttribute("pVO", vo);
			
			ArrayList<GroupcodeVO> gcodes = new ArrayList<GroupcodeVO>();
			try {
				gcodes = dao.gcodeList();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("gVO", gcodes);
			viewPage="searchPro.jsp";
		}
		
		if(action.equals("update.do")) {			
			ProductDAOImpl dao=ProductDAOImpl.getInstance();
			ProductVO vo = new ProductVO();
			vo.setCode(request.getParameter("code"));
			vo.setPname(request.getParameter("pname"));
			vo.setCost(Integer.parseInt(request.getParameter("cost")));
			vo.setPnum(Integer.parseInt(request.getParameter("pnum")));
			vo.setJnum(Integer.parseInt(request.getParameter("jnum")));
			vo.setSale(Integer.parseInt(request.getParameter("sale")));
			vo.setGcode(request.getParameter("gcode"));
			int rs=0;
			try {
				rs = dao.update(vo);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("uResult", rs);
			viewPage="update.jsp";
		}
		if(action.equals("delete.do")) {			
			ProductDAOImpl dao=ProductDAOImpl.getInstance();
			ProductVO vo = new ProductVO();
			vo.setCode(request.getParameter("code"));
			int rs=0;
			try {
				rs = dao.delete(vo);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("dResult", rs);
			viewPage="delete.jsp";
		}

		if(action.equals("pproduct.do")) {			
			ProductDAOImpl dao=ProductDAOImpl.getInstance();
			ArrayList<ProductVO> vos = new ArrayList<ProductVO>();
			try {
				vos = dao.readPProductList();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("pVO", vos);
			viewPage="pproduct.jsp";
		}

		if(action.equals("profit.do")) {			
			ProductDAOImpl dao=ProductDAOImpl.getInstance();
			ArrayList<ProductVO> vos = new ArrayList<ProductVO>();
			try {
				vos = dao.readProfitList();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("pVO", vos);
			viewPage="profit.jsp";
		}
		if(action.equals("jnum.do")) {			
			ProductDAOImpl dao=ProductDAOImpl.getInstance();
			ArrayList<ProductVO> vos = new ArrayList<ProductVO>();
			try {
				vos = dao.readGroupList();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("pVOs", vos);
			viewPage="jnum.jsp";
		}

		RequestDispatcher rDis = request.getRequestDispatcher(viewPage);
		rDis.forward(request, response);
	}

}
