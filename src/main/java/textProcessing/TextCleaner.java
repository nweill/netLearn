package textProcessing;

public interface TextCleaner {
	public String clean(String in);
	static String unknownChars  = "[\\.:,'@#$%^&*()\"}{></]";
	
	public static TextCleaner defaultTextCleaner = new TextCleaner() {
		
		public String clean(String in) {
			String res = in.toLowerCase();
			res = res.replaceAll(unknownChars, "");
			return res;
		}
	};

}
