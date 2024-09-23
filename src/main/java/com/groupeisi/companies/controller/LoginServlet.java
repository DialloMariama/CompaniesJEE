package com.groupeisi.companies.controller;

import java.io.IOException;
import java.util.Optional;

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
 * Servlet implementation class Login
 */
@WebServlet(name = "login" , value =  "/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IAccountUserService accountUserService = new AccountUserService();
	Logger logger = LoggerFactory.getLogger(LoginServlet.class);

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		logger.info("email envoyé: {} ", userName);
		
		try {
			Optional<AccountUserDto> accountUserDto = accountUserService.login(userName, password);
			
			if (accountUserDto.isPresent()) {
				request.getSession().setAttribute("username", userName);
				response.sendRedirect("welcome");
			}else {
				response.sendRedirect("login");
			}
		} catch (Exception e) {
			logger.error("{}", e);
			response.sendRedirect("login");
		}
		
		
	}

}
