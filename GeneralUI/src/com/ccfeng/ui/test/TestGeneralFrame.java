/*
 * @class TestGeneralFrame.java
 * @author ccfeng
 * @date 2014��10��26��
 * 
 */
package com.ccfeng.ui.test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.ccfeng.ui.GeneralFrame;
import com.ccfeng.ui.content.ContentPanelFactory;
import com.ccfeng.ui.content.split.SplitPanel;
import com.ccfeng.ui.menu.MenuBarFactory;
import com.ccfeng.ui.tool.ToolBarFactory;

public class TestGeneralFrame extends GeneralFrame {
	private static final long serialVersionUID = 1L;

	@Override
	public void initMenuBar() {
		List<JMenu> menus = new ArrayList<JMenu>();
		JMenu fileMenu = new JMenu("�ļ�(F)");
		menus.add(fileMenu);
		JMenu editMenu = new JMenu("�༭(E)");
		menus.add(editMenu);
		JMenu viewMenu = new JMenu("��ͼ(V)");
		menus.add(viewMenu);
		JMenu leadMenu = new JMenu("����(V)");
		menus.add(leadMenu);
		/*****/
		JMenu windowMenu = new JMenu("����(W)");
		JMenuItem item = new JMenuItem("�´���(N)");
		JMenu sitem = new JMenu("��ʾ����(S W)");
		JMenuItem antMenu = new JMenuItem("Ant");
		JMenuItem outMenu = new JMenuItem("Outline");
		sitem.add(antMenu);
		sitem.add(outMenu);
		windowMenu.add(item);
		windowMenu.add(sitem);
		menus.add(windowMenu);
		/****/
		JMenu helpMenu = new JMenu("����(H)");
		menus.add(helpMenu);
		MenuBarFactory.createMenuBar(this, menus);

	}

	@Override
	public void initToolBar() {
		Map<String, JComponent> barComponents = new LinkedHashMap<>();
		JButton newFileButton = new JButton("�½��ļ�");
		newFileButton.setToolTipText("�½��ļ�...(Ctrl+N)");
		newFileButton.setFocusable(false);
		newFileButton
				.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		newFileButton
				.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		barComponents.put("CRT_FILE", newFileButton);

		JButton newProjectButton = new JButton("�½���Ŀ");
		newProjectButton.setToolTipText("�½���Ŀ...(Ctrl+Shift+N)");
		newProjectButton.setFocusable(false);
		newProjectButton
				.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		newProjectButton
				.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		barComponents.put("CRT_PROJ", newProjectButton);

		JButton openProjectButton = new JButton("����Ŀ");
		openProjectButton.setToolTipText("����Ŀ...(Ctrl+Shift+O)");
		openProjectButton.setFocusable(false);
		openProjectButton
				.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		openProjectButton
				.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		barComponents.put("OPEN_PROJ", openProjectButton);

		ToolBarFactory.createToolBar(getContentPane(), barComponents);
	}

	@Override
	public void initMainPanel() {
		ContentPanelFactory.createContentPanel(getContentPane(),
				new SplitPanel());
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager
							.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");

				} catch (Exception localException1) {
					try {
						UIManager.setLookAndFeel(UIManager
								.getSystemLookAndFeelClassName());
					} catch (Exception localException2) {
						localException2.printStackTrace();
					}

				}
				TestGeneralFrame frame = new TestGeneralFrame();
				frame.setSize(800, 600);
				frame.setVisible(true);
			}
		});
	}

}
