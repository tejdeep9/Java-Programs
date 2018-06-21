import java.util.regex.Matcher;
import java.util.regex.Pattern;

// does not yet take care of the collapsing two or more consecutive zero regions, at most one such collapse in the string.
public class RegexIPV6 {

    private static final String REGEX_HEX = "::|::1|((\\d|a|b|c|d|e|f){0,4}:){0,7}(\\d|a|b|c|d|e|f){0,4}";
    // exactly one occurance of "::"
    private static final String REGEX_COLON = "((.)*: (.)*){2,7}";
    private static final String[] someInput = {
	"2001:0db8:85a3:0000:0000:8a2e:0370:7334",
	"0:0:0:0:0:0:0:1",
	"0:0:0:0:0:0:0:0",
	"::1",
	"::",
	"2001:db8:0:0:0:ff00:42:8329",
	"2001:db8::ff00:42:8329",
	"20010db8:85a3:0000:0000:8a2e:0370:7334"
    };
    private static Pattern pattern;
    private static Matcher matcher;


    private static boolean isIPV6Address(String str) {
	//Pattern patternColon = Pattern.compile(REGEX_COLON);
	 Pattern patternHEX = Pattern.compile(REGEX_HEX);
	
	 return (patternHEX.matcher(str).matches());
    }
	     

	
   public static void main( String args[] ) {
      String inputStr;

      for (int i = 0; i < someInput.length; i++) {
	  inputStr = someInput[i];
	  System.out.println("input: " + inputStr + "   is IPV6 address: " + isIPV6Address(inputStr));
      }
   }
}