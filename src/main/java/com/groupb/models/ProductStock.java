package com.groupb.models;

import java.util.Date;

public class ProductStock {

	// This is an actual item in the warehouse
	
	private int warehouseStockId;
	private int productIdKey;
	private Date dateOfTrans;
	private String vendor;
	private String batchCode;
	private String invoiceNum;
	private int quantity;
	private String transType;
	public int getWarehouseStockId() {
		return warehouseStockId;
	}
	public void setWarehouseStockId(int warehouseStockId) {
		this.warehouseStockId = warehouseStockId;
	}
	public int getProductIdKey() {
		return productIdKey;
	}
	public void setProductIdKey(int productIdKey) {
		this.productIdKey = productIdKey;
	}
	public Date getDateOfTrans() {
		return dateOfTrans;
	}
	public void setDateOfTrans(Date dateOfTrans) {
		this.dateOfTrans = dateOfTrans;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public String getBatchCode() {
		return batchCode;
	}
	public void setBatchCode(String batchCode) {
		this.batchCode = batchCode;
	}
	public String getInvoiceNum() {
		return invoiceNum;
	}
	public void setInvoiceNum(String invoiceNum) {
		this.invoiceNum = invoiceNum;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getTransType() {
		return transType;
	}
	public void setTransType(String transType) {
		this.transType = transType;
	}
	
	
}
