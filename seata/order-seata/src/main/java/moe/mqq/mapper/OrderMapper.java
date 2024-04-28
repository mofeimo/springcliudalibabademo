package moe.mqq.mapper;

import moe.mqq.pojo.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderMapper {
    @Insert("insert into tbl(id,product_id,count,status) values (#{id},#{productId},#{count},#{status})")
    Integer insert(Order order);
    @Select("select id,product_id,count,status from tbl")
    List<Order> all();
    @Select("select id,product_id,count,status from tbl where id=#{id}")
    Order selectbyid(String id);
}
