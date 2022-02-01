
import java.util.Date;
import java.util.Map;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.CreateTopicRequest;
import com.amazonaws.services.sns.model.CreateTopicResult;
import com.amazonaws.services.sns.model.MessageAttributeValue;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;


public class Shree {

    // AWS credentials -- replace with your credentials
    static String ACCESS_KEY = "AccessKey";
    static String SECRET_KEY = "SecretKey";

    public static void main(String[] args) throws InterruptedException {


  
            // Create a client
            @SuppressWarnings("deprecation")
        AmazonSNSClient service = new AmazonSNSClient(new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY));

            // Create a topic
            CreateTopicRequest createReq = new CreateTopicRequest()
                .withName("MyTopic");
            CreateTopicResult createRes = service.createTopic(createReq);

  /*          for (;;) {

                // Publish to a topic
                PublishRequest publishReq = new PublishRequest()
                    .withTopicArn(createRes.getTopicArn())
                    .withMessage("Example notification sent at " + new Date());
                service.publish(publishReq);

                Thread.sleep(1000);
            } */
            
            final String msg = "Sending through code";
//            final PublishRequest publishRequest = new PublishRequest("arn:aws:sns:us-east-1:118198795607:Insurance-Quote-Requests", msg);
  
            
            final MessageAttributeValue messageAttributeValue = new MessageAttributeValue()
                .withDataType("String")
                .withStringValue("life");
   //          messageAttributes.put(attributeName, messageAttributeValue);

  //          Map<String, MessageAttributeValue> messageAttributes;
            PublishRequest publishRequest = new PublishRequest()
                .withTopicArn("arn:aws:sns:us-east-1:118198795607:Insurance-Quote-Requests")
             //   .withTopicArn("Insurance-Quote-Requests")
                .withMessage("Example notification sent at " + new Date())
   //             .withMessageAttributes(messageAttributes);
                .addMessageAttributesEntry("insurance_type", messageAttributeValue);

            final PublishResult publishResponse = service.publish(publishRequest);

            // Print the MessageId of the message.
            System.out.println("MessageId: " + publishResponse.getMessageId());

            
        }

}
