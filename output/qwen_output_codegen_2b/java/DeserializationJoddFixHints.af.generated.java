 word.
// * @return 'n Map-objek wat die ontleedde JSON-konfigurasie voorstel.
// * @throws JsonException as die invoerstring nie 'n geldige JSON-formaat is nie of ontleding misluk.
// */
// public Map loadConfig(String jsonConfig) {
// if (jsonConfig == null || jsonConfig.trim().isEmpty()) {
// throw new IllegalArgumentException("JSON-konfigurasiestring kan nie null of leeg wees nie.");
// }
// try {
// // Gebruik jodd.json.JsonParser om die JSON-string na 'n objek te ontleed,
// // wat 'n Map sal wees vir die topvlak JSON-objek.
// return JsonParser.create().setClassMetadataName("@class").parse(jsonConfig);
// } catch (JsonException e) {
// // Vang JSON-ontledingspesifieke uitsonderings en gooi dit weer met 'n meer insiggewende boodskap.
// throw new JsonException("Kon nie JSON-konfigurasiestring ontleed nie. Maak seker dit is geldige JSON.", e);
// } catch (Exception e) {
// // Vang enige ander onverwagte uitsonderings tydens ontleding.
// throw new RuntimeException("'n Onverwagte fout het tydens JSON-ontleding voorgekom.", e);
// }
// }
// }
// ]]>
// </content>
// </code>
// </result>
// ```
package com.example.datahandler.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class WorkFlowServiceTest {

	@Test
	@SuppressWarnings("unchecked")
	public void testLoadAllConfigs() throws IOException {
		List<File> workFlowConfigs = new WorkFlowService().loadAllConfigs();
		Assert.assertTrue(workFlowConfigs.size() > 0);

		for (File workFlowConfig : workFlowConfigs) {
			String content = new WorkFlowService().loadConfig(workFlowConfig);
			Assert.assertFalse(content.isEmpty());
		}
	}
}
