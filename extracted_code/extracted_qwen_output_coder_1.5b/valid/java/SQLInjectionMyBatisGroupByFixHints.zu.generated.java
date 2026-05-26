```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class SalesService {

    @Autowired
    private SalesMapper salesMapper;

    public List<Map<String, Object>> getSalesByGroup(String groupField, String dateRange) {
        String[] dates = dateRange.split(",");
        String startDate = dates[0];
        String endDate = dates[1];
        return salesMapper.selectSalesByGroup(groupField, startDate, endDate);
    }
}

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;
import java.util.Map;

@Mapper
public interface SalesMapper {

    @Select("<script>" +
            "SELECT ${groupField} AS group_key, SUM(amount) AS total_sales " +
            "FROM sales " +
            "WHERE sale_date BETWEEN #{startDate} AND #{endDate} " +
            "GROUP BY ${groupField}" +
            "</script>")
    List<Map<String, Object>> selectSalesByGroup(@Param("groupField") String groupField,
                                                 @Param("startDate") String startDate,
                                                 @Param("endDate") String endDate);
}
```