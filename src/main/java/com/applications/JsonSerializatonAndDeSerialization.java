package com.applications;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.suresh.Customer;

public class JsonSerializatonAndDeSerialization {

	public void serialize(Customer customer) throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		// convert Object to json string

		// configure Object mapper for pretty print
		objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

		// writing to console, can write to any output stream such as file
		objectMapper.writeValue(System.out, customer);
		objectMapper.writeValue(new PrintWriter("customer.json"), customer);
	}

	public void deserialize(Customer customer) throws IOException {

		// read json file data to String
		byte[] jsonData = Files.readAllBytes(Paths.get("customer.json"));

		// create ObjectMapper instance
		ObjectMapper objectMapper = new ObjectMapper();

		// convert json string to object
		Customer customer1 = objectMapper.readValue(jsonData, Customer.class);

		System.out.println("Employee Object\n" + customer1);
	}

}
