// ```xml
// <result>
// <code>
// <path>
// src/main/java/com/example/service/SalesService.java
// </path>
// <content>
// <![CDATA[
// package com.example.service;
// import java.util.List;
// import java.util.Map;
// import com.example.mapper.SalesMapper;
// import com.example.model.Sale;
// /**
// * Serbisyo ng estadistika ng datos ng benta
// * Nagbibigay ng kakayahang mag-istadistika ng datos ng benta batay sa mga field ng pagpapangkat at saklaw ng petsa na ibinigay ng user
// */
// public class SalesService {
// private final SalesMapper salesMapper;
// public SalesService(SalesMapper salesMapper) {
// this.salesMapper = salesMapper;
// }
// /**
// * Istadistikang suriin ang datos ng benta batay sa field ng pagpapangkat at saklaw ng petsa na ibinigay ng user
// *
// * @param groupByField field ng pagpapangkat, kontrolado ng input ng user
// * @param dateRange saklaw ng petsa, kontrolado ng input ng user
// * @return listahan ng mga naka-grupong resulta ng estadistika
// */
// public List<Map<String, Object>> getSalesByGroup(String groupByField, String dateRange) {
// // Hatiin ang dateRange para makuha ang startDate at endDate
// String[] dates = dateRange.split(",");
// String startDate = dates[0].trim();
// String endDate = dates[1].trim();
// // Tumawag sa mapper para makuha ang estadistika
// return salesMapper.getSalesByGroup(groupByField, startDate, endDate);
// }
// }
// ]]>
// </content>
// </code>
// </result>
// ```
package com.app.wms.engine.db.dto.map;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

public class SalesDTO {

	private int salesId;
	private String salesCode;
	private String salesName;
	private String salesContact;
	private Date salesDate;
	private String salesContactPhone;
	private String salesAddress;
	private String salesAmount;
	private String salesAmountCurrency;
	private String salesAmountDescription;
	private String salesItem;
	private String salesItemDescription;
	private String salesItemDiscount;
	private String salesItemDiscountCurrency;
	private String salesItemDiscountDescription;
	private String salesItemName;
	private String salesItemNameDescription;
	private String salesItemPrice;
	private String salesItemPriceCurrency;
	private String salesItemPriceDescription;
	private String salesItemQuantity;
	private String salesItemQuantityDescription;
	private String salesItemUnit;
	private String salesItemUnitDescription;
	private double salesItemQuantityPrice;
	private double salesItemQuantityPriceCurrency;
	private double salesItemQuantityPriceDescription;
	private String salesItemUnitPrice;
	private String salesItemUnitPriceCurrency;
	private double salesItemUnitPriceDescription;
	private String salesItemUnitPriceDescription;

	public int getSalesId() {
		return salesId;
	}

	public void setSalesId(int salesId) {
		this.salesId = salesId;
	}

	public String getSalesCode() {
		return salesCode;
	}

	public void setSalesCode(String salesCode) {
		this.salesCode = salesCode;
	}

	public String getSalesName() {
		return salesName;
	}

	public void setSalesName(String salesName) {
		this.salesName = salesName;
	}

	public String getSalesContact() {
		return salesContact;
	}

	public void setSalesContact(String salesContact) {
		this.salesContact = salesContact;
	}

	public Date getSalesDate() {
		return salesDate;
	}

	public void setSalesDate(Date salesDate) {
		this.salesDate = salesDate;
	}

	public String getSalesContactPhone() {
		return salesContactPhone;
	}

	public void setSalesContactPhone(String salesContactPhone) {
		this.salesContactPhone = salesContactPhone;
	}

	public String getSalesAddress() {
		return salesAddress;
	}

	public void setSalesAddress(String salesAddress) {
		this.salesAddress = salesAddress;
	}

	public String getSalesAmount() {
		return salesAmount;
	}

	public void setSalesAmount(String salesAmount) {
		this.salesAmount = salesAmount;
	}

	public String getSalesAmountCurrency() {
		return salesAmountCurrency;
	}

	public void setSalesAmountCurrency(String salesAmountCurrency) {
		this.salesAmountCurrency = salesAmountCurrency;
	}

	public String getSalesAmountDescription() {
		return salesAmountDescription;
	}

	public void setSalesAmountDescription(String salesAmountDescription) {
		this.salesAmountDescription = salesAmountDescription;
	}

	public String getSalesItem() {
		return salesItem;
	}

	public void setSalesItem(String salesItem) {
		this.salesItem = salesItem;
	}

	public String getSalesItemDescription() {
		return salesItemDescription;
	}

	public void setSalesItemDescription(String salesItemDescription) {
		this.salesItemDescription = salesItemDescription;
	}

	public String getSalesItemDiscount() {
		return salesItemDiscount;
	}

	public void setSalesItemDiscount(String salesItemDiscount) {
		this.salesItemDiscount = salesItemDiscount;
	}

	public String getSalesItemDiscountCurrency() {
		return salesItemDiscountCurrency;
	}

	public void setSalesItemDiscountCurrency(String salesItemDiscountCurrency) {
		this.salesItemDiscountCurrency = salesItemDiscountCurrency;
	}

	public String getSalesItemDiscount