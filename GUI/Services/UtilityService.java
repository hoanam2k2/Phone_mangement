
package GUI.Services;

import java.io.File;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class UtilityService {
    void selectImage(JLabel lblImage, JFrame frame) {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            ImageService.save(file);
            ImageIcon icon = ImageService.readImage(file.getName(), lblImage);
            lblImage.setIcon(icon);
            lblImage.setToolTipText(file.getName());
        }
    }
    public static String toVnd(float dong) {
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        return currencyVN.format(dong);
    }
}
