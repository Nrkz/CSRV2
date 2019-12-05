package org.inria.restlet.database.api;

import java.util.Collection;
import java.util.List;

import org.inria.restlet.backend.Buffet;
import org.inria.restlet.backend.Client;

/**
 *
 * Interface to the database.
 *
 * @author msimonin
 *
 */
public interface Database
{
	//On r�cup�re les deux Objets qui nous int�resse.
    Client getClient(int id);
    
    Buffet getBuffet();

}
