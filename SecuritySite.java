import java.util.ArrayList;

public interface SecuritySite {
    public void updateKeys(ArrayList<Key> keyList);
    public void addProtocal(Key key);
    public void removeProtocal(int index);
    public Key getKey(int idx);
}
