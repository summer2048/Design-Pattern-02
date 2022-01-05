import java.util.ArrayList;
import java.util.Random;

public abstract class InsaneProtocol implements Protocol {
	ArrayList<Key> keyList = new ArrayList<Key>();

	public void addKey(Key key){
		keyList.add(key);
	}
    public void removeKey(int idx){
		keyList.remove(idx);
	}

	public Key getRandomKey(){
		return keyList.get(new Random().nextInt(keyList.size()));
	}
}
