import org.junit.Assert;
import org.junit.jupiter.api.Test;

class MessagingAppTest {
    @Test
    public void testAuthenticate() {
        String[][] testData = {
                {"john", "password123", "1234567890"},
                {"jane", "password456", "9876543210"},
                {"invalid", "invalid", "invalid"}
        };

        for (String[] data : testData) {
            String username = data[0];
            String password = data[1];
            String phoneNumber = data[2];
            if (username.equals("john") || username.equals("jane")) {
                Assert.assertEquals(true, MessagingApp.authenticate(username, password, phoneNumber));
            } else {
                Assert.assertEquals(false, MessagingApp.authenticate(username, password, phoneNumber));
            }
        }
    }

    @Test
    public void testSendMessage() {
        String[][] testData = {
                {"john", "jane", "Hello, Jane!", "true"},
                {"john", "jane", "This message is too long and should not be sent.", "false"},
                {"invalid", "jane", "Hello, Jane!", "false"}
        };

        for (String[] data : testData) {
            String sender = data[0];
            String recipient = data[1];
            String message = data[2];
            String expected = data[3];

        }
    }
}

