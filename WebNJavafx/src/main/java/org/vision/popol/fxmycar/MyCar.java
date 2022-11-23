package org.vision.popol.fxmycar;
import java.util.TreeMap;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
public class MyCar extends Button implements Runnable {
	public Pane lane = new Pane();
	public String name;
	public int pos;
	public static final int RUNNING = 0;
	public static final int SUSPENDED = 1;
	public static final int STOPPED = 2;
	public static int STATE = RUNNING;
	public Thread th;
	public static int rank;
	public int myRank;
	public static TreeMap<Integer,String> rankMap = 
			new TreeMap<Integer,String>();
	public static ThreadGroup thGroup = new ThreadGroup("cars");
	public MyCar(String name) {
		lane.getChildren().addAll(this);
		this.setPrefWidth(100);
		this.setText(name);
		this.setLayoutX(0);
		this.setLayoutY(10);
		this.setPrefHeight(40);
		th = new Thread(thGroup,this,name);
		this.name = name;
	}
	public synchronized void setState(int state) {
		this.STATE = state;
		if (STATE == RUNNING) {
			notify();
		} else {
			th.interrupt();
		}
	}

	public synchronized boolean checkState() {
		while (STATE == SUSPENDED) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return STATE == STOPPED;
	}

	public void suspend() {
		setState(SUSPENDED);
	}

	public void resume() {
		setState(RUNNING);
	}

	public void stop() {
		setState(STOPPED);
	}

	public void start() {
		th.start();
	}

	@Override
	public void run() {
		for (pos = 0; pos < 1000; pos += 2) {

			Platform.runLater(new Runnable() {// �������κ�
				@Override
				public void run() {
					MyCar.this.setLayoutX(MyCar.this.pos);
					MyCar.this.setLayoutY(10);
					//MyCar.this.setWidth(100);
					//MyCar.this.setHeight(40);
				}
			});
			try {
				Thread.sleep((int) (Math.random() * 30));
			} catch (InterruptedException e) {}
			if (checkState()) {
				break;
			}
		}
		myRank = ++rank;
		//setText(myRank+"�� = "+name);
		rankMap.put(myRank, name);
		//System.out.println(myRank+"�� = "+name);
	}
}