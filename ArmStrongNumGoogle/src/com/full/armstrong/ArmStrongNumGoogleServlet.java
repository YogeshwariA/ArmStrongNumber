package com.full.armstrong;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class ArmStrongNumGoogleServlet extends HttpServlet {
	boolean isArmStrong;
	public void init() {
		System.out.println("Init called!");
	}

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		doGet(request, response);
		System.out.println("service called!");

	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		String message = "To Find Armstrong Number";
		resp.getWriter().println("<h1>" + message + "</h1>");

		try {
			int value = Integer.parseInt(req.getParameter("input"));
			isArmStrong = armStrongNumber(value);
			if (isArmStrong == true) {
				resp.getWriter().print("Given number is Armstrong");
			} else {
				resp.getWriter().print("Given number not is Armstrong");
			}
		} catch (Exception e) {
			resp.getWriter().println("Please give a number.");

		}

	}

	private boolean armStrongNumber(int value) {
		int sum = 0;
		int temp = 0;
		int number = value;
		while (value > 0) {
			temp = value % 10;
			sum += temp * temp * temp;
			value = value / 10;
		}
		isArmStrong = (sum == number) ? true : false;
		return isArmStrong;

	}
@Override
	public void destroy() {
		System.out.println("Destroy called!");
	}
}
