package com.example.travel.service;

import com.example.travel.bean.HotelBean;
import com.example.travel.bean.ProductBean;
import com.example.travel.mapper.HotelMapper;
import com.example.travel.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductMapper productMapper;

    public List<ProductBean> getProductList() {
        return productMapper.getProductList();
    }

    public int addProduct(ProductBean product) {
        return productMapper.addProduct(product);
    }

    public int deleteProduct(int productID) { return productMapper.deleteProduct(productID); }

    public int updateProduct(ProductBean product) { return productMapper.updateProduct(product); }

}
