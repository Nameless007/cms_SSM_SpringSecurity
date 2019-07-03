package com.itheima.ssm.controller;

import com.itheima.ssm.domain.Product;
import com.itheima.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;


    @RequestMapping("/save.do")
    public String save(Product product)throws Exception{
        productService.save(product);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findAll.do")
    @RolesAllowed("user")
    public ModelAndView findAll(ModelAndView modelAndView)throws Exception{
        List<Product> products = productService.findAll();
        modelAndView.addObject("productList",products);
        modelAndView.setViewName("product-list");
        return modelAndView;
    }
}
