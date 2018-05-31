import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Florian Knoll on 31.05.2018.
 */
public class WhitelistTeamJKU {

    public boolean validate(String input) {

        try {

            if (input.length() > 30) {
                throw new IllegalArgumentException("Input too large");
            }

            URL url = new URL(input.toLowerCase());
            String host = url.getHost();
            int port = url.getPort();
            String protocol = url.getProtocol();

            if (protocol.equals("http") || protocol.equals("https")
                    && port == -1 || port == 80) {
                // fine,.. continue
            } else {
                throw new IllegalArgumentException("Type does not mach");
            }

            if (host.equals("www.targetdomain.com")) {
                return true;
            } else {
                throw new IllegalArgumentException("Domain not allowed");
            }

        } catch (MalformedURLException e) {
            //e.printStackTrace();
        }

        throw new IllegalArgumentException();
    }

    public WhitelistTeamJKU(String[] args) {

        validate("http://www.targetdomain.com");
        validate("http://www.targetdomain.com:80");
        validate("https://www.targetdomain.com");

        try {
            validate("http://www.notmydomain.com");
            System.err.println("so wrong");
            throw new IllegalStateException();
        } catch (IllegalArgumentException e) {

        }

        try {
            validate("http://www.notmydomainnotmydomainnotmydomainnotmydomainnotmydomain.com");
            System.err.println("so wrong");
            throw new IllegalStateException();
        } catch (IllegalArgumentException e) {

        }

        try {
            validate("notevenmydomain");
            System.err.print("so wrong");
            throw new IllegalStateException();
        } catch (IllegalArgumentException e) {

        }

        try {
            validate("http://notevenmydomain.com/items.php?id=2");
            System.err.print("so wrong");
            throw new IllegalStateException();
        } catch (IllegalArgumentException e) {

        }


        System.out.print("everything fine");
    }

    public static void main(String[] args) {
        new WhitelistTeamJKU(args);
    }


}
