public interface Protocol {
    public String encrypt(Key key, String in);
    public String decrypt(Key key, String in);
    public Key getRandomKey();
    public void addKey(Key key);
    public void removeKey(int idx);
}
