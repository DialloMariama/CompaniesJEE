package com.groupeisi.companies.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.groupeisi.companies.dto.ProductDto;
import com.groupeisi.companies.dto.SaleDto;
import com.groupeisi.companies.entities.ProductEntity;
import com.groupeisi.companies.service.IProductService;
import com.groupeisi.companies.service.ISaleService;
import com.groupeisi.companies.service.ProductService;
import com.groupeisi.companies.service.SaleService;

/**
 * Servlet implementation class SaleServlet
 */
@WebServlet(name="sale", value="/sale")
public class SaleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ISaleService saleService = new SaleService();
	private IProductService productService = new ProductService();
	Logger log = LoggerFactory.getLogger(SaleServlet.class);
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("saleList", saleService.findAll().get());
		request.setAttribute("productList", productService.findAll().get());

		request.getRequestDispatcher("WEB-INF/jsp/sale/sales.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	 	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
		try {
			date = sdf.parse(request.getParameter("date"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		double qte = Double.parseDouble(request.getParameter("quantity"));
		String reference = request.getParameter("product");
		
		ProductEntity productEntity = new ProductEntity();
		ProductDto product = productService.getByid(reference, productEntity);
		product.setStock(product.getStock() - qte);
		SaleDto saleDto = new SaleDto(date, qte, product);
		
		saleService.save(saleDto);
		productService.update(product);

		doGet(request, response);
	}

}
