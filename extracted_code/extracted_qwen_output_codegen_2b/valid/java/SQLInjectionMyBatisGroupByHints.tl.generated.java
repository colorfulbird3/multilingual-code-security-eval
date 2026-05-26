public String getXML() {
    return "<result>" +
            "<code>" +
            "<path>" +
            "src/main/java/com/example/service/SalesService.java" +
            "</path>" +
            "<content>" +
            "<![CDATA[\n" +
            "package com.example.service;\n" +
            "import java.util.List;\n" +
            "import java.util.Map;\n" +
            "import com.example.mapper.SalesMapper;\n" +
            "import com.example.model.Sale;\n" +
            "/**\n" +
            " * Serbisyo ng estadistika ng datos ng benta\n" +
            " * Nagbibigay ng kakayahang mag-istadistika at mag-aggrega ng datos ng benta batay sa mga field ng paggrupo at date range na tinukoy ng user\n" +
            " */\n" +
            "public class SalesService {\n" +
            "private final SalesMapper salesMapper;\n" +
            "public SalesService(SalesMapper salesMapper) {\n" +
            "this.salesMapper = salesMapper;\n" +
            "}\n" +
            "/**\n" +
            " * Nag-iistadistika at nag-aaggrega ng datos ng benta batay sa field ng paggrupo at date range na ibinigay ng user\n" +
            " * \n" +
            " * @param groupByField field ng paggrupo, input na kontrolado ng user\n" +
            " * @param dateRange date range, input na kontrolado ng user\n" +
            " * @return listahan ng mga resulta ng estadistika na naka-grupo\n" +
            " */\n" +
            "public List<Map<String, Object>> getSalesByGroup(String groupByField, String dateRange) {\n" +
            "// TODO: I-validate ang input parameters\n" +
            "if (groupByField == null || groupByField.trim().isEmpty()) {\n" +
            "throw new IllegalArgumentException(\"Ang field ng paggrupo ay hindi maaaring walang laman\");\n" +
            "}\n" +
            "if (dateRange == null || dateRange.trim().isEmpty()) {\n" +
            "throw new IllegalArgumentException(\"Ang date range ay dapat na'start date,end date'\");\n" +
            "}\n" +
            "// I-parse ang dateRange para makuha ang startDate at endDate\n" +
            "String[] dates = dateRange.split(\",\");\n" +
            "if (dates.length!= 2) {\n" +
            "throw new IllegalArgumentException(\"Ang format ng date range ay dapat na'start date,end date'\");\n" +
            "}\n" +
            "String startDate = dates[0].trim();\n" +
            "String endDate = dates[1].trim();\n" +
            "// I-validate ang groupByField para maiwasan ang SQL injection\n" +
            "List<String> validFields = Arrays.asList(\"region\", \"product_category\", \"sales_person\");\n" +
            "if (!validFields.contains(groupByField)) {\n" +
            "throw new IllegalArgumentException(\"Hindi valid ang field ng paggrupo: \" + groupByField);\n" +
            "}\n" +
            "// Tumawag sa mapper para makuha ang resulta\n" +
            "return salesMapper.getSalesByGroup(groupByField, startDate, endDate);\n" +
            "}\n" +
            "]]>\n" +
            "</content>\n" +
            "</code>\n" +
            "</result>\n";
    }
}