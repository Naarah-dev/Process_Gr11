package process;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame {

    private JTextArea txtResult;
    private JPanel mainPanel;

    public Main() {
        setTitle("Bài Tập Java");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel chứa các nút
        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new GridLayout(4, 2, 10, 10));
        btnPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton btnCau1 = new JButton("Câu 1: Diện tích HCN");
        JButton btnCau2 = new JButton("Câu 2: Tiền Taxi");
        JButton btnCau3 = new JButton("Câu 3: Máy tính");
        JButton btnCau4 = new JButton("Câu 4: PT bậc nhất");
        JButton btnCau5 = new JButton("Câu 5: Số lớn nhất");
        JButton btnCau6 = new JButton("Câu 6: Số ngày trong tháng");
        JButton btnCau7 = new JButton("Câu 7: Sắp xếp tăng dần");
        JButton btnCau8 = new JButton("Câu 8: Số nguyên tố");

        btnPanel.add(btnCau1);
        btnPanel.add(btnCau2);
        btnPanel.add(btnCau3);
        btnPanel.add(btnCau4);
        btnPanel.add(btnCau5);
        btnPanel.add(btnCau6);
        btnPanel.add(btnCau7);
        btnPanel.add(btnCau8);

        // Text area hiển thị kết quả
        txtResult = new JTextArea();
        txtResult.setEditable(false);
        txtResult.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(txtResult);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Kết quả"));

        add(btnPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // ==================== SỰ KIỆN ====================

        // Câu 1: Diện tích hình chữ nhật
        btnCau1.addActionListener(e -> cau1_DienTichHCN());

        // Câu 2: Tiền Taxi
        btnCau2.addActionListener(e -> cau2_TienTaxi());

        // Câu 3: Máy tính đơn giản
        btnCau3.addActionListener(e -> cau3_MayTinh());

        // Câu 4: Phương trình bậc nhất
        btnCau4.addActionListener(e -> cau4_PTBacNhat());

        // Câu 5: Số lớn nhất
        btnCau5.addActionListener(e -> cau5_SoLonNhat());

        // Câu 6: Số ngày trong tháng
        btnCau6.addActionListener(e -> cau6_SoNgayTrongThang());

        // Câu 7: Sắp xếp tăng dần
        btnCau7.addActionListener(e -> cau7_SapXepTangDan());

        // Câu 8: Kiểm tra số nguyên tố
        btnCau8.addActionListener(e -> cau8_SoNguyenTo());
    }

    // ===================== CÂU 1 =====================
    private void cau1_DienTichHCN() {
        txtResult.setText("");
        double chieuDai, chieuRong;

        while (true) {
            String input = JOptionPane.showInputDialog(this, "Nhập chiều dài:");
            if (input == null) return;
            try {
                chieuDai = Double.parseDouble(input);
                if (chieuDai <= 0) {
                    txtResult.append("Nhập chiều dài: " + input + "\nNhập sai.\n");
                    continue;
                }
                txtResult.append("Nhập chiều dài: " + chieuDai + "\n");
                break;
            } catch (NumberFormatException ex) {
                txtResult.append("Nhập sai. Vui lòng nhập số.\n");
            }
        }

        while (true) {
            String input = JOptionPane.showInputDialog(this, "Nhập chiều rộng:");
            if (input == null) return;
            try {
                chieuRong = Double.parseDouble(input);
                if (chieuRong <= 0) {
                    txtResult.append("Nhập chiều rộng: " + input + "\nNhập sai.\n");
                    continue;
                }
                txtResult.append("Nhập chiều rộng: " + chieuRong + "\n");
                break;
            } catch (NumberFormatException ex) {
                txtResult.append("Nhập sai. Vui lòng nhập số.\n");
            }
        }

        double dienTich = chieuDai * chieuRong;
        txtResult.append("Diện tích hình chữ nhật là: " + dienTich + "\n");
    }

    // ===================== CÂU 2 =====================
    private void cau2_TienTaxi() {
        txtResult.setText("");
        String input = JOptionPane.showInputDialog(this, "Nhập số km:");
        if (input == null) return;

        try {
            double km = Double.parseDouble(input);
            if (km < 0) {
                txtResult.append("Nhập số km: " + km + "\nNhập dữ liệu sai!\n");
            } else {
                double tien = km * 10000;
                txtResult.append("Nhập số km: " + km + "\n");
                txtResult.append("Tiền taxi: " + String.format("%,.0f", tien) + " VNĐ\n");
            }
        } catch (NumberFormatException ex) {
            txtResult.append("Nhập sai. Vui lòng nhập số.\n");
        }
    }

    // ===================== CÂU 3 =====================
    private void cau3_MayTinh() {
        txtResult.setText("");
        try {
            String inputA = JOptionPane.showInputDialog(this, "Nhập a:");
            if (inputA == null) return;
            double a = Double.parseDouble(inputA);

            String inputB = JOptionPane.showInputDialog(this, "Nhập b:");
            if (inputB == null) return;
            double b = Double.parseDouble(inputB);

            String[] phepTinh = {"+", "-", "*", "/"};
            String chon = (String) JOptionPane.showInputDialog(this,
                    "Chọn phép tính:", "Phép tính",
                    JOptionPane.QUESTION_MESSAGE, null, phepTinh, phepTinh[0]);
            if (chon == null) return;

            double ketQua = 0;
            boolean valid = true;

            switch (chon) {
                case "+":
                    ketQua = a + b;
                    break;
                case "-":
                    ketQua = a - b;
                    break;
                case "*":
                    ketQua = a * b;
                    break;
                case "/":
                    if (b == 0) {
                        txtResult.append("Không thể chia cho 0!\n");
                        valid = false;
                    } else {
                        ketQua = a / b;
                    }
                    break;
            }

            txtResult.append("Nhập a: " + a + "\n");
            txtResult.append("Nhập b: " + b + "\n");
            txtResult.append("Chọn phép tính: " + chon + "\n");
            if (valid) {
                txtResult.append("Kết quả: " + a + " " + chon + " " + b + " = " + ketQua + "\n");
            }
        } catch (NumberFormatException ex) {
            txtResult.append("Nhập sai. Vui lòng nhập số.\n");
        }
    }

    // ===================== CÂU 4 =====================
    private void cau4_PTBacNhat() {
        txtResult.setText("");
        try {
            String inputA = JOptionPane.showInputDialog(this, "Nhập a:");
            if (inputA == null) return;
            double a = Double.parseDouble(inputA);

            String inputB = JOptionPane.showInputDialog(this, "Nhập b:");
            if (inputB == null) return;
            double b = Double.parseDouble(inputB);

            txtResult.append("Nhập a: " + a + "\n");
            txtResult.append("Nhập b: " + b + "\n");

            String dau = (b >= 0) ? " + " : " - ";
            String bStr = (b >= 0) ? String.valueOf(b) : String.valueOf(Math.abs(b));

            if (a == 0 && b == 0) {
                txtResult.append("Phương trình " + a + "x" + dau + bStr + " = 0 vô số nghiệm\n");
            } else if (a == 0) {
                txtResult.append("Phương trình " + a + "x" + dau + bStr + " = 0 vô nghiệm\n");
            } else {
                double x = -b / a;
                txtResult.append("Phương trình " + a + "x" + dau + bStr + " = 0 có nghiệm là: x = " + x + "\n");
            }
        } catch (NumberFormatException ex) {
            txtResult.append("Nhập sai. Vui lòng nhập số.\n");
        }
    }

    // ===================== CÂU 5 =====================
    private void cau5_SoLonNhat() {
        txtResult.setText("");
        try {
            String inputA = JOptionPane.showInputDialog(this, "Nhập a:");
            if (inputA == null) return;
            double a = Double.parseDouble(inputA);

            String inputB = JOptionPane.showInputDialog(this, "Nhập b:");
            if (inputB == null) return;
            double b = Double.parseDouble(inputB);

            String inputC = JOptionPane.showInputDialog(this, "Nhập c (bỏ trống nếu chỉ 2 số):");

            if (inputC == null || inputC.trim().isEmpty()) {
                double max = Math.max(a, b);
                txtResult.append("Nhập a: " + a + "\n");
                txtResult.append("Nhập b: " + b + "\n");
                txtResult.append("Số lớn nhất của hai số " + a + ", " + b + " là " + max + "\n");
            } else {
                double c = Double.parseDouble(inputC);
                double max = Math.max(a, Math.max(b, c));
                txtResult.append("Nhập a: " + a + "\n");
                txtResult.append("Nhập b: " + b + "\n");
                txtResult.append("Nhập c: " + c + "\n");
                txtResult.append("Số lớn nhất của ba số " + a + ", " + b + ", " + c + " là " + max + "\n");
            }
        } catch (NumberFormatException ex) {
            txtResult.append("Nhập sai. Vui lòng nhập số.\n");
        }
    }

    // ===================== CÂU 6 =====================
    private void cau6_SoNgayTrongThang() {
        txtResult.setText("");
        try {
            String inputThang = JOptionPane.showInputDialog(this, "Nhập tháng (1-12):");
            if (inputThang == null) return;
            int thang = Integer.parseInt(inputThang);

            if (thang < 1 || thang > 12) {
                txtResult.append("Tháng không hợp lệ!\n");
                return;
            }

            int soNgay = 0;
            boolean canNam = false;

            switch (thang) {
                case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                    soNgay = 31;
                    break;
                case 4: case 6: case 9: case 11:
                    soNgay = 30;
                    break;
                case 2:
                    canNam = true;
                    break;
            }

            if (canNam) {
                String inputNam = JOptionPane.showInputDialog(this, "Nhập năm:");
                if (inputNam == null) return;
                int nam = Integer.parseInt(inputNam);

                boolean nhuan = (nam % 4 == 0 && nam % 100 != 0) || (nam % 400 == 0);
                soNgay = nhuan ? 29 : 28;

                txtResult.append("Nhập tháng: " + thang + ", năm: " + nam + "\n");
                txtResult.append("Tháng " + thang + " năm " + nam + " có " + soNgay + " ngày\n");
            } else {
                txtResult.append("Nhập tháng: " + thang + "\n");
                txtResult.append("Tháng " + thang + " có " + soNgay + " ngày\n");
            }
        } catch (NumberFormatException ex) {
            txtResult.append("Nhập sai. Vui lòng nhập số.\n");
        }
    }

    // ===================== CÂU 7 =====================
    private void cau7_SapXepTangDan() {
        txtResult.setText("");
        try {
            String inputA = JOptionPane.showInputDialog(this, "Nhập a:");
            if (inputA == null) return;
            double a = Double.parseDouble(inputA);

            String inputB = JOptionPane.showInputDialog(this, "Nhập b:");
            if (inputB == null) return;
            double b = Double.parseDouble(inputB);

            String inputC = JOptionPane.showInputDialog(this, "Nhập c:");
            if (inputC == null) return;
            double c = Double.parseDouble(inputC);

            txtResult.append("Nhập a: " + a + "\n");
            txtResult.append("Nhập b: " + b + "\n");
            txtResult.append("Nhập c: " + c + "\n");

            // Sắp xếp tăng dần
            double temp;
            if (a > b) { temp = a; a = b; b = temp; }
            if (a > c) { temp = a; a = c; c = temp; }
            if (b > c) { temp = b; b = c; c = temp; }

            txtResult.append("Thứ tự tăng dần: " + a + ", " + b + ", " + c + "\n");
        } catch (NumberFormatException ex) {
            txtResult.append("Nhập sai. Vui lòng nhập số.\n");
        }
    }

    // ===================== CÂU 8 =====================
    private void cau8_SoNguyenTo() {
        txtResult.setText("");
        try {
            String input = JOptionPane.showInputDialog(this, "Nhập a:");
            if (input == null) return;
            int a = Integer.parseInt(input);

            txtResult.append("Nhập a: " + a + "\n");

            if (a < 2) {
                txtResult.append(a + " không phải là số nguyên tố\n");
                return;
            }

            boolean laNguyenTo = true;
            for (int i = 2; i <= Math.sqrt(a); i++) {
                if (a % i == 0) {
                    laNguyenTo = false;
                    break;
                }
            }

            if (laNguyenTo) {
                txtResult.append(a + " là số nguyên tố\n");
            } else {
                txtResult.append(a + " không phải là số nguyên tố\n");
            }
        } catch (NumberFormatException ex) {
            txtResult.append("Nhập sai. Vui lòng nhập số nguyên.\n");
        }
    }

    // ===================== MAIN =====================
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main frame = new Main();
            frame.setVisible(true);
        });
    }
}