package com.applications;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import com.suresh.Address;
import com.suresh.Customer;
import com.suresh.PaymentMethod;

public class App {
	public static void main(String[] args) throws ParseException, DatatypeConfigurationException, JAXBException {

		PaymentMethod method = new PaymentMethod();
		method.setCardName("AMEX");
		method.setCardNumber(12345678);

		SimpleDateFormat spf = new SimpleDateFormat("mm/dd/yyyy");
		Date date = spf.parse("01/01/2017");
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(date);
		XMLGregorianCalendar startDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
		method.setDateFrom(startDate);

		Date date1 = spf.parse("01/01/2021");
		GregorianCalendar gc1 = new GregorianCalendar();
		gc1.setTime(date1);
		XMLGregorianCalendar endDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
		method.setExpDate(endDate);

		Address address = new Address();
		address.setStreet("west street");
		address.setCity("irving");
		address.setState("TX");
		address.setZipCode(75039);

		Date date2 = spf.parse("01/01/2021");
		GregorianCalendar gc2 = new GregorianCalendar();
		gc2.setTime(date2);
		XMLGregorianCalendar dob = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);

		Customer customer = new Customer();
		customer.setCustomerId(1);
		customer.setName("justin");
		customer.setDataOfBirth(dob);
		customer.setAddress(address);
		customer.setAnualSalary(1200000);
		customer.getPaymentMethod().add(method);
		MarshellingAndUnMarshelling marshellingAndUnMarshelling = new MarshellingAndUnMarshelling();

		System.out.println("Marshalling");
		marshellingAndUnMarshelling.marshall(customer);
		System.out.println();
		System.out.println("Unmarshalling");
		marshellingAndUnMarshelling.unmarshall();

	}
}
