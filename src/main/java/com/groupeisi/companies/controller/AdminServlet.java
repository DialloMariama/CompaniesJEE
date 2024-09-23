package com.groupeisi.companies.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.groupeisi.companies.dao.AccountUserDao;
import com.groupeisi.companies.dto.AccountUserDto;
import com.groupeisi.companies.entities.AccountUserEntity;
import com.groupeisi.companies.service.AccountUserService;
import com.groupeisi.companies.service.IAccountUserService;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet(name = "admin", value = "/admin")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IAccountUserService accountUserService = new AccountUserService();
	Logger logger = LoggerFactory.getLogger(LoginServlet.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  logger.info("AdminServlet - Méthode doGet appelée");
		  
		  try {
			  Optional<List<AccountUserDto>> users = accountUserService.findAll(); 
			  if(users.isPresent()) {
				  logger.info("Liste des utilisateurs récupérée avec succès");
				  request.setAttribute("userList", users.get()); 
			  } else {
				  logger.info("Aucun utilisateur trouvé");
				  request.setAttribute("userList", new ArrayList<AccountUserEntity>());
			  }
		  } catch (Exception e) {
	            logger.error("Erreur lors de la récupération de la liste des utilisateurs", e);
	        }
		  
		  request.getRequestDispatcher("WEB-INF/jsp/admin/users.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  logger.info("AdminServlet - Méthode doPost appelée");
		  String email = request.getParameter("email"); 
		  String password = request.getParameter("password"); 
		  boolean etat = Boolean.valueOf(request.getParameter("etat"));
		  
		  logger.debug("Paramètres reçus : email={}, état={}", email, etat);     
		  
		  AccountUserDto accountUserDto = new AccountUserDto();
		  
		  accountUserDto.setEmail(email); 
		  accountUserDto.setState(etat);
		  accountUserDto.setPassword(password); 
		  try {
			  accountUserService.save(accountUserDto); 
			  logger.info("Utilisateur enregistré avec succès");
		  } catch (Exception e) {
			  logger.error("Erreur lors de l'enregistrement de l'utilisateur", e);
		  }
		  
		  doGet(request, response);	 
	}

}
