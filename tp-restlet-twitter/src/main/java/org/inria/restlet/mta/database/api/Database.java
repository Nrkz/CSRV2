package org.inria.restlet.mta.database.api;

import java.util.Collection;
import java.util.List;

import org.inria.restlet.mta.backend.Buffet;
import org.inria.restlet.mta.backend.Client;

/**
 *
 * Interface to the database.
 *
 * @author msimonin
 *
 */
public interface Database
{
    Client getClient(int id);
    
    Buffet getBuffet();

}
