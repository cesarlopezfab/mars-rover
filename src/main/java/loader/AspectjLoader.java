package loader;

import com.sun.tools.attach.VirtualMachine;
import org.aspectj.weaver.loadtime.Agent;

import java.lang.management.ManagementFactory;

public class AspectjLoader {
	public static void load() {
		if (!isAspectJAgentLoaded()) {
			throw new Error("Not loaded");
		}
	}

	public static boolean isAspectJAgentLoaded() {
		try {
			Agent.getInstrumentation();
		} catch (NoClassDefFoundError e) {
			System.out.println(e);
			return false;
		} catch (UnsupportedOperationException e) {
			System.out.println(e);
			return dynamicallyLoadAspectJAgent();
		}
		return true;
	}

	public static boolean dynamicallyLoadAspectJAgent() {
		String nameOfRunningVM = ManagementFactory.getRuntimeMXBean().getName();
		int p = nameOfRunningVM.indexOf('@');
		String pid = nameOfRunningVM.substring(0, p);
		try {
			VirtualMachine vm = VirtualMachine.attach(pid);
			String jarFilePath = System.getProperty("AGENT_PATH");
			vm.loadAgent(jarFilePath);
			vm.detach();
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		return true;
	}
}
