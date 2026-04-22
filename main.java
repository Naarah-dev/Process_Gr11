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
