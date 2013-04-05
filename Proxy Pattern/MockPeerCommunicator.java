import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class MockPeerCommunicator extends PeerCommunicator {

	// =========================================================================
	// ======================== SINGLETON PATTERN STUFF ========================
	// =========================================================================
	private static MockPeerCommunicator instance;

	public static MockPeerCommunicator getSingleton() {
		if (instance == null) {
			instance = new MockPeerCommunicator();
		}
		return instance;
	}

	/**
	 * This constructor is private so ONLY THIS CLASS can construct itself: and
	 * that happens in the getSingleton() method.
	 */
	private MockPeerCommunicator() {

	}

	// =========================================================================
	// ======================== OVERLOADED METHODS =============================
	// =========================================================================

	/**
	 * Sends the indicated command to the target object indicated by the
	 * globalObjectId. The target (which can be a class) executes the command
	 * and returns a result.
	 * 
	 * @param globalObjectId
	 *            the identifier of an object or class in an application
	 *            listening on port globalObjectId.portNumber running on the
	 *            machine globalObjectId.machineAddr
	 * @param command
	 *            the command to be sent to the target object.
	 * 
	 * @pre globalObjectId &ne; null AND command &ne; null AND the command must
	 *      be a legal command for the target object and a PeerCommunicator is
	 *      listening on the indicated port and machine.
	 * @post The command is executed on the remote object and the result is
	 *       returned. If there is an exception in the communication, the
	 *       associated message and stack trace is printed. If the remote
	 *       execution of the method caused an error, the returned result will
	 *       be of type Throwable or Exception. These should be checked by the
	 *       original invoking method.
	 */
	public Object sendSynchronous(GlobalObjectId globalObjectId, Command command) {
		return command.execute();
	}

	/**
	 * Sends the indicated command to the target object indicated by the
	 * globalObjectId. The target (which can be a class) executes the command.
	 * No result is expected.
	 * 
	 * @param globalObjectId
	 *            the identifier of an object or class in an application
	 *            listening on port globalObjectId.portNumber running on the
	 *            machine globalObjectId.machineAddr
	 * 
	 * @param command
	 *            the command to be sent to the target object.
	 * 
	 * @pre globalObjectId &ne; null AND command &ne; null AND the command must
	 *      be a legal command for the target object and a PeerCommunicator is
	 *      listening on the indicated port and machine.
	 * @post The command is executed on the remote object. No result is
	 *       returned.
	 */
	public void sendASynchronous(GlobalObjectId globalObjectId, Command command) {
		command.execute();
	}

	// =============================================================================================
	// ---------------------- OVERLOADING EVERYTHING ELSE SO THEY DO NOTHING
	// ----------------------
	// =============================================================================================

	public static void stopThisConnection() {

	}

	public static void stopConnection(GlobalObjectId globalObjectId) {

	}

	public static void noop() {

	}

	public void run() {

	}

	public static void createPeerCommunicator() {

	}

	public static void createPeerCommunicator(PortNumber portNumber) {

	}
}
