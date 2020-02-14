package lab.aws.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lab.aws.s3.DownloadObject;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ParseJson {

    public static void main(String jsonStr) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

//        jsonStr = "{\"Records\":[{\"eventVersion\":\"2.1\",\"eventSource\":\"aws:s3\",\"awsRegion\":\"us-east-2\",\"eventTime\":\"2020-02-12T09:25:41.735Z\",\"eventName\":\"ObjectCreated:Put\",\"userIdentity\":{\"principalId\":\"AWS:AIDASIWGSFDYIE2VDNZB4\"},\"requestParameters\":{\"sourceIPAddress\":\"106.51.105.2\"},\"responseElements\":{\"x-amz-request-id\":\"48C7D2F5D15D1E33\",\"x-amz-id-2\":\"4VW/HjZUC3hXWqMyuYSIeiPq7CVnhjPaQMaOkvc3EwzrRMCIxABeLUBpGX3Dmu1OWNXvIu0y6g4UZS8HzHNW2pKwK4ph0++f\"},\"s3\":{\"s3SchemaVersion\":\"1.0\",\"configurationId\":\"PutNotification\",\"bucket\":{\"name\":\"abhijit-test-bucket-1\",\"ownerIdentity\":{\"principalId\":\"AA5HID82HWAI6\"},\"arn\":\"arn:aws:s3:::abhijit-test-bucket-1\"},\"object\":{\"key\":\"abhijit-string-object-1\",\"size\":22,\"eTag\":\"f30a17f3ef851f3f590f71e12d38009c\",\"sequencer\":\"005E43C495781483BF\"}}}]}";
        Map<String, Object> map
                = objectMapper.readValue(jsonStr, new TypeReference<Map<String, Object>>() {
        });
//        map.forEach((k, v) -> System.out.println("Key : " + k + "\nValue " + v));
        List recs = (List) map.get("Records");
        map = (Map<String, Object>) recs.get(0);
//        map.forEach((k, v) -> System.out.println("Key : " + k + "\nValue " + v));
        map = (Map<String, Object>) map.get("s3");
//        map.forEach((k, v) -> System.out.println("Key : " + k + "\nValue " + v));
        Map<String, Object> bucket = (Map<String, Object>) map.get("bucket");
//        bucket.forEach((k, v) -> System.out.println("Key : " + k + "\nValue " + v));
        Map<String, Object> object = (Map<String, Object>) map.get("object");
//        object.forEach((k, v) -> System.out.println("Key : " + k + "\nValue " + v));

        String bucketName = (String) bucket.get("name");
        String keyName = (String) object.get("key");
        System.out.println("Bucket : " + bucketName);
        System.out.println("Key : " + keyName);
        DownloadObject.main(bucketName,keyName);
    }

}
