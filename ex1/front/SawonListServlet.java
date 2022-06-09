package ex1.front;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ex1.dto.SawonDTO;
import ex1.model.SawonModel;
/*
 *           vo.setSabun(rs.getInt("sabun"));
                vo.setSaname(rs.getString("saname"));
                vo.setSajob(rs.getString("sajob"));
                vo.setDeptno(rs.getInt("deptno"));
                vo.setSahire(rs.getString("sahire"));
 * */

@WebServlet("/SawonListServlet")
public class SawonListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter pw = response.getWriter();
		pw.println("사원 리스트");
		SawonModel model = new SawonModel();
		ArrayList<SawonDTO> slist = model.getList();
		pw.println("<table style=\"width:500px; border:1px solid #ccffdd\">");
		for(SawonDTO e: slist) {
			pw.println("<tr>");
			pw.println("<td>"+e.getSabun()+"</td>");
			pw.println("<td>"+e.getSaname()+"</td>");
			pw.println("<td>"+e.getSajob()+"</td>");
			pw.println("<td>"+e.getDeptno()+"</td>");
			pw.println("<td>"+e.getSahire()+"</td>");
			pw.println("</tr>");
		}
		pw.println("</table>");
	}

}








