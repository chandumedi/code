package com.amazonaws.lambda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

public class LambdaFunctionHandler implements RequestHandler<Object, String> {

    @Override
    public String handleRequest(Object input, Context context) {
        context.getLogger().log("Input: " + input);
        S3Object imageObject=null;
        Regions clientRegion = Regions.AP_SOUTH_1;
        String bucketName = "chandulamdatest";
        String key = "IMG-20180605-WA0008.jpg";
        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                .withRegion(clientRegion)
                .build();
        imageObject = s3Client.getObject(new GetObjectRequest(bucketName, key));
        System.out.println("Content-Type: " + imageObject.getObjectMetadata().getContentType());
        System.out.println("Content: ");
        try {
			displayTextInputStream(imageObject.getObjectContent());
		} catch (IOException e) {
			e.printStackTrace();
		}
        return "Image successfully copied from S3 storage!";
    }

    private static void displayTextInputStream(InputStream input) throws IOException {
        // Read the text input stream one line at a time and display each line.
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        String line = null;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        System.out.println();
    }
}
