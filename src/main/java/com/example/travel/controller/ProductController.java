package com.example.travel.controller;

import com.example.travel.bean.HotelBean;
import com.example.travel.bean.ProductBean;
import com.example.travel.service.HotelService;
import com.example.travel.service.ProductService;
import com.example.travel.utils.DateFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.List;
import java.util.Map;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("/getProductList")
    public ModelAndView getProductList() {
        ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());
        List<ProductBean> dataList = productService.getProductList();
        modelAndView.addObject("dataList", dataList);
        modelAndView.addObject("status", "success");
        return modelAndView;
    }

    @RequestMapping(value="/deleteProduct", method=RequestMethod.POST)
    public ModelAndView deleteProduct(@RequestParam Map<String, Object> params) {
        ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());
        int productID = Integer.parseInt(params.get("productID").toString());
        int status = productService.deleteProduct(productID);
        List<ProductBean> dataList = productService.getProductList();
        modelAndView.addObject("dataList", dataList);
        modelAndView.addObject("status", "success");
        return modelAndView;
    }

    @RequestMapping(value="/addProduct", method=RequestMethod.POST)
    public ModelAndView addProduct(@RequestParam Map<String, Object> params) {
        ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());

        String productName = params.get("productName").toString();
        String productDesc = params.get("productDesc").toString();
        String productAuthor = params.get("productAuthor").toString();
        String productPicture = params.get("productPicture").toString();
        String productPrice = params.get("productPrice").toString();
        String productPhone = params.get("productPhone").toString();
        String productRemain = params.get("productRemain").toString();
        String productStar = params.get("productStar").toString();

        productPicture = productPicture.isEmpty() ? "https://5b0988e595225.cdn.sohucs.com/images/20171212/14f763a8cd144b60860d560c39ebce4f.jpeg" : productPicture;

        DateFormatter dateFormatter = new DateFormatter();
        String productDate = dateFormatter.getDate();

        ProductBean productBean = new ProductBean();

        productBean.setProductName(productName);
        productBean.setProductDesc(productDesc);
        productBean.setProductAuthor(productAuthor);
        productBean.setProductPicture(productPicture);
        productBean.setProductPrice(productPrice);
        productBean.setProductPhone(productPhone);
        productBean.setProductRemain(productRemain);
        productBean.setProductStar(productStar);
        productBean.setProductDate(productDate);
        productBean.setProductStatus("normal");

        int status = productService.addProduct(productBean);
        List<ProductBean> dataList = productService.getProductList();
        modelAndView.addObject("dataList", dataList);
        modelAndView.addObject("status", "success");
        return modelAndView;
    }

    @RequestMapping(value="/updateProduct", method=RequestMethod.POST)
    public ModelAndView updateProduct(@RequestParam Map<String, Object> params) {
        ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());

        int productID = Integer.parseInt(params.get("productID").toString());
        String productName = params.get("productName").toString();
        String productDesc = params.get("productDesc").toString();
        String productAuthor = params.get("productAuthor").toString();
        String productPicture = params.get("productPicture").toString();
        String productPrice = params.get("productPrice").toString();
        String productPhone = params.get("productPhone").toString();
        String productRemain = params.get("productRemain").toString();
        String productStar = params.get("productStar").toString();

        productPicture = productPicture.isEmpty() ? "https://5b0988e595225.cdn.sohucs.com/images/20171212/14f763a8cd144b60860d560c39ebce4f.jpeg" : productPicture;

        HotelBean hotelBean = new HotelBean();

        ProductBean productBean = new ProductBean();

        productBean.setProductID(productID);
        productBean.setProductName(productName);
        productBean.setProductDesc(productDesc);
        productBean.setProductAuthor(productAuthor);
        productBean.setProductPicture(productPicture);
        productBean.setProductPrice(productPrice);
        productBean.setProductPhone(productPhone);
        productBean.setProductRemain(productRemain);
        productBean.setProductStar(productStar);

        int status = productService.updateProduct(productBean);
        List<ProductBean> dataList = productService.getProductList();
        modelAndView.addObject("dataList", dataList);
        modelAndView.addObject("status", "success");
        return modelAndView;
    }
}
