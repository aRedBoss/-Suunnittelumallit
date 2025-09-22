package proxy;

import java.util.HashMap;
import java.util.HashSet;

public class AccessControlService {
    private static AccessControlService instance;
    private HashMap<String, HashSet<String>> permissions;

    private AccessControlService() {
        permissions = new HashMap<>();
    }

    public static AccessControlService getInstance() {
        if (instance == null) {
            instance = new AccessControlService();
        }
        return instance;
    }

    public void allow(String docId, String username) {
        permissions.putIfAbsent(docId, new HashSet<>());
        permissions.get(docId).add(username);
    }

    public boolean isAllowed(String docId, String username) {
        return permissions.containsKey(docId) && permissions.get(docId).contains(username);
    }
}

