import com.example.mapper.SalesMapper;
import com.example.model.Sale;

/**
 * Serbisyo ng estadistika ng datos ng benta
 * Nagbibigay ng kakayahang mag-istadistika at mag-aggrega ng datos ng benta batay sa mga field ng paggrupo at date range na tinukoy ng user
 */
public class SalesService {
    
    private final SalesMapper salesMapper;
    
    public SalesService(SalesMapper salesMapper) {
        this.salesMapper = salesMapper;
    }
    
    /**
     * Nag-iistadistika at nag-aaggrega ng datos ng benta batay sa field ng paggrupo at date range na ibinigay ng user
     * 
     * @param groupByField field ng paggrupo, input na kontrolado ng user
     * @param dateRange date range, input na kontrolado ng user
     * @return listahan ng mga resulta ng estadistika na naka-grupo
     */
    public List<Map<String, Object>> getSalesByGroup(String groupByField, String dateRange) {
        // TODO: I-validate ang input parameters
        if (groupByField == null || groupByField.trim().isEmpty()) {
            throw new IllegalArgumentException("Ang field ng paggrupo ay hindi maaaring walang laman");
        }
        if (dateRange == null || dateRange.trim().isEmpty()) {
            throw new IllegalArgumentException("Ang date range ay hindi maaaring walang laman");
        }
        
        // I-parse ang dateRange para makuha ang startDate at endDate
        String[] dates = dateRange.split(",");
        if (dates.length!= 2) {
            throw new IllegalArgumentException("Ang format ng date range ay dapat na'start date,end date'");
        }
        
        String startDate = dates[0].trim();
        String endDate = dates[1].trim();
        
        // I-validate ang groupByField para maiwasan ang SQL injection
        List<String> validFields = Arrays.asList("region", "product_category", "sales_person");
        if (!validFields.contains(groupByField)) {
            throw new IllegalArgumentException("Hindi valid ang field ng paggrupo: " + groupByField);
        }
        
        // Tumawag sa mapper para makuha ang resulta
        return salesMapper.getSalesByGroup(groupByField, startDate, endDate);
    }
}