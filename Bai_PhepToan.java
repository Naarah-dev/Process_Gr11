package kt;

import javax.swing.JOptionPane;

public class Bai_PhepToan extends javax.swing.JFrame {

    public Bai_PhepToan() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel("PHÉP TOÁN CƠ BẢN");
        jLabel2 = new javax.swing.JLabel("Số 1:");
        jLabel3 = new javax.swing.JLabel("Số 2:");
        jLabel4 = new javax.swing.JLabel("Phép tính:");
        jLabel5 = new javax.swing.JLabel("Kết quả:");

        txtSo1 = new javax.swing.JTextField(10);
        txtSo2 = new javax.swing.JTextField(10);
        txtKQ = new javax.swing.JTextField(20);
        txtKQ.setEditable(false);

        // Combobox chọn phép toán
        cboPhep = new javax.swing.JComboBox<>(new String[]{"+", "-", "*", "/"});

        btnTinh = new javax.swing.JButton("Tính");
        btnReset = new javax.swing.JButton("Reset");

        btnTinh.addActionListener(e -> tinh());
        btnReset.addActionListener(e -> reset());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.JPanel p = new javax.swing.JPanel();

        p.add(jLabel1);
        p.add(jLabel2); p.add(txtSo1);
        p.add(jLabel3); p.add(txtSo2);
        p.add(jLabel4); p.add(cboPhep);
        p.add(btnTinh);
        p.add(btnReset);
        p.add(jLabel5); p.add(txtKQ);

        add(p);
        pack();
    }

    // 🔥 xử lý tính toán
    private void tinh() {
        try {
            double a = Double.parseDouble(txtSo1.getText());
            double b = Double.parseDouble(txtSo2.getText());
            String op = (String) cboPhep.getSelectedItem();

            double kq = 0;

            switch (op) {
                case "+":
                    kq = a + b;
                    break;
                case "-":
                    kq = a - b;
                    break;
                case "*":
                    kq = a * b;
                    break;
                case "/":
                    if (b == 0) {
                        txtKQ.setText("Không chia cho 0");
                        return;
                    }
                    kq = a / b;
                    break;
            }

            txtKQ.setText(a + " " + op + " " + b + " = " + kq);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Nhập số hợp lệ!");
        }
    }

    // 🔄 reset
    private void reset() {
        txtSo1.setText("");
        txtSo2.setText("");
        txtKQ.setText("");
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new Bai_PhepToan().setVisible(true));
    }

    // biến
    private javax.swing.JButton btnTinh, btnReset;
    private javax.swing.JComboBox<String> cboPhep;
    private javax.swing.JLabel jLabel1, jLabel2, jLabel3, jLabel4, jLabel5;
    private javax.swing.JTextField txtSo1, txtSo2, txtKQ;
}