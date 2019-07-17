package cn.edu.hfut.coomall.web.custom;

import cn.edu.hfut.coomall.entity.Product;
import cn.edu.hfut.coomall.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoomallWebCustomApplicationTests {

    @Autowired
    ProductService productService;

    @Test
    @SuppressWarnings("unchecked")
    public void contextLoads() {
        Map<String, Object> map = productService.search("电脑", 1, 2);
        List<Product> productList = (List<Product>) map.get("list");
        System.out.println((Integer) map.get("totalPage"));
        System.out.println(productList);
    }

}
