package maserucommunityservice;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.GridLayout;

public class MaseruCommunityService {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Maseru Community Service");

        frame.setSize(800, 600);

        frame.setLayout(new BorderLayout());

        JPanel headerPanel = new JPanel();

        frame.add(headerPanel, BorderLayout.NORTH);

        headerPanel.setLayout(new GridLayout(3, 1));

        headerPanel.setBackground(new Color(0,0,130));

        //1st Label
        JLabel titleLabel = new JLabel("Maseru Community Service");

        titleLabel.setFont(new Font("Corbel", Font.BOLD, 30));

        titleLabel.setForeground(Color.white);

        headerPanel.add(titleLabel);
        
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        //2nd Label
        JLabel subtitleLabel = new JLabel("Service Booking System");
        subtitleLabel.setFont(new Font("Corbel", Font.BOLD, 20));
        subtitleLabel.setForeground(Color.white);

        headerPanel.add(subtitleLabel);
        
        subtitleLabel.setHorizontalAlignment(JLabel.CENTER);

        //3rd Label
        JLabel sloganLabel = new JLabel("Empowering our community through skills, access and support");
        sloganLabel.setFont(new Font("Corbel", Font.PLAIN, 14));
        sloganLabel.setForeground(Color.white);

        headerPanel.add(sloganLabel);
        
        sloganLabel.setHorizontalAlignment(JLabel.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
        
        //mainPanel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2, 2));
        frame.add(mainPanel, BorderLayout.CENTER);
    }

}
