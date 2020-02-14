package lab.aws.sqs;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;

import java.util.EnumSet;

public class LinkS3ToSNS {


    static String bucketName = "abhijit-test-bucket-1";
    static Regions clientRegion = Regions.US_EAST_2;
    static String snsTopicARN = "arn:aws:sns:us-east-2:156108990704:abhijit-test-topic-1";
    static String sqsQueueARN = "abhijit-test-queue-1";

    public static void main(String[] args) {
        try {
            AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                    .withCredentials(new ProfileCredentialsProvider())
                    .withRegion(clientRegion)
                    .build();

            BucketNotificationConfiguration notificationConfiguration = new BucketNotificationConfiguration();

            // Add an SNS topic notification.
            notificationConfiguration.addConfiguration("snsTopicConfig",
                    new TopicConfiguration(snsTopicARN, EnumSet.of(S3Event.ObjectCreatedByPut)));

//        // Add an SQS queue notification.
//        notificationConfiguration.addConfiguration("sqsQueueConfig",
//                new QueueConfiguration(sqsQueueARN, EnumSet.of(S3Event.ObjectCreated)));

            // Create the notification configuration request and set the bucket notification configuration.
            SetBucketNotificationConfigurationRequest request = new SetBucketNotificationConfigurationRequest(
                    bucketName, notificationConfiguration);
            s3Client.setBucketNotificationConfiguration(request);
        } catch (AmazonServiceException e) {
            // The call was transmitted successfully, but Amazon S3 couldn't process
            // it, so it returned an error response.
            e.printStackTrace();
        } catch (SdkClientException e) {
            // Amazon S3 couldn't be contacted for a response, or the client
            // couldn't parse the response from Amazon S3.
            e.printStackTrace();
        }

    }
}
