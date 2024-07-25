package com.groupeisi.companies.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.groupeisi.companies.dto.AccountUserDto;
import com.groupeisi.companies.service.AccountUserService;
import com.groupeisi.companies.service.IAccountUserService;
/**
 * Servlet implementation class AdminServlet
 */
@WebServlet(name = "admin", value = "/admin")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IAccountUserService accountUserService = new AccountUserService();
	Logger log = LoggerFactory.getLogger(LoginServlet.class);

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("userList", accountUserService.findAll().get());

		request.getRequestDispatcher("WEB-INF/jsp/admin/users.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		boolean state = req.getParameter("state").equals("1");
		
		AccountUserDto userDto = new AccountUserDto(email, password, state);
		
		accountUserService.save(userDto);
		
		doGet(req, resp);

	}

}
