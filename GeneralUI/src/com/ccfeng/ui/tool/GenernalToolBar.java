/*
 * @class GenernalToolBar.java
 * @author ccfeng
 * @date 2014/10/25
 * 
 */
package com.ccfeng.ui.tool;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JComponent;
import javax.swing.JToolBar;

public class GenernalToolBar extends JToolBar {
	private static final long serialVersionUID = 1L;
	private Map<String, JComponent> barComponents = null;

	public GenernalToolBar(Map<String, JComponent> barComponents) {
		if (barComponents == null)
			return;
		this.barComponents = barComponents;
		setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(204, 204, 204)));
		setRollover(true);
		setBorderPainted(true);
		Iterator<Entry<String, JComponent>> itr = barComponents.entrySet().iterator();
		while (itr.hasNext()) {
			Map.Entry<String, JComponent> entry = (Map.Entry<String, JComponent>) itr
					.next();
			add(entry.getValue());

		}
	}

	public void setComponentEnable(String key, boolean enabled) {
		if (barComponents == null)
			return;
		JComponent component = barComponents.get(key);
		if (component != null)
			component.setEnabled(enabled);
	}

	public void setComponentVisible(String key, boolean visibled) {
		if (barComponents == null)
			return;
		JComponent component = barComponents.get(key);
		if (component != null)
			component.setVisible(visibled);
	}


	public JComponent getComponent(String key) {
		if (barComponents == null)
			return null;
		return barComponents.get(key);
	}

	public void updateToolBar(Map<String, JComponent> bar) {
		if (bar == null)
			return;
		this.barComponents = bar;
		removeAll();
		Iterator<Entry<String, JComponent>> itr = bar.entrySet().iterator();
		while (itr.hasNext()) {
			Map.Entry<String, JComponent> entry = (Map.Entry<String, JComponent>) itr
					.next();
			add(entry.getValue());

		}
	}

	public void updateToolBar() {
		if (barComponents == null)
			return;
		removeAll();
		Iterator<Entry<String, JComponent>> itr = barComponents.entrySet().iterator();
		while (itr.hasNext()) {
			Map.Entry<String, JComponent> entry = (Map.Entry<String, JComponent>) itr
					.next();
			add(entry.getValue());
		}
	}

}
