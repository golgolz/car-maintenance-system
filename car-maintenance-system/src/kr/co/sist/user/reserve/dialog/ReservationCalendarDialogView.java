package kr.co.sist.user.reserve.dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class ReservationCalendarDialogView extends JPanel {

  private JLabel jlMonth;
  private JPanel jpCalendar;
  private LocalDate currentDate;
  private JButton dayButton;
  private int selectYear;
  private String selectMonth;


  public ReservationCalendarDialogView() {
    currentDate = LocalDate.now(); // 현재 시간

    jlMonth = new JLabel("", SwingConstants.CENTER);
    JButton prevButton = new JButton("<");
    JButton nextButton = new JButton(">");

    prevButton.addActionListener(e -> showPreviousMonth());
    nextButton.addActionListener(e -> showNextMonth());

    JPanel controlPanel = new JPanel();
    controlPanel.setLayout(new BorderLayout());
    controlPanel.add(prevButton, BorderLayout.WEST);
    controlPanel.add(jlMonth, BorderLayout.CENTER);
    controlPanel.add(nextButton, BorderLayout.EAST);

    jpCalendar = new JPanel(new GridLayout(0, 7));
    updateCalendar();

    setLayout(new BorderLayout());
    add(controlPanel, BorderLayout.NORTH);
    add(jpCalendar, BorderLayout.CENTER);

    setVisible(true);
  }

  private void showPreviousMonth() { // 지난 달
    currentDate = currentDate.minusMonths(1);
    updateCalendar();
  }

  private void showNextMonth() { // 다음 달
    currentDate = currentDate.plusMonths(1);
    updateCalendar();
  }

  private void updateCalendar() {
    YearMonth yearMonth = YearMonth.from(currentDate);
    selectYear = yearMonth.getYear();
    selectMonth = yearMonth.format(DateTimeFormatter.ofPattern("MM"));

    jlMonth.setText(yearMonth.format(DateTimeFormatter.ofPattern("MMMM")));

    jpCalendar.removeAll();

    LocalDate firstDayOfMonth = LocalDate.of(currentDate.getYear(), currentDate.getMonth(), 1);
    int startDayOfWeek = firstDayOfMonth.getDayOfWeek().getValue();

    // 요일 표시
    String[] daysOfWeek = {"일", "월", "화", "수", "목", "금", "토"};
    for (String dayOfWeek : daysOfWeek) {
      JLabel label = new JLabel(dayOfWeek, SwingConstants.CENTER);
      label.setBorder(new TitledBorder(new LineBorder(Color.GRAY)));
      jpCalendar.add(label);
    }

    JLabel jlLine = new JLabel("");
    jlLine.setBorder(new TitledBorder(new LineBorder(Color.GRAY)));

    for (int i = 1; i < startDayOfWeek; i++) {
      jpCalendar.add(jlLine);
    }

    int daysInMonth = yearMonth.lengthOfMonth();
    for (int day = 1; day <= daysInMonth; day++) {
      dayButton = new JButton(String.valueOf(day));
      dayButton.setFocusPainted(true);
      dayButton.setBorder(new TitledBorder(new LineBorder(Color.GRAY)));
      // 각 날짜 버튼에 ActionListener 추가
      ReservationCalendarDialogEvent rcde = new ReservationCalendarDialogEvent(this, dayButton);
      jpCalendar.add(dayButton);
      dayButton.addActionListener(rcde);
    } // end for

    revalidate();
    repaint();
  }// updateCalender


  public JLabel getJlMonth() {
    return jlMonth;
  }

  public JPanel getJpCalendar() {
    return jpCalendar;
  }

  public LocalDate getCurrentDate() {
    return currentDate;
  }

  public JButton getDayButton() {
    return dayButton;
  }

  public int getSelectYear() {
    return selectYear;
  }

  public String getSelectMonth() {
    return selectMonth;
  }

  // public static void main(String[] args) {
  // new ReservationCalendarDialogView();
  // }


}
