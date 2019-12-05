package org.inria.restlet.resources;

import org.inria.restlet.backend.Backend;
import org.inria.restlet.backend.Client;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class ClientRessource extends ServerResource
{

    /** Backend.*/
    private Backend backend_;

    /** Utilisateur g�r� par cette resource.*/
    private Client client_;

    /**
     * Constructor.
     * Call for every clients request.
     */
    public ClientRessource()
    {
        backend_ = (Backend) getApplication().getContext().getAttributes()
                .get("backend");
    }


    @Get("json")
    public Representation getclient() throws Exception
    {
        String clientIdString = (String) getRequest().getAttributes().get("clientId");
        int clientId = Integer.valueOf(clientIdString);
        client_ = backend_.getDatabase().getClient(clientId);

        JSONObject clientObject = new JSONObject();
        clientObject.put("etat", client_.getEtat());
        clientObject.put("clientId", client_.getClientID());

        return new JsonRepresentation(clientObject);
    }
}
