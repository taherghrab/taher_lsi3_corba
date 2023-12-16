package corbaServer;
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;
import service.ConversionImpl;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ConversionServer {
    public static void main(String[] args) {
        //a.

        ORB orb = ORB.init(args,null);
        //c.
        try {
            Context ctx = new InitialContext();
            //b
            //ca p$our activer et initialiser le poa manager
            POA poa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            poa.the_POAManager().activate();
            ConversionImpl od = new ConversionImpl();
            ctx.rebind("OD",poa.servant_to_reference(od));
//runnig orb
            orb.run();



        } catch (NamingException e) {
            e.printStackTrace();
        } catch (InvalidName invalidName) {
            invalidName.printStackTrace();
        } catch (AdapterInactive adapterInactive) {
            adapterInactive.printStackTrace();
        } catch (WrongPolicy wrongPolicy) {
            wrongPolicy.printStackTrace();
        } catch (ServantNotActive servantNotActive) {
            servantNotActive.printStackTrace();
        }


    }
}
