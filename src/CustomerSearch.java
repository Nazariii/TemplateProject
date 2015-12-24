import org.apache.velocity.Template;
import org.apache.velocity.servlet.VelocityServlet;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.context.Context;
import javax.servlet.http.*;
import java.util.*;
import com.softserveinc.velocity.*;

public class CustomerSearch extends VelocityServlet  {

    public Template handleRequest( HttpServletRequest request,
                                   HttpServletResponse response,
                                   Context context )  {

        Template template = null;
        Customer customer = getCustomer();

        try  {
            context.put("customer", customer);
            template = Velocity.getTemplate("hello.vm");
        }  catch( Exception e )  {
          System.err.println("Exception caught: " + e.getMessage());
        }

        return template;
    }

    private Customer getCustomer()  {
        Customer customer = new Customer();
        customer.setCustomerNumber("ABC123");
        customer.setName("Joe JavaRanch");
        customer.setAddress("123 Rancho Javo");
        customer.setCity("Bueno Ranch");
        customer.setState("CO");
        customer.setZip("63121");
        customer.setPhone("303-555-1212");
		addInvoices(customer);
        return customer;
    }
	
	 private void addInvoices(Customer2 customer) {
        Invoice inv = null;
        Date[] datesOrder = {new GregorianCalendar(2004,01,21).getTime(),
            new GregorianCalendar(2003,11,18).getTime(), 
            new GregorianCalendar(2003,11,01).getTime()};
        Date[] datesShip = {new GregorianCalendar(2004,01,28).getTime(),
            new GregorianCalendar(2003,11,20).getTime(),
            new GregorianCalendar(2003,11,15).getTime()};
        float[] invTotals = {231.45f, 456.22f, 86.14f};
        float[] taxTotals = {18.21f, 43.18f, 3.11f};
        float[] shipTotals = {6.54f, 14.38f, 14.32f};
        for (int i=0; i<datesOrder.length; i++) {
            inv = new Invoice();
            inv.setOrderDate(datesOrder[i]);
            inv.setShipDate(datesShip[i]);
            inv.setInvoiceTotal(invTotals[i]);
            inv.setTaxTotal(taxTotals[i]);
            inv.setShipTotal(shipTotals[i]);
            customer.addInvoice(inv);
    }
}