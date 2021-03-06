package ru.oz.cxf;

import org.apache.log4j.Logger;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Set;

public class LogSoapHandler implements SOAPHandler<SOAPMessageContext> {
    Logger LOG = Logger.getLogger(LogSoapHandler.class);

    public Set<QName> getHeaders() {
        return Collections.emptySet();
    }

    public boolean handleMessage(SOAPMessageContext context) {

        Boolean outboundProperty = (Boolean)
                context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        if (outboundProperty) {
            LOG.info("ИСХОДЯЩИЙ");
        } else {
            LOG.info("ВХОДЯЩИЙ");
        }
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        try {
            context.getMessage().writeTo(stream);
            String message = new String(stream.toByteArray(), "utf-8");
            LOG.info("message = " + message);

        } catch (SOAPException | IOException e) {
            LOG.error(e);
        }
        return true;
    }

    public boolean handleFault(SOAPMessageContext context) {

        if ((boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY)) { //for requests only
            SOAPBody body = null;
            try {
                SOAPEnvelope msg = context.getMessage().getSOAPPart().getEnvelope(); //get the SOAP Message envelope
                body = msg.getBody();
            } catch (SOAPException e) {
                e.printStackTrace();
            }
            String operationName = body.getChildNodes().item(1).getLocalName();
        }

        LOG.error("Был эксепшн!");
        return true;
    }

    public void close(MessageContext context) {

    }
}
