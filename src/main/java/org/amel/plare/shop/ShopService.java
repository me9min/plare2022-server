package org.amel.plare.shop;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/** Service layer for shop
 * 샵 서비스 및 로직 레이어
 */
@Service
public class ShopService {

    /** method stub for shop item retrieval from DB
     *
     * @return stub
     */
    public List<Shop> getShopItems() {
        List<Shop> res = new ArrayList<>();
        try {
            Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session = sqlSessionFactory.openSession();
            res = session.selectList("Student.getAll");
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return res;
    }
//사용된 레퍼런스
//    https://www.tutorialspoint.com/mybatis/mybatis_read_operation.htm
}
