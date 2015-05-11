/*
 * @class SplitPanel.java
 * @author ccfeng
 * @date 2014/10/18
 * 
 */
package com.ccfeng.ui.content.split;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;

public class SplitPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	// left panel
	private JPanel leftPanel = new JPanel();
	protected JTabbedPane leftTabbedPane = new JTabbedPane();
	// right panel
	private JPanel rightPanel = new JPanel();
	// center panel
	private JPanel centerPanel = new JPanel();
	protected JTabbedPane workTabbedPane = new JTabbedPane();
	// bottom panel
	private JPanel bottomPanel = new JPanel();
	protected JTabbedPane downTabbedPane = new JTabbedPane();

	public SplitPanel() {
		setLayout(new BorderLayout());
		initPanel();
	}

	private void initPanel() {
		centerPanel.setLayout(new java.awt.GridLayout());
		JSplitPane leftSplitPane = new JSplitPane(1);
		leftSplitPane.setBorder(javax.swing.BorderFactory.createEmptyBorder(1,
				1, 1, 1));
		leftSplitPane.setResizeWeight(0.14);
		leftPanel.setLayout(new java.awt.GridLayout());
		leftPanel.add(leftTabbedPane);
		leftSplitPane.setLeftComponent(leftPanel);
		rightPanel.setLayout(new java.awt.GridLayout());
		JSplitPane downSplitPane = new JSplitPane();
		downSplitPane.setBorder(javax.swing.BorderFactory.createEmptyBorder(1,
				1, 1, 1));
		downSplitPane.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
		downSplitPane.setResizeWeight(0.8);
		downSplitPane.setTopComponent(workTabbedPane);
		downSplitPane.setBottomComponent(downTabbedPane);
		rightPanel.add(downSplitPane);
		leftSplitPane.setRightComponent(rightPanel);
		centerPanel.add(leftSplitPane);
		add(centerPanel, java.awt.BorderLayout.CENTER);

		bottomPanel.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(204, 204, 204)));
		bottomPanel
				.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));
		bottomPanel.add(new JLabel("General UI(run)"));
		bottomPanel.add(new JProgressBar());
		bottomPanel.add(new JLabel("INS"));
		add(bottomPanel, java.awt.BorderLayout.PAGE_END);
		leftSplitPane.setOneTouchExpandable(true);
		leftSplitPane.setDividerSize(14);
		downSplitPane.setOneTouchExpandable(true);
		downSplitPane.setDividerSize(14);
		/*
		SplitPaneUI ui = leftSplitPane.getUI();
		if (ui instanceof BasicSplitPaneUI) {
			((BasicSplitPaneUI) ui).getDivider().setBorder(null);
		}
		ui = downSplitPane.getUI();
		if (ui instanceof BasicSplitPaneUI) {
			((BasicSplitPaneUI) ui).getDivider().setBorder(null);
		}
		*/
	}

	public JTabbedPane getLeftTabbedPane() {
		return leftTabbedPane;
	}

	public void setLeftTabbedPane(JTabbedPane leftTabbedPane) {
		this.leftTabbedPane = leftTabbedPane;
	}

	public JTabbedPane getWorkTabbedPane() {
		return workTabbedPane;
	}

	public void setWorkTabbedPane(JTabbedPane workTabbedPane) {
		this.workTabbedPane = workTabbedPane;
	}

	public JTabbedPane getDownTabbedPane() {
		return downTabbedPane;
	}

	public void setDownTabbedPane(JTabbedPane downTabbedPane) {
		this.downTabbedPane = downTabbedPane;
	}

}
