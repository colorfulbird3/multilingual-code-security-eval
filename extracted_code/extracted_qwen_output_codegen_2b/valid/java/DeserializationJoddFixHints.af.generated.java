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