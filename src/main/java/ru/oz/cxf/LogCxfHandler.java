package ru.oz.cxf;

import com.ctc.wstx.exc.WstxParsingException;
import org.apache.cxf.jaxws.handler.logical.LogicalMessageContextImpl;
import org.apache.cxf.message.Message;
import org.apache.log4j.Logger;
import ru.oz.srpingaop.MessageType;
import ru.oz.srpingaop.TechnicalLogging;

import javax.xml.ws.handler.LogicalHandler;
import javax.xml.ws.handler.LogicalMessageContext;
import javax.xml.ws.handler.MessageContext;
import java.io.InputStream;

/**
 * Created by ozol on 04.08.2015.
 */
public class LogCxfHandler implements LogicalHandler<LogicalMessageContext> {
    Logger LOG = Logger.getLogger(LogCxfHandler.class);

    public boolean handleMessage(LogicalMessageContext context) {
//        LOG.info("call came handleMessage");
//
//        InputStream is = context.getMessage()..getContent(InputStream.class);
//        if (is != null) {
//            CachedOutputStream bos = new CachedOutputStream();
//
//        try {
//            cs.flush();
//            CachedOutputStream csnew = (CachedOutputStream) message.getContent(OutputStream.class);
//
//            String soapMessage = IOUtils.toString(csnew.getInputStream());

        return true;
    }

    @TechnicalLogging(messageType = MessageType.Text)
    public boolean handleFault(LogicalMessageContext context) {
        Message message = ((LogicalMessageContextImpl) context).getWrappedMessage();

        Exception ex = message.getContent(Exception.class);
        if (ex.getCause() instanceof WstxParsingException) {
            LOG.error("Парсинг эксепшн!");
        } else {
            LOG.error("Эксепшн!");
        }

        if (ex != null) {
            LOG.info("call came handleFault : " + message.getContent(Exception.class).getMessage());
        }
        return true;
    }

    public void close(MessageContext context) {
        LOG.info("call came close");
    }
}
