import java.util.ArrayList;

public class InsaneSecuritySite implements SecuritySite{
    ArrayList<Key> keyList = new ArrayList<Key>();
    public void updateKeys(ArrayList<Key> keyList){
        this.keyList = keyList;
    }

    public void addProtocal(Key key){
        keyList.add(key);
    }

    public void removeProtocal(int idx){
        keyList.remove(idx);
    }

    @Override
    public Key getKey(int idx) {
        return keyList.get(idx);
    }
}
