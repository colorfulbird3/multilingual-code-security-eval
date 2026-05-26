```java
// SalesMapper.java
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;
import java.util.Map;

@Mapper
public interface SalesMapper {
    
    @Select("SELECT ${groupField}, SUM(amount) as total_amount, COUNT(*) as count " +
            "FROM sales " +
            "WHERE sale_date BETWEEN #{startDate} AND #{endDate} " +
            "GROUP BY ${groupField}")
    List<Map<String, Object>> getSalesByGroup(@Param("groupField") String groupField,
                                              @Param("startDate") String startDate,
                                              @Param("endDate") String endDate);
}
```