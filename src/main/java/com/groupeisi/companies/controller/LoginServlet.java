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

/**
 * Servlet implementation class Login
 */
@WebServlet(name = "login" , value =  "/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger log = LoggerFactory.getLogger(LoginServlet.class);
	private AccountUserService userService = new AccountUserService();
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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String pwd = req.getParameter("password");
		
		log.info("L'email envoyé est {}", email);
		
		try {
			Optional<AccountUserDto> user = userService.login(email, pwd);
			if (user.isPresent()) {
				req.getSession().setAttribute("username", email);
				resp.sendRedirect("welcome");
			} else {
				resp.sendRedirect("login");
			}
		} catch (Exception e) {
			log.error("Erreur", e);
			resp.sendRedirect("login");
		}
		
	}

}
