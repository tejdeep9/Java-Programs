import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Regex
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Pattern pattern = Pattern.compile("regex");
		Matcher m = pattern.matcher("regexpression");
		
		while(m.find()) {
			System.out.println(m.start() + "," + (m.end()-1)); //0, 4
		}
		
		//******************************* Literals and Special Characters *************************************************************************************
		
		//meta characters are \, +, ., *, (, ), {, ^, $, ?, [ { these characters have special meaning.
		//If you want to use any of these characters as a literal in a regex, you need to escape them with a backslash, 
		//In java strings use another backslash to consider \+ as literal.
		pattern = pattern.compile("1\\+1=2");
		m = pattern.matcher("1+1=2");
		System.out.println(m.find()); //true
		//to match c:\temp the regex should be c:\\temp and in the java the regex string will be c:\\\\temp, the compiler will interpret \\ as \
		
		
		//1+1=2 is also a valid regex it matches 111 in  "323+111=234" string.
		pattern = pattern.compile("1+1=2");
		m = pattern.matcher("1+1=2");
		System.out.println(m.find()); //false
		m = pattern.matcher("323+111=234");
		System.out.println(m.find()); //true
		
		//All the characters between the \Q and the \E are interpreted as literal characters.
		//"\Q*\d+*\E" can be matched with "*\d+*"
		pattern = pattern.compile("\\Q*\\d+*\\E");
		m = pattern.matcher("*\\d+*");
		System.out.println(m.find()); //true
		
		
		//******************************* Non printable Characters *************************************************************************************
		//You can use special character sequences to put non-printable characters in your regular expression. Use \t to match a tab character (ASCII 0x09), \r for carriage return (0x0D) and \n for line feed (0x0A).
		//Remember that Windows text files use \r\n to terminate lines, while UNIX text files use \n.
		
		//******************************* Overview of Regex Engines ************************************************************************************
		/*
		A regex-directed engine walks through the regex, attempting to match the next token in the regex to the next character. 
		If a match is found, the engine advances through the regex and the subject string. 
		If a token fails to match, the engine backtracks to a previous position in the regex and the subject string where it can try a different path through the regex.
		a regex engine always returns the leftmost match, even if a "better" match could be found later. 
		When applying a regex to a string, the engine starts at the first character of the string. 
		It tries all possible permutations of the regular expression at the first character. 
		Only if all possibilities have been tried and found to fail, does the engine continue with the second character in the text. 
		Again, it tries all possible permutations of the regex, in exactly the same order. 
		The result is that the regex engine returns the leftmost match. 
		*/
		
		//******************************* Characters Sets *************************************************************************************
		//[ae]. You could use this in gr[ae]y to match either gray or grey.
		pattern = pattern.compile("gr[ae]y");
		m = pattern.matcher("grey gray");
		while(m.find()) {
			System.out.println(m.start() + "," + (m.end()-1)); //{0,3} {5,8}
		}
		/*
		[0-9] matches a single digit between 0 and 9. You can use more than one range. [0-9a-fA-F] matches a single hexadecimal digit, case insensitively. 
		You can combine ranges and single characters. [0-9a-fxA-FX] matches a hexadecimal digit or the letter X. Again, the order of the characters and the ranges does not matter. 
		You can find a word, even if it is misspelled, such as sep[ae]r[ae]te or li[cs]en[cs]e. You can find an identifier in a programming language with [A-Za-z_][A-Za-z_0-9]*. 
		You can find a C-style hexadecimal number with 0[xX][A-Fa-f0-9]+.
		*/
		pattern = pattern.compile("0[xX][A-Fa-f0-9]+");
		m = pattern.matcher("0x6400");
		System.out.println(m.find()); //true
		/* negated character classes also match (invisible) line break characters. [^0-9\r\n] matches any character that is not a digit or a line break and [~0-9\n] for Unix.
		q[^u] does not mean: "a q not followed by a u". It means: "a q followed by a character that is not a u". It does not match the q in the string Iraq. 
		It does match the q and the space after the q in Iraq is a country. */
		pattern = pattern.compile("q[^u]");
		m = pattern.matcher("iraq");
		System.out.println(m.find()); //false
		m = pattern.matcher("iraq is country");
		System.out.println(m.find()); //true
		/* In most regex flavors, the only special characters or metacharacters inside a character class are the closing bracket ], the backslash \, the caret ^, and the hyphen -.
		To search for a star or plus, use [+*]. Your regex will work fine if you escape the regular metacharacters inside a character class
		*/
		pattern = pattern.compile("a[+*]b");
		m = pattern.matcher("ira+bcd");
		System.out.println(m.find()); //true
		/*
		To include a backslash as a character without any special meaning inside a character class, you have to escape it with another backslash. [\\x] matches a backslash or an x. 
		The closing bracket ], the caret ^ and the hyphen - can be included by escaping them with a backslash. 
		[x^] matches an x or a caret. []x] matches a closing bracket or an x. [^]x] matches any character that is not a closing bracket or an x. 
		Both [-x] and [x-] match an x or a hyphen. [^-x] and [^x-] match any character thas is not an x or a hyphen. 
		Hyphens at other positions in character classes where they can't form a range may be interpreted as literals or as errors. 
		[$\u20AC] matches a dollar or euro 
		*/
		pattern = pattern.compile("a[y-]b");
		m = pattern.matcher("ira-bcd");
		System.out.println(m.find()); //true
		
		//******************************* Characters Class Intersection *************************************************************************************
		//The character class [a-z&&[^aeiuo]] matches a single letter that is not a vowel. In other words: it matches a single consonant. 
		pattern = Pattern.compile("[a-z&&[^aeiou]]+");
		m = pattern.matcher("own"); 
		while(m.find()) {
			System.out.println(m.start() + "," + (m.end()-1)); // 1,2
		}
		/*
		If the intersected class does not need a negating caret, then Java and Ruby allow you to omit the nested square brackets: [class&&intersect].
		[0-9&&[0-6&&[4-9]]] is the same as [4-6] [0-9&&[0-6]&&[4-9]], [0-9&&[0-6&&4-9]], [0-9&&0-6&&[4-9]], or just [0-9&&0-6&&4-9]. 
		The nested square brackets are only needed if one of the parts of the intersection is negated. 
		[0-9&&] and [&&0-9] as intersections with an empty class, which matches no characters at all.Java ignores leading and trailing && operators. 
		The character class [^1234&&[3456]] is both negated and intersected.ava and PowerGREP read this regex as "(not 1234) and 3456". Thus in Java this class is the same as [56] and matches the digits 5 and 6.
		If you want to negate the right hand side of the intersection, then you must use square brackets. So Java all read [1234&&[^3456]] as "1234 and (not 3456)". Thus this regex is the same as [12].
		*/
		pattern = Pattern.compile("[^1234&&[3456]]");
		m = pattern.matcher("123456780"); 
		while(m.find()) {
			System.out.println(m.start() + "," + (m.end()-1)); // 4,5,8, 0
		}
		//*******************************Shorthand Character Classes *************************************************************************************
		/* 
		 \d is short for [0-9]. \w stands for "word character". It always matches the ASCII characters [A-Za-z0-9_]. 
		 Notice the inclusion of the underscore and digits.  Java, JavaScript, and PCRE match only ASCII characters with \w.
		 \s stands for "whitespace character". it includes [ \t\r\n\f].  
		 \s\d matches a whitespace character followed by a digit.  \s\d matches a whitespace character followed by a digit.
		 */
		pattern = Pattern.compile("\\s\\d");
		m = pattern.matcher("1 + 2 = 3"); 
		while(m.find()) {
			System.out.println(m.start() + "," + (m.end()-1)); // {3,4} {7,8}		} 
		}
		/*
		The above three shorthands also have negated versions. \D is the same as [^\d], \W is short for [^\w] and \S is the equivalent of [^\s].
		\h matches horizontal whitespace, which includes the tab and all characters in the "space separator" Unicode category.
		\v matches "vertical whitespace", which includes all characters treated as line breaks in the Unicode standard.
		Be careful when using the negated shorthands inside square brackets. [\D\S] is not the same as [^\d\s]. The latter matches any character that is neither a digit nor whitespace. It matches x, but not 8. 
		The former, however, matches any character that is either not a digit, or is not whitespace. 
		Because all digits are not whitespace, and all whitespace characters are not digits, [\D\S] matches any character; digit, whitespace, or otherwise.
		*/
	}
}