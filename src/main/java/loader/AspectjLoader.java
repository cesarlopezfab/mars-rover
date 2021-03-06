package loader;

import com.sun.tools.attach.VirtualMachine;
import org.aspectj.weaver.loadtime.Agent;

import java.lang.management.ManagementFactory;
import java.net.URLDecoder;

public class AspectjLoader {
	public static void load() {
		if (!isAspectJAgentLoaded()) {
			throw new Error("Not loaded");
		}
	}

	public static boolean isAspectJAgentLoaded() {
		try {
			Agent.getInstrumentation();
		} catch (UnsupportedOperationException e) {
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
			String path = Agent.class.getProtectionDomain().getCodeSource().getLocation().getPath();
			String jarFilePath = URLDecoder.decode(path, "UTF-8");
			vm.loadAgent(jarFilePath);
			vm.detach();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
