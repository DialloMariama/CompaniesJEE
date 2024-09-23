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

import com.groupeisi.companies.dto.SalesDto;
import com.groupeisi.companies.dto.ProductDto;
import com.groupeisi.companies.service.IProductService;
import com.groupeisi.companies.service.ISalesService;
import com.groupeisi.companies.service.ProductService;
import com.groupeisi.companies.service.SalesService;

@WebServlet(name = "sales", value = "/sales")
public class SalesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Logger logger = LoggerFactory.getLogger(SalesServlet.class);  
    private ISalesService salesService = new SalesService();
    private IProductService productService = new ProductService();

    public SalesServlet() {
        super();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("SalesServlet - Méthode doGet appelée");
        
        try {
            Optional<List<SalesDto>> sales = salesService.findAll();
            Optional<List<ProductDto>> products = productService.findAll();
            
            if (sales.isPresent()) {
                logger.info("Liste des ventes récupérée avec succès");
                request.setAttribute("salesList", sales.get());
            } else {
                logger.info("Aucune vente trouvée");
                request.setAttribute("salesList", new ArrayList<SalesDto>());
            }
            
            if (products.isPresent()) {
                logger.info("Liste des produits récupérée avec succès");
                request.setAttribute("productList", products.get());
            } else {
                logger.info("Aucun produit trouvé");
                request.setAttribute("productList", new ArrayList<ProductDto>());
            }
        } catch (Exception e) {
            logger.error("Erreur lors de la récupération de la liste des ventes", e);
        }
        
        request.getRequestDispatcher("/WEB-INF/jsp/sales/sales.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("SalesServlet - Méthode doPost appelée");
        
        String productRef = request.getParameter("productRef");
        double quantity = Double.parseDouble(request.getParameter("quantity"));
        
        logger.debug("Paramètres reçus : productRef={}, quantity={}", productRef, quantity);
        
        SalesDto salesDto = new SalesDto();
        salesDto.setQuantity(quantity);
        
        try {
            Optional<ProductDto> product = productService.findByRef(productRef);
            if (product.isPresent()) {
                salesDto.setProduct(product.get());
                salesService.save(salesDto);
                logger.info("Vente enregistrée avec succès");
            } else {
                logger.error("Produit non trouvé avec la référence : {}", productRef);
            }
        } catch (Exception e) {
            logger.error("Erreur lors de l'enregistrement de la vente", e);
        }
        doGet(request, response);
    }
}
