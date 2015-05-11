/*
 * @class ToolComponent.java
 * @author ccfeng
 * @date 2014Äê10ÔÂ25ÈÕ
 * 
 */
package com.ccfeng.ui.tool;

import javax.swing.JComponent;

public class JToolComponent {

	private JComponent component;
	private Object actionListener;

	public JToolComponent(JComponent component, Object actionListener) {
		this.component = component;
		this.actionListener = actionListener;
	}

	public JComponent getComponent() {
		return component;
	}

	public Object getActionListener() {
		return actionListener;
	}

}
