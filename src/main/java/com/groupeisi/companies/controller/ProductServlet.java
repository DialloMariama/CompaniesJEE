package com.groupeisi.companies.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.groupeisi.companies.dto.ProductDto;
import com.groupeisi.companies.service.IProductService;
import com.groupeisi.companies.service.ProductService;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet(name = "products", value = "/products")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(ProductServlet.class);  
    private IProductService productService = new ProductService();

    public ProductServlet() {
        super();
    }
    
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("ProductServlet - Méthode doGet appelée");
        
        try {
            Optional<List<ProductDto>> products = productService.findAll();
            
            if (products.isPresent()) {
                logger.info("ProductServlet - Liste des produits récupérée avec succès");
                request.setAttribute("productList", products.get());
            } else {
                logger.info("ProductServlet - Aucun produit trouvé");
                request.setAttribute("productList", new ArrayList<ProductDto>());
            }
        } catch (Exception e) {
            logger.error("ProductServlet - Erreur lors de la récupération de la liste des produits", e);
        }
        
        request.getRequestDispatcher("/WEB-INF/jsp/product/products.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("ProductServlet - Méthode doPost appelée");
        
        String ref = request.getParameter("ref");
        String name = request.getParameter("name");
        double stock = Double.parseDouble(request.getParameter("stock"));
        
        logger.debug("ProductServlet - Paramètres reçus : ref={}, name={}, stock={}", ref, name, stock);
        
        ProductDto productDto = new ProductDto();
        productDto.setRef(ref);
        productDto.setName(name);
        productDto.setStock(stock);
        
        try {
            boolean productSaved = productService.save(productDto);
            logger.info("ProductServlet - Produit enregistré avec succès : {}", productSaved);
        } catch (Exception e) {
            logger.error("ProductServlet - Erreur lors de l'enregistrement du produit", e);
        }
        doGet(request, response);
    }
}
