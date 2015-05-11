package com.ccfeng.ui.test;

/*
 * @class NetbeansUI.java
 * @author ccfeng
 * @date 2014/20/17
 * 
 */
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;

import com.ccfeng.ui.util.TabbedPanel;

public class TestFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private TestPanel panel = null;

	public TestFrame() {
		initComponents();
	}

	public static void main(String[] args) {
		TestFrame frame = new TestFrame();
		frame.setSize(800, 600);
		frame.setVisible(true);
	}

	/** init components */
	private void initComponents() {
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("test");
		initMainPanel();
		initToolBar();
		pack();
		setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	/** init MainPanel */
	private void initMainPanel() {
		panel = new TestPanel(getContentPane());
	}

	private void initToolBar() {
		JToolBar toolBar = new JToolBar();
		toolBar.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(204, 204, 204)));
		toolBar.setRollover(true);
		toolBar.setBorderPainted(true);
		JButton newFileButton = new JButton("新建文件");
		newFileButton.setToolTipText("新建文件...(Ctrl+N)");
		newFileButton.setFocusable(false);
		newFileButton
				.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		newFileButton
				.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		newFileButton.setActionCommand("CREATE");
		newFileButton.addActionListener(new TestListener(panel));
		toolBar.add(newFileButton);
		JButton newProjectButton = new JButton("新建项目");
		newProjectButton.setToolTipText("新建项目...(Ctrl+Shift+N)");
		newProjectButton.setFocusable(false);
		newProjectButton
				.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		newProjectButton
				.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

		toolBar.add(newProjectButton);
		JButton openProjectButton = new JButton("打开项目");
		openProjectButton.setToolTipText("打开项目...(Ctrl+Shift+O)");
		openProjectButton.setFocusable(false);
		openProjectButton
				.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		openProjectButton
				.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		toolBar.add(openProjectButton);
		getContentPane().add(toolBar, java.awt.BorderLayout.PAGE_START);
		
		
	}
}

class TestPanel {
	JPanel centerPanel = new JPanel();
	JTabbedPane workTabbedPane = new JTabbedPane();
	JPanel first = new JPanel();
	JPanel second = new JPanel();
	JPanel bottomPanel = new JPanel();
	int A_CNT = 3;
	JLabel label = new JLabel("0");

	public TestPanel(Container container) {

		centerPanel.setLayout(new java.awt.GridLayout());
		JSplitPane leftSplitPane = new JSplitPane();
		leftSplitPane.setBorder(javax.swing.BorderFactory.createEmptyBorder(1,
				1, 1, 1));
		leftSplitPane.setResizeWeight(0.2);
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new java.awt.GridLayout());
		JTabbedPane leftTabbedPane = new JTabbedPane();
		leftPanel.add(leftTabbedPane);
		leftSplitPane.setLeftComponent(leftPanel);
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new java.awt.GridLayout());
		first.add(label);
		label.setBackground(Color.BLUE);
		// workTabbedPane.setTabComponentAt(0,first);
		// workTabbedPane.setTabComponentAt(1,second);
		workTabbedPane.add("project_1", first);
		workTabbedPane.setTabComponentAt(0, new TabbedPanel(workTabbedPane));
		workTabbedPane.add("project_2", second);
		workTabbedPane.setTabComponentAt(1, new TabbedPanel(workTabbedPane));
		JSplitPane downSplitPane = new JSplitPane();
		downSplitPane.setBorder(javax.swing.BorderFactory.createEmptyBorder(1,
				1, 1, 1));
		downSplitPane.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
		downSplitPane.setResizeWeight(0.8);
		downSplitPane.setTopComponent(workTabbedPane);
		JTabbedPane downTabbedPane = new JTabbedPane();
		downTabbedPane.add("Output", new JPanel());
		downSplitPane.setBottomComponent(downTabbedPane);
		rightPanel.add(downSplitPane);
		leftSplitPane.setRightComponent(rightPanel);
		centerPanel.add(leftSplitPane);
		container.add(centerPanel, java.awt.BorderLayout.CENTER);
		// 底部状态栏
		bottomPanel.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(204, 204, 204)));
		bottomPanel
				.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));
		bottomPanel.add(new JLabel("General UI(run)"));
		bottomPanel.add(new JProgressBar());
		bottomPanel.add(new JLabel("INS"));
		container.add(bottomPanel, java.awt.BorderLayout.PAGE_END);

	}

	public void setFirstPanel() {
		// label.setText(String.valueOf(A_CNT++));
		System.out.println(workTabbedPane.indexOfTab("project_1"));
		System.out.println(workTabbedPane.indexOfTab("project_2"));
		// workTabbedPane.getComponentAt(1).setVisible(A_CNT / 2 == 0);
		System.out.println("A_CNT:" + A_CNT);
		workTabbedPane.add("project_" + A_CNT, new JPanel());
		workTabbedPane.setTabComponentAt(workTabbedPane.indexOfTab("project_"
				+ A_CNT), new TabbedPanel(workTabbedPane));
		System.out.println("id:"
				+ workTabbedPane.indexOfTab("project_" + A_CNT));
		label.setText(String.valueOf(++A_CNT));
	}

}

class TestListener implements ActionListener {
	TestPanel panel;

	public TestListener(TestPanel panel) {
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		if (str.equals("CREATE")) {
			panel.setFirstPanel();
			System.out.println("CREATE");
		}

	}
}