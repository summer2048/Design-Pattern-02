import java.util.ArrayList;

public class CAI {
    ArrayList<SecuritySite> sites = new ArrayList<SecuritySite>();
    ArrayList<InsaneProtocol> protocols = new ArrayList<InsaneProtocol>();

    public void simulate() {
        for (int j = 0; j < sites.size(); j++) {
            ArrayList<Key> keylist = new ArrayList<Key>();
            for (int i = 0; i < protocols.size(); i++) {
                keylist.add(protocols.get(i).getRandomKey());
            }
            sites.get(j).updateKeys(keylist);
        }
    }

    public void addKey(int idx, Key key) {
        protocols.get(idx).addKey(key);
    }

    public void removeKey(int idx) {
        for (int i = 0; i < protocols.size(); i++){
            protocols.get(i).removeKey(idx);
        }
        simulate();
    }

    public void addProtocal(InsaneProtocol protocol) {
        protocols.add(protocol);
        for (int i = 0; i < sites.size(); i++) {
            sites.get(i).addProtocal(protocol.getRandomKey());
        }
    }

    public void removeProtocol(int idx) {
        protocols.remove(idx);
        for (int i = 0; i < sites.size(); i++) {
            sites.get(i).removeProtocal(idx);
        }
        simulate();
    }

    public void addSite(SecuritySite securitySite) {
        sites.add(securitySite);
        ArrayList<Key> keylist = new ArrayList<Key>();
        for (int i = 0; i < protocols.size(); i++) {
            keylist.add(protocols.get(i).getRandomKey());
        }
        securitySite.updateKeys(keylist);
    }

    public void removeSite(int idx) {
        sites.remove(idx);
        simulate();
    }

    public CAI(){
        protocols.add(Cerebus.getInstance());
        sites.add(new InsaneSecuritySite());
        simulate();
    }

    public String sendMessage(String in, int site, int protocol){
        return protocols.get(protocol).encrypt(sites.get(site).getKey(protocol), in);
    }
}
