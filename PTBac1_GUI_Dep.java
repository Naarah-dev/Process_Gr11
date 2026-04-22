package kt;

import javax.swing.*;
import java.awt.*;

public class PTBac1_GUI_Dep extends JFrame {

    private final JTextField txtA;

    private final JTextField txtB;
    private final JTextField txtKQ;
    private final JButton btnGiai;
    private final JButton btnReset;

    public PTBac1_GUI_Dep() {
        setTitle("Giải phương trình bậc 1");
        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // ===== TIÊU ĐỀ =====
        JLabel title = new JLabel("GIẢI PHƯƠNG TRÌNH BẬC 1", JLabel.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 18));
        title.setForeground(Color.BLUE);

        // ===== PANEL FORM =====
        JPanel form = new JPanel(new GridLayout(3, 2, 10, 10));

        JLabel lbA = new JLabel("Hệ số a:");
        JLabel lbB = new JLabel("Hệ số b:");
        JLabel lbKQ = new JLabel("Kết quả:");

        txtA = new JTextField();
        txtB = new JTextField();
        txtKQ = new JTextField();
        txtKQ.setEditable(false);
        txtKQ.setBackground(new Color(230, 230, 230));

        form.add(lbA); form.add(txtA);
        form.add(lbB); form.add(txtB);
        form.add(lbKQ); form.add(txtKQ);

        // ===== PANEL BUTTON =====
        JPanel btnPanel = new JPanel();

        btnGiai = new JButton("Giải");
        btnReset = new JButton("Reset");

        btnGiai.setBackground(new Color(0, 123, 255));
        btnGiai.setForeground(Color.WHITE);

        btnReset.setBackground(Color.GRAY);
        btnReset.setForeground(Color.WHITE);

        btnPanel.add(btnGiai);
        btnPanel.add(btnReset);

        // ===== SỰ KIỆN =====
        btnGiai.addActionListener(e -> giai());
        btnReset.addActionListener(e -> reset());

        // ===== LAYOUT CHÍNH =====
        setLayout(new BorderLayout(10, 10));
        add(title, BorderLayout.NORTH);
        add(form, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);

        // padding
        ((JComponent) getContentPane()).setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
    }

    // 🔥 xử lý
    private void giai() {
        try {
            double a = Double.parseDouble(txtA.getText());
            double b = Double.parseDouble(txtB.getText());

            if (a == 0) {
                if (b == 0) {
                    txtKQ.setText("Vô số nghiệm");
                } else {
                    txtKQ.setText("Vô nghiệm");
                }
            } else {
                double x = -b / a;
                txtKQ.setText("x = " + String.format("%.2f", x));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Nhập số hợp lệ!");
        }
    }

    private void reset() {
        txtA.setText("");
        txtB.setText("");
        txtKQ.setText("");
    }

    public static void main(String[] args) {
        new PTBac1_GUI_Dep().setVisible(true);
    }
}