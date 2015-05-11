/*
 * @class MenuBarFactory.java
 * @author ccfeng
 * @date 2014/10/17
 * 
 */
package com.ccfeng.ui.menu;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public abstract class MenuBarFactory {
	private static JMenuBar menuBar = null;

	public static JMenuBar createMenuBar(final JFrame container,
			final List<JMenu> menus) {
		menuBar = createMenuBar(menus);
		if (container != null && menuBar != null)
			container.setJMenuBar(menuBar);
		return menuBar;
	}

	public static JMenuBar createMenuBar(final List<JMenu> menus) {
		if (menus == null || menus.size() == 0)
			return null;
		if (menuBar == null) {
			menuBar = new JMenuBar();
			for (JMenu jMenu : menus)
				menuBar.add(jMenu);
		}
		return menuBar;

	}

	public static void removeMenuBar() {
		menuBar = null;
	}

	public static JMenuBar getMenuBar() {
		return menuBar;
	}
}
