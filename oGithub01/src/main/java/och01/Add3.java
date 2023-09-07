package och01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Add3
 */
@WebServlet("/Add3")
public class Add3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add3() {	// 생성자
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet 여기 왔네");
		System.out.println("이미 UP 내용 수정");
		
		
		//Parameter 받기
		int num = Integer.parseInt(request.getParameter("num"));
		String loc = request.getParameter("loc");
		System.out.println("num : "+num);
		System.out.println("loc : "+loc);
		int sum=0;
		for(int i=1; i<=num; i++) {
			sum += i;
		}
		System.out.println("sum : "+sum);
		
		// Encoding 방식 지정
		response.setContentType("text/html;charset=utf-8");
		// request도 동일한 방식으로 지정 가능 (그러나 Get 방식에서 request는 인코딩 X)
		// request.setCharacterEncoding("utf-8");
		
		// 사용자 Browser에 보여주는 객체 (공식이므로 고개 끄덕끄덕)
		PrintWriter out = response.getWriter();
		out.println("<html><body>");			//out : sysout이랑 거의 유사
		out.printf("<h1>1부터 %d까지 합계(get)</h1>",num);//sysout은 콘솔, out은 브라우저
		out.printf("<h4>LOC => %s</h4>",loc);
		out.println(sum);
		out.println("</body></html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost 여기 왔네");
		
		// Encoding 방식 지정 (request는 parameter 받기 전 지정해주어야 함)
		request.setCharacterEncoding("utf-8");
		
		//Parameter 받기
		int num = Integer.parseInt(request.getParameter("num"));
		String loc = request.getParameter("loc");
		System.out.println("num : "+num);
		System.out.println("loc : "+loc);
		int sum=0;
		for(int i=1; i<=num; i++) {
			sum += i;
		}
		System.out.println("sum : "+sum);
		
		// Encoding 방식 지정 (response는 객체 사용 직전 인코딩)
		response.setContentType("text/html;charset=utf-8");
		
		// 사용자 Browser에 보여주는 객체 (공식이므로 고개 끄덕끄덕)
		PrintWriter out = response.getWriter();
		out.println("<html><body>");			//out : sysout이랑 거의 유사
		out.printf("<h1>1부터 %d까지 합계(post)</h1>",num);//sysout은 콘솔, out은 브라우저
		out.printf("<h4>LOC => %s</h4>",loc);
		out.println(sum);
		out.println("</body></html>");
		out.close();
	}
}
