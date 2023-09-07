package och01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Board
 */
@WebServlet("/Board")	// 이 라인 주석처리 시, HTML 에러남 (이 서블릿으로 찾아올 수 없기 때문)
						// 즉, 이 라인 덕분에 HTML이 서블릿을 찾아오는 것
public class Board extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Board() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet 방식");
		
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost 방식");
		
		// request Encoding 방식 지정
		request.setCharacterEncoding("utf-8");
		
		//Parameter 받기
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String contents = request.getParameter("contents");
		System.out.println("title : "+title);
		System.out.println("writer : "+writer);
		System.out.println("contents : "+contents);
		
		Date date = new Date();
		
		// response Encoding 방식 지정
		response.setContentType("text/html;charset=utf-8");
		
		// 사용자 브라우저에 출력할 객체
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.printf("제목 : %s<p>",title);
		out.printf("작성자 : %s<p>",writer);
		out.print("작성일 : "+date+"<p>");
		out.print("내용 : <br><pre>"+contents+"</pre>");
		out.println("</body></html>");
		out.close();
	}

}
