package com.amazonaws.test;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

public class LamdaClientTest {
	public static void main(String[] args) {
		S3Object imageObject=null;
	    Regions clientRegion = Regions.AP_SOUTH_1;
	    String bucketName = "chandulamdatest";
	    String key = "IMG-20180605-WA0008.jpg";
	    AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
	            .withRegion(clientRegion)
	            .build();
	    Regions region = Regions.AP_SOUTH_1;
	   // AWSLambdaClient awsLambda = new AWSLambdaClient();
	    imageObject = s3Client.getObject(new GetObjectRequest(bucketName, key));
	}
	
}
