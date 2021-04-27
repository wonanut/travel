package com.example.travel.mapper;

import com.example.travel.bean.HotelBean;
import com.example.travel.bean.ProductBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    List<ProductBean> getProductList();
    int addProduct(ProductBean product);
    int deleteProduct(int productID);
    int updateProduct(ProductBean product);
}
