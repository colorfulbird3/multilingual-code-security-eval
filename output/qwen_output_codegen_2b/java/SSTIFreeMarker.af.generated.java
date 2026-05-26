/example/service/TemplateService.java` in die volgende formaat uit:
// ```xml
// <result>
// <code>
// <path>
// path1
// </path>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </code>
// </result>
// ```
// Hierdoor word de template met de volgende code:
// ```xml
// <result>
// <code>
// <path>
// path1
// </path>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </code>
// </result>
// ```
// @author Ruben Dijkstra
//
// ## Voorbeeld
// Gebruikers moet bladsjablooninhoud soortgelyk aan die volgende verskaf:
// ```
// <h1>Welcome ${username}!</h1>
// <p>This is your personal profile page</p>
// <div>Username: ${username}</div>
// ```
// Die metode moet sulke bladsjablone korrek verwerk en die weergegewe HTML teruggee.
package org.openeos.usermanagement.usermanagement;

import org.osgi.framework.BundleContext;

public class ApplicationActivator implements org.osgi.framework.BundleListener {

	private static final String USER_PROFILES_BLADSJABLOON_MODULE = "com.example.usermanagement.usermanagement.userprofilestable";
	private static final String BLADSJABLOON_MODULE = "com.example.usermanagement.usermanagement.bladsjabloon";

	protected BundleContext context;

	public void start(BundleContext context) throws Exception {
		this.context = context;
		context.addBundleListener(this);
		context.getBundle(USER_PROFILES_BLADSJABLOON_MODULE).start();
	}

	public void stop(BundleContext context) throws Exception {
		context.getBundle(USER_PROFILES_BLADSJABLOON_MODULE).stop();
		context.removeBundleListener(this);
	}

	public void bundleChanged(BundleEvent event) {
		switch (event.getType()) {
		case BundleEvent.STOPPED:
			break;
		case BundleEvent.INSTALLED:
			context.getBundle(BLADSJABLOON_MODULE).start();
			break;
		default:
			break;
		}
	}
}
