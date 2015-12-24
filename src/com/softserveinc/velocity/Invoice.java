package com.softserveinc.velocity;

import java.util.*;
import java.text.*;

public class Invoice {

    Date orderDate;
    Date shipDate;
    float invoiceTotal;
    float shipTotal;
    float taxTotal;
    DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);

    public Date getOrderDate() {return orderDate;}
    public String getOrderDateDisplay() {return df.format(orderDate);}
    public void setOrderDate(Date s) {orderDate = s;}

    public Date getShipDate() {return shipDate;}
    public String getShipDateDisplay() {return df.format(shipDate);}
    public void setShipDate(Date s) {shipDate = s;}

    public float getInvoiceTotal() {return invoiceTotal;}
    public String getInvoiceTotalDisplay() {
        return NumberFormat.getCurrencyInstance().format(invoiceTotal);
    }
    public void setInvoiceTotal(float s) {invoiceTotal = s;}

    public float getShipTotal() {return shipTotal;}
    public String getShipTotalDisplay() {
        return NumberFormat.getCurrencyInstance().format(shipTotal);
    }
    public void setShipTotal(float s) {shipTotal = s;}

    public float getTaxTotal() {return taxTotal;}
    public String getTaxTotalDisplay() {
        return NumberFormat.getCurrencyInstance().format(taxTotal);
    }
    public void setTaxTotal(float s) {taxTotal = s;}
}