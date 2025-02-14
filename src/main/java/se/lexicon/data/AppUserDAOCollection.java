package se.lexicon.data;

import se.lexicon.AppUser;

import java.util.Collection;
import java.util.HashSet;

public class AppUserDAOCollection implements AppUserDAO{

    HashSet<AppUser> appUserCollection = new HashSet<>();

    @Override
    public AppUser persist(AppUser appUser) {
        appUserCollection.add(appUser);
        return appUser;
    }

    @Override
    public AppUser findByUsername(String username) {
        for (AppUser appUser : appUserCollection) {
            if (appUser.getUsername().equals(username)) {
                return appUser;
            }
        }
        return null;
    }

    @Override
    public Collection<AppUser> findAll() {
        return new HashSet<AppUser>(appUserCollection);
    }

    @Override
    public void remove(String username) {
        for (AppUser appUser : appUserCollection) {
            if (appUser.getUsername().equals(username)) {
                appUserCollection.remove(appUser);
            }
        }
    }
}
