public class Runner {
    public static void main(String[] args){
        CAI cai = new CAI();
        Integer[] key1 = new Integer[1];
        key1[0] = 31;

        System.out.println("\nTest add key here:");
        cai.addKey(0, new Key(key1));
        System.out.println("Encrypt 'Hello world!' and send it to the first security site: " + cai.sendMessage("Hello world!", 0, 0));
        cai.simulate();
        System.out.println("Simulate (reset key) and resend encrypted string: " + cai.sendMessage("Hello world!", 0, 0));
        cai.simulate();
        System.out.println("Simulate (reset key) and resend encrypted string: " + cai.sendMessage("Hello world!", 0, 0));
    
        
        InsaneProtocol ouroboros = Ouroboros.getInstance();
        Integer[] key2 = new Integer[4];
        key2[0] = 3;
        key2[1] = 1;
        key2[2] = 0;
        key2[3] = 2;
        ouroboros.addKey(new Key(key2));
        Integer[] key3 = new Integer[6];
        key3[0] = 2;
        key3[1] = 5;
        key3[2] = 4;
        key3[3] = 1;
        key3[4] = 3;
        key3[5] = 0;
        ouroboros.addKey(new Key(key3));
        cai.addProtocal(ouroboros);
        System.out.println("\nTest add protocol here:");
        System.out.println("Encrypt 'Hello world!' and send it to the first security site: " + cai.sendMessage("Hello world!", 0, 1));
        cai.simulate();
        System.out.println("Simulate (reset key) and resend encrypted string: " + cai.sendMessage("Hello world!", 0, 1));
        cai.simulate();
        System.out.println("Simulate (reset key) and resend encrypted string: " + cai.sendMessage("Hello world!", 0, 1));
    
        System.out.println("\nTest add site here:");
        SecuritySite newSite = new InsaneSecuritySite();
        try {
            System.out.println("Try send massage to the second site.");
            System.out.println(cai.sendMessage("Hello world!", 1, 1));
        } catch (Exception e) {
            System.out.println("But there is not second site.");
        }
        cai.addSite(newSite);
        System.out.println("Add site, then send massage again to the second site.");
        System.out.println(cai.sendMessage("Hello world!", 1, 1));

        System.out.println("Test remove here:");
        cai.removeKey(0);
        cai.removeSite(0);
        System.out.println("Remove a site and a key, then send massage again to the first site.");
        System.out.println(cai.sendMessage("Hello world!", 0, 0));
        System.out.println("Add a key, remove a protocol, then send massage again to the first site.");
        cai.addKey(0, new Key(key1));
        cai.removeProtocol(0);
        System.out.println(cai.sendMessage("Hello world!", 0, 0));

    }
}
