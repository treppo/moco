package com.github.dreamhead.moco.handler;

import com.github.dreamhead.moco.HttpRequest;
import com.github.dreamhead.moco.ResponseHandler;
import com.github.dreamhead.moco.internal.SessionContext;

public abstract class RequestAwareResponseHandler extends AbstractResponseHandler {
    @Override
    public void writeToResponse(SessionContext context) {
        ResponseHandler handler = withRequest(HttpRequest.class.cast(context.getRequest()));
        handler.writeToResponse(context);
    }

    abstract public ResponseHandler withRequest(HttpRequest httpRequest);
}
