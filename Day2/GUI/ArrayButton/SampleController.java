package application;

import java.util.Calendar;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class SampleController {

	Model model = new Model();

	@FXML
	private Text month;
	@FXML
	private String calDate[][] = new String[5][7];
	@FXML
	private Button btn1;
	@FXML
	private Button btn2;
	@FXML
	private Button btn3;
	@FXML
	private Button btn4;
	@FXML
	private Button btn5;
	@FXML
	private Button btn6;
	@FXML
	private Button btn7;
	@FXML
	private Button btn8;
	@FXML
	private Button btn9;
	@FXML
	private Button btn10;
	@FXML
	private Button btn11;
	@FXML
	private Button btn12;
	@FXML
	private Button btn13;
	@FXML
	private Button btn14;
	@FXML
	private Button btn15;
	@FXML
	private Button btn16;
	@FXML
	private Button btn17;
	@FXML
	private Button btn18;
	@FXML
	private Button btn19;
	@FXML
	private Button btn20;
	@FXML
	private Button btn21;
	@FXML
	private Button btn22;
	@FXML
	private Button btn23;
	@FXML
	private Button btn24;
	@FXML
	private Button btn25;
	@FXML
	private Button btn26;
	@FXML
	private Button btn27;
	@FXML
	private Button btn28;
	@FXML
	private Button btn29;
	@FXML
	private Button btn30;
	@FXML
	private Button btn31;
	@FXML
	private Button btn32;
	@FXML
	private Button btn33;
	@FXML
	private Button btn34;
	@FXML
	private Button btn35;

	public Button[] arrayButtons;

	@FXML
	private void nextMonth(ActionEvent event) {
		model.currentMonth++;
		model.setMonthCode(model.currentMonth);
		month.setText(model.monthCode);
	}

	@FXML
	private void prevMonth(ActionEvent event) {
		model.currentMonth--;
		model.setMonthCode(model.currentMonth);
		month.setText(model.monthCode);
	}

	@FXML
	private void startPage() {
		// 달력 날짜 배열에 저장
		Calendar cal = Calendar.getInstance();
		int width = calDate[0].length;

		cal.set(Calendar.DATE, 1);

		int startDay = cal.get(Calendar.DAY_OF_WEEK);
		int lastDay = cal.getActualMaximum(Calendar.DATE);
		int inputDate = 1;

		System.out.println(startDay);
		System.out.println(lastDay);

		int row = 0;
		for (int i = 1; i <= 35; i++) {
			if (i < startDay) {
				calDate[row][(i - 1) % width] = "";
			} else if (inputDate > lastDay) {
				calDate[row][(i - 1) % width] = "";
			} else {
				calDate[row][(i - 1) % width] = Integer.toString(inputDate);
				inputDate++;
			}

			if (i % width == 0)
				row++;
		}

		// 날짜 버튼 세팅
		setButton();
		
		//현재 월
		month.setText(Integer.toString(cal.get(Calendar.MONTH)+1));
	}

	public void setButton() {
		arrayButtons = new Button[35];
		arrayButtons[0] = btn1;
		arrayButtons[1] = btn2;
		arrayButtons[2] = btn3;
		arrayButtons[3] = btn4;
		arrayButtons[4] = btn5;
		arrayButtons[5] = btn6;
		arrayButtons[6] = btn7;
		arrayButtons[7] = btn8;
		arrayButtons[8] = btn9;
		arrayButtons[9] = btn10;
		arrayButtons[10] = btn11;
		arrayButtons[11] = btn12;
		arrayButtons[12] = btn13;
		arrayButtons[13] = btn14;
		arrayButtons[14] = btn15;
		arrayButtons[15] = btn16;
		arrayButtons[16] = btn17;
		arrayButtons[17] = btn18;
		arrayButtons[18] = btn19;
		arrayButtons[19] = btn20;
		arrayButtons[20] = btn21;
		arrayButtons[21] = btn22;
		arrayButtons[22] = btn23;
		arrayButtons[23] = btn24;
		arrayButtons[24] = btn25;
		arrayButtons[25] = btn26;
		arrayButtons[26] = btn27;
		arrayButtons[27] = btn28;
		arrayButtons[28] = btn29;
		arrayButtons[29] = btn30;
		arrayButtons[30] = btn31;
		arrayButtons[31] = btn32;
		arrayButtons[32] = btn33;
		arrayButtons[33] = btn34;
		arrayButtons[34] = btn35;
		

		int row = 0;
		int col = 0;
		for (int i = 0; i < 35; i++) {
			arrayButtons[i].setText(calDate[row][col]);
			col++;
			if (col % 7 == 0) {
				row++;
				col = 0;
			}
		}
	}

}
