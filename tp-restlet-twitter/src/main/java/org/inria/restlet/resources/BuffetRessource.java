package org.inria.restlet.resources;

import org.inria.restlet.backend.Backend;
import org.inria.restlet.backend.Buffet;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class BuffetRessource extends ServerResource
{

    /** Backend.*/
    private Backend backend_;

    /** Utilisateur g�r� par cette resource.*/
    private Buffet buffet_;

    /**
     * Constructor.
     * Call for every buffets request.
     */
    public BuffetRessource()
    {
        backend_ = (Backend) getApplication().getContext().getAttributes()
                .get("backend");
    }


    @Get("json")
    public Representation getbuffet() throws Exception
    {
        buffet_ = backend_.getDatabase().getBuffet();

        JSONObject buffetObject = new JSONObject();
        buffetObject.put("qtepoisson", buffet_.getPoisson());
        buffetObject.put("qteviande", buffet_.getViande());
        buffetObject.put("qtelegumes", buffet_.getLegume());
        buffetObject.put("qtenouilles", buffet_.getNouille());

        return new JsonRepresentation(buffetObject);
    }
}
