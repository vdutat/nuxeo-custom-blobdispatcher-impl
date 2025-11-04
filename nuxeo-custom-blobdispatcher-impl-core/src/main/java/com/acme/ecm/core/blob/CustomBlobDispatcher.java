package com.acme.ecm.core.blob;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.nuxeo.ecm.core.api.Blob;
import org.nuxeo.ecm.core.api.model.PropertyNotFoundException;
import org.nuxeo.ecm.core.blob.DefaultBlobDispatcher;
import org.nuxeo.ecm.core.model.Document;

public class CustomBlobDispatcher extends DefaultBlobDispatcher {

    private static final Logger log = LogManager.getLogger(CustomBlobDispatcher.class);

    @Override
    protected Object getValue(Document doc, Blob blob, String blobXPath, Clause clause) {
        log.debug("<getValue> [{}]", clause.xpath);
        try {
            return super.getValue(doc, blob, blobXPath, clause);
        } catch (PropertyNotFoundException e) {
            if ("ecm:currentLifeCycleState".equals(clause.xpath)) {
                String lifeCycleState = doc.getLifeCycleState();
                log.debug("<getValue> value of [{}]: [{}]", clause.xpath, lifeCycleState);
                return lifeCycleState;
            } else {
                if (log.isDebugEnabled()) {
                    log.error(e, e);
                }
                throw e;
            }
        }
    }

}
