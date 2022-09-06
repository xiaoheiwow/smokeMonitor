package me.xhw.mapper;

import java.util.List;
import java.util.Date;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import com.base.entity.query.QueryParams;
import me.xhw.entity.OrderRecord;

/**
 * @author xhw----2022年08月24日
 */
@Mapper
public interface OrderRecordMapper {



	int updateByOrderId(@Param("data")OrderRecord orderRecord);

	
}
