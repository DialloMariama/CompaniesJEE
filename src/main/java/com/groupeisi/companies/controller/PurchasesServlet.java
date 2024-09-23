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
import com.groupeisi.companies.dto.PurchasesDto;
import com.groupeisi.companies.service.IProductService;
import com.groupeisi.companies.service.IPurchasesService;
import com.groupeisi.companies.service.ProductService;
import com.groupeisi.companies.service.PurchasesService;

/**
 * Servlet implementation class PurchasesServlet
 */
@WebServlet(name = "purchases", value = "/purchases")
public class PurchasesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Logger logger = LoggerFactory.getLogger(PurchasesServlet.class);  
    private IPurchasesService purchasesService = new PurchasesService();
    private IProductService productService = new ProductService(); // Ajout du service produit

    public PurchasesServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("PurchasesServlet - Méthode doGet appelée");
        
        try {
            Optional<List<PurchasesDto>> purchases = purchasesService.findAll();
            request.setAttribute("purchasesList", purchases.orElse(new ArrayList<>()));

            Optional<List<ProductDto>> products = productService.findAll();
            request.setAttribute("productList", products.orElse(new ArrayList<>()));
            
        } catch (Exception e) {
            logger.error("Erreur lors de la récupération des données", e);
        }
        
        request.getRequestDispatcher("/WEB-INF/jsp/purchases/purchases.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("PurchasesServlet - Méthode doPost appelée");
        
        String productRef = request.getParameter("productRef");
        double quantity = Double.parseDouble(request.getParameter("quantity"));
        
        logger.debug("Paramètres reçus : productRef={}, quantity={}", productRef, quantity);
        
        Optional<ProductDto> productOptional = productService.findByRef(productRef);
        
        if (productOptional.isPresent()) {
            ProductDto productDto = productOptional.get();
            
            PurchasesDto purchasesDto = new PurchasesDto();
            purchasesDto.setProduct(productDto);
            purchasesDto.setQuantity(quantity);
            
            try {
                purchasesService.save(purchasesDto);
                logger.info("Achat enregistré avec succès");
            } catch (Exception e) {
                logger.error("Erreur lors de l'enregistrement de l'achat", e);
            }
        } else {
            logger.error("Produit non trouvé avec la référence : " + productRef);
        }

        //request.getRequestDispatcher("/WEB-INF/jsp/product/products.jsp").forward(request, response);
        doGet(request, response);
    }
}
