package me.emmy.alley.database.profile;

import me.emmy.alley.profile.Profile;

/**
 * @author Remi
 * @project Alley
 * @date 5/22/2024
 */
public interface IProfile {

    /**
     * Saves a profile to the database.
     *
     * @param profile The profile to save.
     */
    void saveProfile(Profile profile);

    /**
     * Loads a profile from the database.
     *
     * @param profile The profile to load.
     */
    void loadProfile(Profile profile);
}
