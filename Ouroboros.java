public class Ouroboros extends InsaneProtocol {
	static InsaneProtocol instance;
    public String encrypt(Key key, String in) {
		Integer[] am = key.getKey();
		StringBuilder out = new StringBuilder();
		String use = in + new String(new char[am.length - (in.length() % am.length)]).replace("\0", " ");
		for(int i = 0; i < use.length(); i += am.length) {
			char[] next = new char[am.length];
			for(int j = 0; j < am.length; j++) {
				next[j] = use.charAt(i + am[j]);
			}
			out.append(new String(next));
		}
		return out.toString();
	}

    public String decrypt(Key key, String in) {
		Integer[] am = key.getKey();
		StringBuilder out = new StringBuilder();
		String use = in + "";
		for(int i = 0; i < use.length(); i += am.length) {
			char[] next = new char[am.length];
			for(int j = 0; j < am.length; j++) {
				next[am[j]] = use.charAt(i + j);
			}
			out.append(new String(next));
		}
		return out.toString();
	}

	private Ouroboros(){
		
	}

	public static InsaneProtocol getInstance(){
		if (instance == null) instance = new Ouroboros();
		return instance;
	}
}
