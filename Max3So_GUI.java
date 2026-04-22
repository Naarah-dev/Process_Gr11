package kt;

import javax.swing.*;
import java.awt.*;

public class Max3So_GUI extends JFrame {

    private final JTextField txtA;
    private final JTextField txtB;

    private final JTextField txtC;
    private final JTextField txtKQ;
    private final JButton btnTim;
    private final JButton btnReset;

    public Max3So_GUI() {
        setTitle("Tìm số lớn nhất");
        setSize(400, 260);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // ===== TITLE =====
        JLabel title = new JLabel("TÌM SỐ LỚN NHẤT CỦA 3 SỐ", JLabel.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 18));
        title.setForeground(Color.BLUE);

        // ===== FORM =====
        JPanel form = new JPanel(new GridLayout(4, 2, 10, 10));

        JLabel lbA = new JLabel("Số a:");
        JLabel lbB = new JLabel("Số b:");
        JLabel lbC = new JLabel("Số c:");
        JLabel lbKQ = new JLabel("Kết quả:");

        txtA = new JTextField();
        txtB = new JTextField();
        txtC = new JTextField();
        txtKQ = new JTextField();
        txtKQ.setEditable(false);
        txtKQ.setBackground(new Color(230, 230, 230));

        form.add(lbA); form.add(txtA);
        form.add(lbB); form.add(txtB);
        form.add(lbC); form.add(txtC);
        form.add(lbKQ); form.add(txtKQ);

        // ===== BUTTON =====
        JPanel btnPanel = new JPanel();

        btnTim = new JButton("Tìm");
        btnReset = new JButton("Reset");

        btnTim.setBackground(new Color(0, 123, 255));
        btnTim.setForeground(Color.WHITE);

        btnReset.setBackground(Color.GRAY);
        btnReset.setForeground(Color.WHITE);

        btnPanel.add(btnTim);
        btnPanel.add(btnReset);

        // ===== EVENT =====
        btnTim.addActionListener(e -> timMax());
        btnReset.addActionListener(e -> reset());

        // ===== LAYOUT =====
        setLayout(new BorderLayout(10, 10));
        add(title, BorderLayout.NORTH);
        add(form, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);

        ((JComponent) getContentPane()).setBorder(
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        );
    }

    // 🔥 xử lý tìm max
    private void timMax() {
        try {
            double a = Double.parseDouble(txtA.getText());
            double b = Double.parseDouble(txtB.getText());
            double c = Double.parseDouble(txtC.getText());

            double max = a;

            if (b > max) max = b;
            if (c > max) max = c;

            txtKQ.setText("Max = " + max);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Nhập số hợp lệ!");
        }
    }

    private void reset() {
        txtA.setText("");
        txtB.setText("");
        txtC.setText("");
        txtKQ.setText("");
    }

    public static void main(String[] args) {
        new Max3So_GUI().setVisible(true);
    }
}