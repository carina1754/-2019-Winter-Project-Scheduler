package first;
import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class TestSystemTrayIcon implements ActionListener {
	private SystemTray systemTray;
	private PopupMenu mPopup;
	private MenuItem mItemNew, mItemOpen, mItemSave, mItemExit;

	public TestSystemTrayIcon() {
		try {
			initSystemTrayIcon();
		} catch (AWTException awte) {
			System.out.println("##### Error occurred during create UI!!!");
			System.out.println(awte.toString());
			System.exit(0);
		}
	}

	public void initSystemTrayIcon() throws AWTException {
		if (SystemTray.isSupported()) {
			mPopup = new PopupMenu();
			mItemNew = new MenuItem("New");
			mItemOpen = new MenuItem("Open");
			mItemSave = new MenuItem("Save");
			mItemExit = new MenuItem("Exit");

			mItemNew.addActionListener(this);
			mItemOpen.addActionListener(this);
			mItemSave.addActionListener(this);
			mItemExit.addActionListener(this);

			mPopup.add(mItemNew);
			mPopup.addSeparator();
			mPopup.add(mItemOpen);
			mPopup.add(mItemSave);
			mPopup.addSeparator();
			mPopup.add(mItemExit);

			Image image = Toolkit.getDefaultToolkit().getImage("c:/icon_network.gif");
			TrayIcon trayIcon = new TrayIcon(image, "Java 6.0 SystemTrayIcon Test", mPopup);
			trayIcon.setImageAutoSize(true);

			systemTray = SystemTray.getSystemTray();
			systemTray.add(trayIcon);
		}
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == mItemNew) {
			showMessage("New File...", "새로운 파일을 생성합니다.");
		} else if (ae.getSource() == mItemOpen) {
			showMessage("File Open...", "파일을 엽니다.");
		} else if (ae.getSource() == mItemSave) {
			showMessage("File Save...", "파일을 저장합니다.");
		} else if (ae.getSource() == mItemExit) {
			showMessage("Exit SystemTrayIcon Test...", "종료하겠습니다.");
			System.exit(0);
		}
	}

	private void showMessage(String title, String message) {
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
	}

	public static void main(String[] args) {
		TestSystemTrayIcon test = new TestSystemTrayIcon();
	}
}