/*
 * @class ContentFactory.java
 * @author ccfeng
 * @date 2014/10/17
 * 
 */
package com.ccfeng.ui.content;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public abstract class ContentPanelFactory {
	private static JComponent contentPanel = null;

	public static JComponent createContentPanel(final Container container,
			final Map<String, JComponent> contents) {
		contentPanel = createContentPanel(contents);
		if (container != null && contentPanel != null)
			container.add(contentPanel, java.awt.BorderLayout.CENTER);
		return contentPanel;
	}

	public static JComponent createContentPanel(final Container container,
			final JComponent content) {
		ContentPanelFactory.contentPanel = content;
		if (container != null && contentPanel != null)
			container.add(contentPanel, java.awt.BorderLayout.CENTER);
		return contentPanel;
	}

	public static JComponent createContentPanel(
			final Map<String, JComponent> contents) {
		if (contents == null || contents.size() == 0)
			return null;
		if (contentPanel == null) {
			contentPanel = new JPanel(new BorderLayout());
			JTabbedPane tabs = new JTabbedPane();
			tabs.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
			Iterator<Entry<String, JComponent>> itr = contents.entrySet()
					.iterator();
			Map.Entry<String, JComponent> entry = null;
			while (itr.hasNext()) {
				entry = (Map.Entry<String, JComponent>) itr.next();
				tabs.addTab(entry.getKey(), entry.getValue());
			}
			contentPanel.add(tabs, java.awt.BorderLayout.CENTER);
		}
		return contentPanel;
	}

	public static void removeContentPanel() {
		contentPanel = null;
	}

	public static JComponent getContentPanel() {
		return contentPanel;
	}

}
