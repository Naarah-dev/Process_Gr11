package kt;

import javax.swing.JOptionPane;

public class Bai1_HCN_GUI extends javax.swing.JFrame {

    public Bai1_HCN_GUI() {
        initComponents();
        setLocationRelativeTo(null); // căn giữa
    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel("TÍNH DIỆN TÍCH HCN");
        jLabel2 = new javax.swing.JLabel("Chiều dài:");
        jLabel3 = new javax.swing.JLabel("Chiều rộng:");
        jLabel4 = new javax.swing.JLabel("Kết quả:");

        txtDai = new javax.swing.JTextField(10);
        txtRong = new javax.swing.JTextField(10);
        txtKQ = new javax.swing.JTextField(20);
        txtKQ.setEditable(false);

        btnTinh = new javax.swing.JButton("Tính");
        btnReset = new javax.swing.JButton("Reset");

        // sự kiện
        btnTinh.addActionListener(e -> tinh());
        btnReset.addActionListener(e -> reset());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.JPanel p = new javax.swing.JPanel();

        p.add(jLabel1);
        p.add(jLabel2); p.add(txtDai);
        p.add(jLabel3); p.add(txtRong);
        p.add(btnTinh);
        p.add(btnReset);
        p.add(jLabel4); p.add(txtKQ);

        add(p);
        pack();
    }

    // 🔥 xử lý tính
    private void tinh() {
        try {
            double dai = Double.parseDouble(txtDai.getText());
            double rong = Double.parseDouble(txtRong.getText());

            if (dai <= 0 || rong <= 0) {
                txtKQ.setText("Dữ liệu phải > 0");
                return;
            }

            double dienTich = dai * rong;
            txtKQ.setText("Diện tích = " + dienTich);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Nhập số hợp lệ!");
        }
    }

    // 🔄 reset
    private void reset() {
        txtDai.setText("");
        txtRong.setText("");
        txtKQ.setText("");
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new Bai1_HCN_GUI().setVisible(true));
    }

    // biến
    private javax.swing.JButton btnTinh, btnReset;
    private javax.swing.JLabel jLabel1, jLabel2, jLabel3, jLabel4;
    private javax.swing.JTextField txtDai, txtRong, txtKQ;
}