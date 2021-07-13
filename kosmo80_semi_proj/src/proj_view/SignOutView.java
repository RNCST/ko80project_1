package proj_view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import proj_back.DBLogic;

public class SignOutView extends JDialog implements ActionListener {
	JButton jb_signOut = null;
	JButton jb_cancel  = null;
	
	JTextField jtf_id  = null;
	JTextField jtf_pw  = null;
	JTextField jtf_signOutCheck = null;
	
	JLabel     jl_id   = null;
	JLabel     jl_pw   = null;
	JLabel     jl_signOutCheck   = null;
	JLabel     information = null;
	
	DBLogic dblogic = new DBLogic();
	
	public static void main(String[] args) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
