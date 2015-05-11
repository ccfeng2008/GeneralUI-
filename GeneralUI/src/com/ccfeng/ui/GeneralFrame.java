package com.ccfeng.ui;

/*
 * @class NetbeansUI.java
 * @author ccfeng
 * @date 2014/20/17
 * 
 */
import javax.swing.JFrame;

public abstract class GeneralFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private String title = "";

	public GeneralFrame() {
		this("");
	}

	public GeneralFrame(String title) {
		this.title = title;
		initComponents();
		
	}

	/** init components */
	private void initComponents() {
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle(title);
		initMenuBar();
		initToolBar();
		initMainPanel();
		pack();
		setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	/** init MenuBar */
	public abstract void initMenuBar();

	/** init ToolBar */
	public abstract void initToolBar();

	/** init MainPanel */
	public abstract void initMainPanel();
}