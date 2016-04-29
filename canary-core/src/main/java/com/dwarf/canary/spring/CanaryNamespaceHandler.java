package com.dwarf.canary.spring;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class CanaryNamespaceHandler extends NamespaceHandlerSupport {

	@Override
	public void init() {
		registerBeanDefinitionParser("service", new CanaryBeanDefinitionParser());
	}

}
