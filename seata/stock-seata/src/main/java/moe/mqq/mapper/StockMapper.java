package moe.mqq.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface StockMapper {
    @Update("update tbl set count=count-1 where product_id=#{reductId}")
    Integer reduct(String reductId);
}
