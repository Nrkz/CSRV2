package org.inria.restlet.mta.resources;

import org.inria.restlet.mta.backend.Backend;
import org.inria.restlet.mta.internals.Tweet;
import org.json.JSONObject;
import org.inria.restlet.mta.database.api.impl.*;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

/**
 *
 * Resource exposing a user.
 *
 * @author msimonin
 * @author ctedeschi
 *
 */
public class TweetsRessource extends ServerResource
{

    /** Backend.*/
    private Backend backend_;

    /** Utilisateur g�r� par cette resource.*/
    private Tweet tweet_;

    /**
     * Constructor.
     * Call for every tweets request.
     */
    public TweetsRessource()
    {
        backend_ = (Backend) getApplication().getContext().getAttributes()
                .get("backend");
    }


    @Get("json")
    public Representation getTweet() throws Exception
    {
        String tweetIdString = (String) getRequest().getAttributes().get("tweetId");
        int tweetId = Integer.valueOf(tweetIdString);
        tweet_ = backend_.getDatabase().getTweet(tweetId);

        JSONObject tweetObject = new JSONObject();
        tweetObject.put("content", tweet_.getContent());
        tweetObject.put("id", tweet_.getId());

        return new JsonRepresentation(tweetObject);
    }

}