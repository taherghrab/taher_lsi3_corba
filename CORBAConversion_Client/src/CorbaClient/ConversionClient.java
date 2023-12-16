package CorbaClient;

import corbaConversion.IConversionRemote;
import corbaConversion.IConversionRemoteHelper;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ConversionClient {
    public static void main(String[] args) {
        try {
            Context ctx = new InitialContext();
            Object ref = ctx.lookup("OD");
            IConversionRemote stub = IConversionRemoteHelper.narrow((org.omg.CORBA.Object)ref);
            System.out.println(stub.conversionMontant(70.000));
            System.out.println(stub.conversionMontant(150.000));

        } catch (NamingException e) {
            e.printStackTrace();
        }

    }
}
