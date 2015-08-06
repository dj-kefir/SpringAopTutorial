package ru.oz.cxf;

import com.ctc.wstx.exc.WstxParsingException;
import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.io.CacheAndWriteOutputStream;
import org.apache.cxf.io.CachedOutputStream;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.log4j.Logger;

import javax.xml.ws.handler.LogicalMessageContext;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// http://learningviacode.blogspot.ru/2014/01/handlers-and-interceptors-in-cxf-are.html
public class LogInputInterceptor extends AbstractPhaseInterceptor {
    Logger LOG = Logger.getLogger(LogInputInterceptor.class);

    public LogInputInterceptor() {
        super(Phase.RECEIVE);
        //super(Phase.READ);
    }

    @Override
    public void handleMessage(Message message) throws Fault {

        Exception ex = message.getContent(Exception.class);
        if (ex != null) {
            LOG.error("BLLLLLAAAAAAAT'");
        }
//
//        System.out.println("message "+message);
//        message.put(Message.ENCODING, "UTF-8");
//        InputStream is = message.getContent(InputStream.class);
//
//        if (is != null) {
//            CachedOutputStream bos = new CachedOutputStream();
//            try {
//                IOUtils.copy(is, bos);
//                String soapMessage = new String(bos.getBytes());
//                System.out.println("-------------------------------------------");
//                System.out.println("incoming message is " + soapMessage);
//                System.out.println("-------------------------------------------");
//                bos.flush();
////                message.setContent(InputStream.class, is);
////
////                is.close();
////                InputStream inputStream = new ByteArrayInputStream(changeName(soapMessage).getBytes());
////                message.setContent(InputStream.class, inputStream);
//                bos.close();
//            } catch (IOException e) {
//                LOG.error(e);
//            }
//        }
        LOG.info("Сработал In интерцептор!");
    }

//    @Override
//    public boolean handleFault(final LogicalMessageContext context) {
//        LOG.info("call came handleFault");
//        return false;
//    }
}
