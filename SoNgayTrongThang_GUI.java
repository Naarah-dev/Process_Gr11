package kt;

import javax.swing.*;
import java.awt.*;

public class SoNgayTrongThang_GUI extends JFrame {

    private final JTextField txtThang;

    private final JTextField txtNam;
    private final JTextField txtKQ;
    private final JButton btnTinh;
    private final JButton btnReset;

    public SoNgayTrongThang_GUI() {
        setTitle("Số ngày trong tháng");
        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // ===== TITLE =====
        JLabel title = new JLabel("TÍNH SỐ NGÀY TRONG THÁNG", JLabel.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 18));
        title.setForeground(Color.BLUE);

        // ===== FORM =====
        JPanel form = new JPanel(new GridLayout(3, 2, 10, 10));

        JLabel lbThang = new JLabel("Tháng:");
        JLabel lbNam = new JLabel("Năm:");
        JLabel lbKQ = new JLabel("Kết quả:");

        txtThang = new JTextField();
        txtNam = new JTextField();
        txtKQ = new JTextField();
        txtKQ.setEditable(false);
        txtKQ.setBackground(new Color(230, 230, 230));

        form.add(lbThang); form.add(txtThang);
        form.add(lbNam); form.add(txtNam);
        form.add(lbKQ); form.add(txtKQ);

        // ===== BUTTON =====
        JPanel btnPanel = new JPanel();

        btnTinh = new JButton("Tính");
        btnReset = new JButton("Reset");

        btnTinh.setBackground(new Color(0, 123, 255));
        btnTinh.setForeground(Color.WHITE);

        btnReset.setBackground(Color.GRAY);
        btnReset.setForeground(Color.WHITE);

        btnPanel.add(btnTinh);
        btnPanel.add(btnReset);

        // ===== EVENT =====
        btnTinh.addActionListener(e -> tinh());
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

    // 🔥 xử lý
    private void tinh() {
        try {
            int thang = Integer.parseInt(txtThang.getText());
            int nam = Integer.parseInt(txtNam.getText());

            int soNgay;

            switch (thang) {
                case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                    soNgay = 31;
                    break;
                case 4: case 6: case 9: case 11:
                    soNgay = 30;
                    break;
                case 2:
                    // kiểm tra năm nhuận
                    if ((nam % 4 == 0 && nam % 100 != 0) || (nam % 400 == 0)) {
                        soNgay = 29;
                    } else {
                        soNgay = 28;
                    }
                    break;
                default:
                    txtKQ.setText("Tháng không hợp lệ");
                    return;
            }

            txtKQ.setText("Tháng " + thang + " có " + soNgay + " ngày");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Nhập số hợp lệ!");
        }
    }

    private void reset() {
        txtThang.setText("");
        txtNam.setText("");
        txtKQ.setText("");
    }

    public static void main(String[] args) {
        new SoNgayTrongThang_GUI().setVisible(true);
    }
}