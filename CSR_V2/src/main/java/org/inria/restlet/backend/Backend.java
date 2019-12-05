package org.inria.restlet.backend;

import org.inria.restlet.database.api.Database;
import org.inria.restlet.database.api.impl.Restaurant;

/**
 *
 * Backend for all resources.
 * 
 * @author ctedeschi
 * @author msimonin
 *
 */
public class Backend
{
    /** Database.*/
    private Database database_;

    public Backend(Restaurant restau)
    {
        database_ = restau;
    }

    public Database getDatabase()
    {
        return database_;
    }

}
