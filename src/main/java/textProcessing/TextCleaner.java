package textProcessing;

public interface TextCleaner {
	public String clean(String in);
	static String unknownChars  = "\\.:,'@#$%^&*()\"}{></";
	static String space  = "\\s";
	public static TextCleaner defaultTextCleaner = new TextCleaner() {
		
		public String clean(String in) {
			String res = in.toLowerCase();
			res = res.replaceAll("["+unknownChars+"]", "");
			return res;
		}
	};
	
	public static TextCleaner smallTextCleaner = new TextCleaner() {
		
		public String clean(String in) {
			String res = in.toLowerCase();
			res = res.replaceAll("["
//			+unknownChars
			+space+"]", "");
			return res;
		}
	};

}
