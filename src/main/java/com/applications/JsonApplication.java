package com.applications;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.suresh.Address;
import com.suresh.Customer;
import com.suresh.PaymentMethod;

public class JsonApplication {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException,
			ParseException, DatatypeConfigurationException {

		PaymentMethod method = new PaymentMethod();
		method.setCardName("AMEX");
		method.setCardNumber(12345678);

		SimpleDateFormat spf = new SimpleDateFormat("MM/dd/yyyy");
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

		JsonSerializatonAndDeSerialization json = new JsonSerializatonAndDeSerialization();
		System.out.println("*************Serialize****************");
		json.serialize(customer);

		System.out.println("*************DeSerialize****************");
		json.deserialize(customer);

	}

}
