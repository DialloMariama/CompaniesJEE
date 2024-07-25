package com.groupeisi.companies.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.groupeisi.companies.dto.ProductDto;
import com.groupeisi.companies.service.IProductService;
import com.groupeisi.companies.service.ProductService;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet(name = "product", value = "/product")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IProductService productService = new ProductService();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("productList", productService.findAll().get());

		request.getRequestDispatcher("WEB-INF/jsp/product/products.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String ref = request.getParameter("reference");
		double stock = Double.parseDouble(request.getParameter("stock"));
		
		ProductDto productDto = new ProductDto(ref, name, stock);
		
		productService.save(productDto);
		
		doGet(request, response);
	}

}
