package com.modusbps.bos.nugget;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JExecuteWorkflowTestCase {
	private static final String LAUNCHER = "C:\\Program Files (x86)\\UiPath Studio\\v7\\UiPath\\UiLauncher.exe";
	private static final String WORKFLOW = "C:\\Users\\Laurence\\Dev\\projects\\ModusBOS\\xaml\\SugarcrmTest1.xaml";
	
	private JExecuteWorkflow wkfexe;

	@Before
	public void setUp() throws Exception {
		wkfexe = new JExecuteWorkflow(LAUNCHER, WORKFLOW);
	}
	
	@Test
	public void testExecuteWorkFlow() {
		wkfexe.executeWorkFlow();
	}

	@After
	public void tearDown() throws Exception {
		wkfexe = null;
		
	}

}
