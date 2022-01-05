public class Cerebus extends InsaneProtocol {
	static InsaneProtocol instance;
    private static final int CEREBUS_INIT_VALUE = 32;
	private static final int CEREBUS_ALPH_SIZE = 128;
    public String encrypt(Key am, String in) {
		Integer[] key = am.getKey();
		StringBuilder out = new StringBuilder();
		String use = in.toLowerCase();
		for(char a : use.toCharArray()) {
			out.append((char)(((a + key[0] - CEREBUS_INIT_VALUE) % CEREBUS_ALPH_SIZE) + CEREBUS_INIT_VALUE)+"");
		}
		return out.toString();
	}

    public String decrypt(Key am, String in) {
		Integer[] key = am.getKey();
		StringBuilder out = new StringBuilder();
		String use = in.toLowerCase();
		for(char a : use.toCharArray()) {
			out.append((char)(((a - key[0]  - CEREBUS_INIT_VALUE + CEREBUS_ALPH_SIZE) % CEREBUS_ALPH_SIZE) + CEREBUS_INIT_VALUE)+"");
		}
		return out.toString();
	}

	private Cerebus(){
		Integer[] am = new Integer[1];
		am[0] = 18;
		Key key = new Key(am);
		keyList.add(key);
	}

	public static InsaneProtocol getInstance(){
		if (instance == null) instance = new Cerebus();
		return instance;
	}
}
