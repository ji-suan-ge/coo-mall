package cn.edu.hfut.coomall.service;

import cn.edu.hfut.coomall.dao.ProductMapper;
import cn.edu.hfut.coomall.entity.Product;
import cn.edu.hfut.coomall.service.exception.ProductNotFoundException;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 葛学文
 * @date 2019/7/14 21:53
 */
@Service
public class ProductService {

    @Autowired
    ProductMapper productMapper;

    public void saveProduct(Product product) {
        productMapper.insertProduct(product);
    }

    public void removeProductByID(Integer productID) {
        productMapper.deleteProduct(productID);
    }

    public Product getProductByID(Integer productID) {

        Product product = productMapper.selectProductByID(productID);
        if (product == null) {
            throw new ProductNotFoundException(productID);
        }
        return product;
    }

    public Map<String, Object> getProductByMerchantID(Integer merchantID, Integer currentPage,
                                                      Integer limit) {

        Page page = PageHelper.startPage(currentPage, limit);
        List<Product> productList = productMapper.selectProductByMerchantID(merchantID);

        Map<String , Object> map = new HashMap<>();
        map.put("list", productList);
        map.put("totalPage", page.getPages());
        return map;
    }

    public void editProduct(Integer productID, Integer price, Integer quantity, String detail) {

        productMapper.updateProduct(productID, price, quantity, detail);
    }

    public Map<String, Object> search(String keyword, Integer currentPage, Integer limit) {

        Page page = PageHelper.startPage(currentPage, limit);
        List<Product> productList = productMapper.search(keyword);
        Map<String, Object> map = new HashMap<>();
        map.put("list", productList);
        map.put("totalPage", page.getPages());

        return map;
    }

    public Map<String, Object> getProductByCategory(Integer category, Integer currentPage, Integer limit) {

        Page page = PageHelper.startPage(currentPage, limit);
        List<Product> productList = productMapper.selectProductByCategory(category);

        Map<String , Object> map = new HashMap<>();
        map.put("list", productList);
        map.put("totalPage", page.getPages());
        return map;
    }
}
