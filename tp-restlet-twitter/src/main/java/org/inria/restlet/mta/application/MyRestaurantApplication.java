package org.inria.restlet.mta.application;


import org.inria.restlet.mta.resources.BuffetRessource;
import org.inria.restlet.mta.resources.ClientRessource;
import org.restlet.Application;
import org.restlet.Context;
import org.restlet.Restlet;
import org.restlet.routing.Router;

/**
 *
 * Application.
 *
 * @author msimonin
 *
 */
public class MyRestaurantApplication extends Application
{

    public MyRestaurantApplication(Context context)
    {
        super(context);
    }

    @Override
    public Restlet createInboundRoot()
    {
        Router router = new Router(getContext());
        router.attach("/buffet", BuffetRessource.class);
        router.attach("/client/{clientId}", ClientRessource.class);
        return router;
    }
}
