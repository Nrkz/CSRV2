package org.inria.restlet.mta.database.api;

import java.util.Collection;
import java.util.List;

import org.inria.restlet.mta.backend.Buffet;
import org.inria.restlet.mta.backend.Client;
import org.inria.restlet.mta.internals.Tweet;
import org.inria.restlet.mta.internals.User;

/**
 *
 * Interface to the database.
 *
 * @author msimonin
 *
 */
public interface Database
{

    /**
     *
     * Create a new user in the database.
     *
     * @param name      The name of the user
     * @param age       The age of the user
     * @return  the new user.
     */
    Client createClient(String name, int age);


    /**
     *
     * Returns the list of users.
     *
     * @return the list of users
     */
    Collection<Client> getClient();


    /**
     *  Returns the user with a given id.
     *
     *  @return the user
     */
    Client getClient(int id);
    
    Buffet getBuffet(int id);

}
