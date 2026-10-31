package ubuntusure.app;
import javax.swing.*; import ubuntusure.ui.LoginFrame;
public class Main {public static void main(String[] args){SwingUtilities.invokeLater(()->{try{UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}catch(Exception ignored){}new LoginFrame().setVisible(true);});}}
