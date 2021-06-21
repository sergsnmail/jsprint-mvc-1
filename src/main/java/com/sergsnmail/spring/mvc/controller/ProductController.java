package com.sergsnmail.spring.mvc.controller;

import com.sergsnmail.spring.mvc.controller.command.product.create.ProductCreate;
import com.sergsnmail.spring.mvc.controller.command.product.delete.ProductDelete;
import com.sergsnmail.spring.mvc.controller.command.product.read.ProductRead;
import com.sergsnmail.spring.mvc.controller.command.product.update.ProductUpdate;
import com.sergsnmail.spring.mvc.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String getAllProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("avg_cost", productService.calcAvgCost());
        return "products";
    }

    @GetMapping("/products/remove/{id}")
    public String deleteProduct(@PathVariable Long id) {
        ProductDelete deleteCommand = ProductDelete.builder()
                .setId(id)
                .build();
        productService.delete(deleteCommand.getParameter());
        return "redirect:/products";
    }

    @GetMapping("/products/edit/{id}")
    public String editProduct(Model model, @PathVariable Long id) {
        ProductRead readCommand = ProductRead.builder()
                .setId(id)
                .build();
        model.addAttribute("product", productService.read(readCommand.getParameter()));
        return "edit";
    }

    @PostMapping("/products/add")
    public String addProduct(@RequestParam Long id, @RequestParam String title, @RequestParam Float cost) {
        ProductCreate createCommand = ProductCreate.builder()
                .setId(id)
                .setTitle(title)
                .setCost(cost)
                .build();
        productService.create(createCommand.getParameter());
        return "redirect:/products";
    }

    @PostMapping("/products/update")
    public String updateProduct(@RequestParam Long id, @RequestParam String title, @RequestParam Float cost) {
        ProductUpdate updateCommand = ProductUpdate.builder()
                .setId(id)
                .setTitle(title)
                .setCost(cost)
                .build();
        productService.update(updateCommand.getParameter());
        return "redirect:/products";
    }
}
