
public class CakeProxy
    extends Cake
{

    public CakeProxy(GlobalObjectId globalObjectId){
    	super(globalObjectId);
    }

    public int bitesLeft(){
        String[] parameterTypeNames = new String[0];
        Object[] actualParameters = new Object[0];
        Command command = new Command(globalObjectId.getLocalObjectId(), "Cake", "bitesLeft", parameterTypeNames, actualParameters, true);
        Object result = MockPeerCommunicator.getSingleton().sendSynchronous(globalObjectId, command);
        return (Integer)result;
    }

    public void takeBite(){
        String[] parameterTypeNames = new String[0];
        Object[] actualParameters = new Object[0];
        Command command = new Command(globalObjectId.getLocalObjectId(), "Cake", "takeBite", parameterTypeNames, actualParameters, false);
        MockPeerCommunicator.getSingleton().sendASynchronous(globalObjectId, command);
    }

    public boolean equals(java.lang.Object p0){
    	//Only 1 parameter of type "java.lang.Object" (which is the parameter to this function)
    	//So we record the type of object ("java.lang.Object"), and the reference to the object.
        String[] parameterTypeNames = new String[1];
        parameterTypeNames[0] = "java.lang.Object";
        Object[] actualParameters = new Object[1];
        actualParameters[0] = p0;
        
        //Make a command  (LocalObjectID, className, methodName, parameterTypeNames, actualParameters, isSynchronous)
        Command command = new Command(globalObjectId.getLocalObjectId(), "java.lang.Object", "equals", parameterTypeNames, actualParameters, true);
        
        //sendSynchronous returns an Object since it can be anything, and is a generic function to send ANY type of command.
        Object result = MockPeerCommunicator.getSingleton().sendSynchronous(globalObjectId, command);
        
        //Since we know what command we sent, we know the return type. 
        //So we expects a boolean result from that command, and cast it here.
        return (Boolean)result;
    }

    public java.lang.String toString(){
    	//No parameters
        String[] parameterTypeNames = new String[0];
        Object[] actualParameters = new Object[0];
        
        //Tells the object to call java.lang.Object's toString method.
        Command command = new Command(globalObjectId.getLocalObjectId(), "java.lang.Object", "toString", parameterTypeNames, actualParameters, true);
        
        Object result = MockPeerCommunicator.getSingleton().sendSynchronous(globalObjectId, command);
        return (java.lang.String)result;
    }

    public int hashCode(){
        String[] parameterTypeNames = new String[0];
        Object[] actualParameters = new Object[0];
        Command command = new Command(globalObjectId.getLocalObjectId(), "java.lang.Object", "hashCode", parameterTypeNames, actualParameters, true);
        Object result = MockPeerCommunicator.getSingleton().sendSynchronous(globalObjectId, command);
        return (Integer)result;
    }

}