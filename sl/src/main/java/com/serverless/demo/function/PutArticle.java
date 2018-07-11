package com.serverless.demo.function;


import com.amazonaws.regions.Regions;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;

import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.spec.PutItemSpec;
import com.amazonaws.services.dynamodbv2.model.ConditionalCheckFailedException;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import com.serverless.dto.Student;

public class PutArticle implements RequestHandler<Student, String> {
	private DynamoDB dynamoDb;
	private static String DYNAMO_DB_TABLE_NAME = "STUDENT_DETAILS";
	private Regions REGION = Regions.AP_SOUTH_1;

	@Override
	public String handleRequest(Student student, Context arg1) {
		this.initDynamoDbClient();
		persistData(student);
		return "Student saved succesfully!";
	}

	private void initDynamoDbClient() {
		AmazonDynamoDBClient client = new AmazonDynamoDBClient();
		client.withRegion(REGION);
		this.dynamoDb = new DynamoDB(client);

	}

	private PutItemOutcome persistData(Student student) 
		      throws ConditionalCheckFailedException {
		        return this.dynamoDb.getTable(DYNAMO_DB_TABLE_NAME)
		          .putItem(
		            new PutItemSpec().withItem(new Item()
		              .withInt("STUDENT_ID",2)
		            .withString("STUDENT_NAME","NARESH")
		          .withString("STUDENT_ADDRESS","NARESH")));
		            
	}
}