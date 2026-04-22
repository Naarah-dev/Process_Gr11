package kt;

import javax.swing.JOptionPane;

public class NewJFrame1 extends javax.swing.JFrame {

    public NewJFrame1() {
        initComponents();
        setLocationRelativeTo(null); // căn giữa màn hình
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtSo1 = new javax.swing.JTextField();
        txtSo2 = new javax.swing.JTextField();
        btnGiai = new javax.swing.JButton();
        txtKetQua = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel1.setText("Giải phương trình bậc 1 (ax + b = 0)");

        jLabel2.setText("Hệ số b:");

        jLabel3.setText("Hệ số a:");

        jLabel4.setText("Kết quả:");

        btnGiai.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnGiai.setText("Giải");
        btnGiai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGiaiActionPerformed(evt);
            }
        });

        txtKetQua.setEditable(false);
        txtKetQua.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
            .addComponent(jLabel1)
            .addGroup(layout.createSequentialGroup()
                .addGap(50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSo1, 120, 120, 120)
                    .addComponent(txtSo2, 120, 120, 120)
                    .addComponent(txtKetQua, 200, 200, 200)
                    .addComponent(btnGiai))
            )
        );

        layout.setVerticalGroup(
            layout.createSequentialGroup()
            .addGap(30)
            .addComponent(jLabel1)
            .addGap(30)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel3)
                .addComponent(txtSo1))
            .addGap(15)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel2)
                .addComponent(txtSo2))
            .addGap(20)
            .addComponent(btnGiai)
            .addGap(15)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel4)
                .addComponent(txtKetQua))
            .addGap(30)
        );

        pack();
    }

    // 🔥 XỬ LÝ NÚT GIẢI
    private void btnGiaiActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            double a = Double.parseDouble(txtSo1.getText());
            double b = Double.parseDouble(txtSo2.getText());

            if (a == 0) {
                if (b == 0) {
                    txtKetQua.setText("Phương trình vô số nghiệm");
                } else {
                    txtKetQua.setText("Phương trình vô nghiệm");
                }
            } else {
                double x = -b / a;
                txtKetQua.setText("x = " + x);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số hợp lệ!");
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new NewJFrame1().setVisible(true));
    }

    // Variables
    private javax.swing.JButton btnGiai;
    private javax.swing.JLabel jLabel1, jLabel2, jLabel3, jLabel4;
    private javax.swing.JTextField txtKetQua, txtSo1, txtSo2;
}