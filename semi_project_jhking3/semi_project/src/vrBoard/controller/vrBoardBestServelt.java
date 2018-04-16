package vrBoard.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import vrBoard.model.service.vrBoardService;
import vrBoard.model.vo.vrBoard;

/**
 * Servlet implementation class vrBoardBestServelt
 */
@WebServlet("/vrbest")
public class vrBoardBestServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public vrBoardBestServelt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		vrBoard top = new vrBoardService().selectTopLikeCount();
		
		JSONObject sendJSON = new JSONObject();
		sendJSON.put("vrboardnum", top.getVrboardnum());
		sendJSON.put("vrtitle", URLEncoder.encode(top.getVrboardtitle(), "UTF-8"));
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter output = response.getWriter();
		output.print(sendJSON.toJSONString());
		output.flush();
		output.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
