package com.dijuda.socialneighbors.modelUtils;

import java.util.HashMap;
import java.util.Iterator;

import com.dijuda.socialneighbors.social.User;

/**
 * Saves the user instances for future references. We need this instances because they
 * are the ones with the token to communicate with the API
 *
 * We use a refId as a key for getting and removing the users from this cache.
 * This refId should be either the username, or maybe, in future sprints, the Id of the tab associated for that user
 *
 * Singleton so we can get this cache from anywhere in the program
 */
public class UserCache {

    private static UserCache instance;

    private HashMap<String, User> hashmap;

    private UserCache(){
        //Singleton
        hashmap = new HashMap<>();
    }

    /*
     * Gets the UserCache for additions and removals of Users in it
     * @return active instance of UserCache
     */
    public static UserCache getInstance(){
        if(instance == null){
            instance = new UserCache();
        }
        return instance;
    }

    /*
     * Gets user from the cache with its refId
     * @param refId The reference Id to be get from the cache
     * @return User The user item associated with this refId
     */
    public User getUser(String refId){
        return hashmap.get(refId);
    }

    /*
     * Saves a user in the cache with the specified refId
     * @param refId The reference Id we are using to save this user
     * @param user The user to be saved
     */
    public void saveUser(String refId, User user){
        hashmap.put(refId, user);
    }

    /*
     * Removes a user from the cache. This should be used only when the user logs off
     * @param refId The reference Id for the user to be removed
     */
    public void removeUser(String refId){
        hashmap.remove(refId);
    }
}
