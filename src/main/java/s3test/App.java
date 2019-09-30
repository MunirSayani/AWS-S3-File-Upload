package s3test;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

import java.io.File;

public class App 
{
    public static void main( String[] args )
    {
        String bucketName = "my-new-bucket-test-1";

        // In this example, the bucket is located in US_EAST_2 region, default region is Regions.DEFAULT_REGION
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_2).build();

        try {
            s3.putObject(bucketName, "test file", new File("test.jpg"));
        } catch (AmazonServiceException e) {
            System.err.println(e.getErrorMessage());
            System.exit(1);
        }
    }
}
