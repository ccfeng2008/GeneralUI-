/*
 * @class ToolBarFactory.java
 * @author ccfeng
 * @date 2014/10/17
 * 
 */
package com.ccfeng.ui.tool;

import java.awt.Container;
import java.util.Map;

import javax.swing.JComponent;

public abstract class ToolBarFactory {
	private static GenernalToolBar toolBar = null;

	public static GenernalToolBar createToolBar(final Container container,
			final Map<String, JComponent> barComponents) {
		toolBar = createToolBar(barComponents);
		if (container != null && toolBar != null)
			container.add(toolBar, java.awt.BorderLayout.PAGE_START);
		return toolBar;
	}

	public static GenernalToolBar createToolBar(
			final Map<String, JComponent> barComponents) {
		if (barComponents == null)
			return null;
		if (toolBar == null)
			return new GenernalToolBar(barComponents);
		return toolBar;
	}

	public static void removeToolBar() {
		toolBar = null;
	}

	public static GenernalToolBar getToolBar() {
		return toolBar;
	}
}
