package study0605;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login {

	public static void main(String[] args) {
		Login1 g = new Login1();
	}
}

class Login1 extends Frame implements ActionListener{
	//ȭ���߾ӹ�ġ�� ���� 
	Dimension dimen, dimen1;  int xpos, ypos;
	
	//init�� ȭ�� ���� ���̾ƿ� ������...
	Label lbTitle = new Label("�α���ȭ��");
	Label lbId = new Label("���̵�: ");	
	Label lbPw = new Label("�н�����: ");	
	
	TextField tfId = new TextField(15);
	TextField tfPw = new TextField(15);
	
	Button btnlogin = new Button("�α���");
	Button btnregi = new Button("ȸ������");
	
	Connection conn = null;
	String url = "jdbc:mysql://127.0.0.1:3306/study?useUnicode=true&characterEncoding=utf8";
	String id = "root";// ID
	String pass = "qwer";// ��й�ȣ	
	
	//��� ����Ÿ ���Կ�
	PreparedStatement pstmt = null;	
		
	//��� ��ȸ��
	Statement stmt = null;
	ResultSet rs = null;
	
	String result="";//�ؽ�Ʈ���̸�� �����ؼ� �ѹ��� ����ϱ����ؼ� 
	
	Login1()
	{
		init();//ȭ�鱸��		
		center();//�߾ӹ�ġ
		start();//�̺�Ʈ
	}
	void center()
	{
		dimen = Toolkit.getDefaultToolkit().getScreenSize();
		dimen1 = this.getSize();
		xpos = (int) (dimen.getWidth() / 2 - dimen1.getWidth() / 2);
		ypos = (int) (dimen.getHeight() / 2 - dimen1.getHeight() / 2);
		this.setLocation(xpos, ypos);
	}
	void init()
	{
		this.setSize(500, 500);	
		this.setVisible(true);
		
		this.setLayout(null);
		
		Font font30 = new Font("SansSerif", Font.BOLD, 30);
		Font font20 = new Font("SansSerif", Font.BOLD, 20);
		Font font15 = new Font("SansSerif", Font.BOLD, 15);
		Font font10 = new Font("SansSerif", Font.BOLD, 10);
		
		//Ÿ��Ʋ
		this.add(lbTitle);
		lbTitle.setBounds(170, 60, 300, 30);		
		lbTitle.setFont(font30);
		
		this.add(lbId);
		lbId.setBounds(100, 150, 100, 40);		
		lbId.setFont(font20);
		
		this.add(lbPw);
		lbPw.setBounds(100, 200, 100, 40);		
		lbPw.setFont(font20);
		
		this.add(tfId);
		tfId.setBounds(200, 150, 150, 40);		
		tfId.setFont(font15);
		
		this.add(tfPw);
		tfPw.setBounds(200, 200, 150, 40);		
		tfPw.setFont(font15);
		tfPw.setEchoChar('*');
		
		this.add(btnlogin);
		btnlogin.setBounds(170, 300, 150, 50);		
		btnlogin.setFont(font15);
		this.add(btnregi);
		btnregi.setBounds(170, 370, 150, 50);		
		btnregi.setFont(font15);
		
	}
	void start()
	{
		btnlogin.addActionListener(this);
		btnregi.addActionListener(this);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	void regi()
	{
		Frame f = new Frame();
		f.setSize(500, 700);
		//����,���� 500,700 �������� ������â�� �����ϴ� �ڵ�
	
		f.setLayout(null);
		
		dimen = Toolkit.getDefaultToolkit().getScreenSize();
		dimen1 = f.getSize();
		xpos = (int) (dimen.getWidth() / 2 - dimen1.getWidth() / 2);
		ypos = (int) (dimen.getHeight() / 2 - dimen1.getHeight() / 2);
		f.setLocation(xpos, ypos);
	
		Font font30 = new Font("SansSerif", Font.BOLD, 30);
		Font font20 = new Font("SansSerif", Font.BOLD, 20);
		Font font15 = new Font("SansSerif", Font.BOLD, 15);
		Font font10 = new Font("SansSerif", Font.BOLD, 10);
	
		Label lbTitle1 = new Label("ȸ������ȭ��");
		Label lbId1 = new Label("���̵�");
		Label lbPw1 = new Label("�н�����");
		Label lbPwc1 = new Label("�н�����Ȯ��");
		Label lbPwcc = new Label("");
		Label lbName = new Label("�̸�");
		Label lbPhone = new Label("�޴���ȭ");
		Label lbAddr = new Label("�ּ�");
		TextField tfId1 = new TextField(15);
		TextField tfPw1 = new TextField(15);
		TextField tfPwc1 = new TextField(15);
		TextField tfName = new TextField(15);
		TextField tfPhone = new TextField(15);
		TextField tfAddr = new TextField(15);
		Button bt = new Button("�����ϱ�");
		Button btCheck = new Button("�ߺ�üũ");
		tfPw1.setEchoChar('*');
		tfPwc1.setEchoChar('*');
	
		f.add(lbTitle1);
		lbTitle1.setBounds(150, 60, 300, 30);		
		lbTitle1.setFont(font30);
	
		f.add(lbId1);
		lbId1.setBounds(100, 120, 100, 30);		
		lbId1.setFont(font15);
		f.add(tfId1);
		tfId1.setBounds(100, 160, 200, 30);		
		tfId1.setFont(font15);
	
		f.add(btCheck);
		btCheck.setBounds(320, 160, 120, 30);		
		btCheck.setFont(font15);
	
		f.add(lbPw1);
		lbPw1.setBounds(100, 200, 100, 30);		
		lbPw1.setFont(font15);
	
		f.add(tfPw1);
		tfPw1.setBounds(100, 240, 200, 30);		
		tfPw1.setFont(font15);
	
		f.add(lbPwc1);
		lbPwc1.setBounds(100, 280, 100, 30);		
		lbPwc1.setFont(font15);
	
		f.add(tfPwc1);
		tfPwc1.setBounds(100, 320, 200, 30);		
		tfPwc1.setFont(font15);
		f.add(lbPwcc);
		lbPwcc.setBounds(300, 320, 200, 30);		
		lbPwcc.setFont(font15);
	
		f.add(lbName);
		lbName.setBounds(100, 360, 100, 30);		
		lbName.setFont(font15);
	
		f.add(tfName);
		tfName.setBounds(100, 400, 200, 30);		
		tfName.setFont(font15);
	
		f.add(lbPhone);
		lbPhone.setBounds(100, 440, 100, 30);		
		lbPhone.setFont(font15);
	
		f.add(tfPhone);
		tfPhone.setBounds(100, 480, 200, 30);		
		tfPhone.setFont(font15);
	
		f.add(lbAddr);
		lbAddr.setBounds(100, 520, 100, 30);		
		lbAddr.setFont(font15);
	
		f.add(tfAddr);
		tfAddr.setBounds(100, 560, 200, 30);		
		tfAddr.setFont(font15);
	
		f.add(bt);
		bt.setBounds(170, 600, 150, 50);		
		bt.setFont(font15);
		
		String pw1 = tfPw1.getText();
		String pwc1 = tfPwc1.getText();
		
		bt.addActionListener(new ActionListener() 
		{
		public void actionPerformed(ActionEvent e)
		{
			try 
			{
				String id1 = tfId1.getText();
				String pw = tfPw1.getText();
				String pwc = tfPwc1.getText();
				String name = tfName.getText();
				String phone = tfPhone.getText();
				String addr = tfAddr.getText();
			
				//��� ����
				conn = DriverManager.getConnection(url, id, pass);
				//���Եɶ� ������
				String query = "insert into members values (null, ?, ?, ?, ?, ?)";

				//������ ����
				pstmt = conn.prepareStatement(query);	
				
				//pstmt�� ���Ե� �������� ž��
				pstmt.setString(1, id1);
				pstmt.setString(2, pw);
				pstmt.setString(3, name);
				pstmt.setString(4, phone);
				pstmt.setString(5, addr);
				pstmt.executeUpdate();
			
				Frame f = new Frame();
				f.setSize(500, 300);
			
				f.setLayout(null);	
			
				Font font30 = new Font("SansSerif", Font.BOLD, 30);
				Font font20 = new Font("SansSerif", Font.BOLD, 20);
				Font font15 = new Font("SansSerif", Font.BOLD, 15);
				Font font10 = new Font("SansSerif", Font.BOLD, 10);
			
				Label lbTitle3 = new Label("ȸ�������� �Ϸ�Ǿ����ϴ�");
			
				f.add(lbTitle3);
				lbTitle3.setBounds(50, 60, 300, 30);		
				lbTitle3.setFont(font20);
			
				f.setLocation(xpos+60, 550);
				f.setVisible(true);//ȭ�鿡 ������â�� �����ִ� �ڵ�
			
				f.addWindowListener(new WindowAdapter() 
				{
					public void windowClosing(WindowEvent e) 
					{
						f.setVisible(false);
					}
				});
			
				
		} 
		catch (SQLException e1) {}	
			
		}
	});
	
	btCheck.addActionListener(new ActionListener() 
	{
		public void actionPerformed(ActionEvent e)
		{
			//�˻�����̵Ǵ� �̸� ��������
			String idCheck = tfId1.getText();
			
			//��񿡼� ������ �����ͼ� �ؽ�Ʈ���̸�� �ѷ��ֱ�				
			try 
			{
				//��� ������ ���� conn���� ����
				conn = DriverManager.getConnection(url, id, pass);
				//��񿡿���
				stmt = conn.createStatement();
				//��񿡼� ��ȸ�� ��� ����Ÿ�� �����ͼ� rs�� ����
				rs = stmt.executeQuery("select * from members");
				//��񿡼� ��ȸ�� ��絥��Ÿ�� ����� r�� ���� ���پ� üũ�ؼ� ���������� �ݺ�
				while (rs.next()) 
				{
					//���پ� �ݺ��ϸ鼭 result.�� �����ؼ� ����
					//getString�� ���̺��� �÷��� �������� ����Ÿ�� �����ü� ����.
					if(idCheck.equals(rs.getString("id")))
					{
						System.out.println("�ߺ��Ⱦ��̵� �ֽ��ϴ�!");
					}
							
				}				
					rs.close();
				} catch (SQLException error)
			{
					System.err.println("error = " + error.toString());			
				}	
		}
	});
	
	
	f.addWindowListener(new WindowAdapter() 
	{
		public void windowClosing(WindowEvent e) 
		{
			f.setVisible(false);
		}
	});
	
	f.setVisible(true);//ȭ�鿡 ������â�� �����ִ� �ڵ�
	
}

	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		if(e.getSource()==btnregi)
		{
			regi();
		}
		
		if(e.getSource()==btnlogin)
		{
			String idin = tfId.getText();
			String pwin = tfPw.getText();
			
			//��񿡼� ������ �����ͼ� �ؽ�Ʈ���̸�� �ѷ��ֱ�				
			try 
			{
				//��� ������ ���� conn���� ����
				conn = DriverManager.getConnection(url, id, pass);
				//��񿡿���
				stmt = conn.createStatement();
				//��񿡼� ��ȸ�� ��� ����Ÿ�� �����ͼ� rs�� ����
				rs = stmt.executeQuery("select * from members");
				//��񿡼� ��ȸ�� ��絥��Ÿ�� ����� r�� ���� ���پ� üũ�ؼ� ���������� �ݺ�
				while (rs.next()) 
				{
					//���پ� �ݺ��ϸ鼭 result.�� �����ؼ� ����
					//getString�� ���̺��� �÷��� �������� ����Ÿ�� �����ü� ����.
					if(idin.equals(rs.getString("id")) && pwin.equals(rs.getString("pw")))
					{
						Frame fa = new Frame();
						fa.setSize(500, 500);
						//����,���� 500,700 �������� ������â�� �����ϴ� �ڵ�
						
						fa.setLayout(null);
						
						dimen = Toolkit.getDefaultToolkit().getScreenSize();
						dimen1 = fa.getSize();
						xpos = (int) (dimen.getWidth() / 2 - dimen1.getWidth() / 2);
						ypos = (int) (dimen.getHeight() / 2 - dimen1.getHeight() / 2);
						fa.setLocation(xpos, ypos);
						
						Font font30 = new Font("SansSerif", Font.BOLD, 30);
						Font font20 = new Font("SansSerif", Font.BOLD, 20);
						Font font15 = new Font("SansSerif", Font.BOLD, 15);
						Font font10 = new Font("SansSerif", Font.BOLD, 10);
						
						Label lbTitle1 = new Label("����ȭ��");
						
						Button btregi = new Button("ȸ�������ϱ�");
						Button btAllview = new Button("ȸ����Ȳ����");
						Button btEdit = new Button("ȸ�������ϱ�");
						Button btDel = new Button("ȸ�������ϱ�");
						
						fa.add(lbTitle1);
						lbTitle1.setBounds(150, 60, 300, 30);		
						lbTitle1.setFont(font30);
						
						fa.add(btregi);
						btregi.setBounds(150, 120, 150, 50);		
						btregi.setFont(font15);
						fa.add(btAllview);
						btAllview.setBounds(150, 180, 150, 50);		
						btAllview.setFont(font15);
						fa.add(btEdit);
						btEdit.setBounds(150, 240, 150, 50);		
						btEdit.setFont(font15);
						fa.add(btDel);
						btDel.setBounds(150, 300, 150, 50);		
						btDel.setFont(font15);
						
						btregi.addActionListener(new ActionListener() 
						{
							public void actionPerformed(ActionEvent e) 
							{
								regi();
							}
						});
						
						btAllview.addActionListener(new ActionListener() 
						{
							public void actionPerformed(ActionEvent e) 
							{
								Frame f = new Frame();
								f.setSize(500, 700);
								//����,���� 500,700 �������� ������â�� �����ϴ� �ڵ�
								
								f.setLayout(null);
								
								dimen = Toolkit.getDefaultToolkit().getScreenSize();
								dimen1 = f.getSize();
								xpos = (int) (dimen.getWidth() / 2 - dimen1.getWidth() / 2);
								ypos = (int) (dimen.getHeight() / 2 - dimen1.getHeight() / 2);
								f.setLocation(xpos, ypos);
								
								Font font30 = new Font("SansSerif", Font.BOLD, 30);
								Font font20 = new Font("SansSerif", Font.BOLD, 20);
								Font font15 = new Font("SansSerif", Font.BOLD, 15);
								Font font10 = new Font("SansSerif", Font.BOLD, 10);
								
								Label lbTitle2 = new Label("ȸ�� ��Ȳ");
								
								TextArea taList = new TextArea();
		
								f.add(lbTitle2);
								lbTitle2.setBounds(150, 60, 300, 30);		
								lbTitle2.setFont(font30);
								
								f.add(taList);
								taList.setBounds(80, 120, 300, 500);
								taList.setFont(font15);
								
								result="";//������ ���ΰ�ħ ȿ��
								//��񿡼� ������ �����ͼ� �ؽ�Ʈ���̸�� �ѷ��ֱ�				
								try 
								{
									//��� ������ ���� conn���� ����
									conn = DriverManager.getConnection(url, id, pass);
									//��񿡿���
									stmt = conn.createStatement();
									//��񿡼� ��ȸ�� ��� ����Ÿ�� �����ͼ� rs�� ����
									rs = stmt.executeQuery("select * from members");
									//��񿡼� ��ȸ�� ��絥��Ÿ�� ����� r�� ���� ���پ� üũ�ؼ� ���������� �ݺ�
									while (rs.next()) 
									{
										//���پ� �ݺ��ϸ鼭 result.�� �����ؼ� ����
										//getString�� ���̺��� �÷��� �������� ����Ÿ�� �����ü� ����.
										result += rs.getString("id") +"/"+ rs.getString("pw") + "/"+rs.getString("name")+"/"+ rs.getString("phone") +"/"+ rs.getString("addr") +"\n";	
									}
									//�ѹ��� ȭ�鿡 �Ѹ���
									taList.setText(result);
									rs.close();
								} 
								catch (SQLException error) 
								{
									System.err.println("error = " + error.toString());			
								}	
								
								
								f.addWindowListener(new WindowAdapter() 
								{
									public void windowClosing(WindowEvent e) 
									{
										f.setVisible(false);
									}
								});
								
								f.setVisible(true);//ȭ�鿡 ������â�� �����ִ� �ڵ�
								
							}
						});
						
						btEdit.addActionListener(new ActionListener() 
						{
							public void actionPerformed(ActionEvent e) 
							{
								Frame f = new Frame();
								f.setSize(500, 500);
								//����,���� 500,700 �������� ������â�� �����ϴ� �ڵ�
								
								f.setLayout(null);
								
								dimen = Toolkit.getDefaultToolkit().getScreenSize();
								dimen1 = f.getSize();
								xpos = (int) (dimen.getWidth() / 2 - dimen1.getWidth() / 2);
								ypos = (int) (dimen.getHeight() / 2 - dimen1.getHeight() / 2);
								f.setLocation(xpos, ypos);
								
								Font font30 = new Font("SansSerif", Font.BOLD, 30);
								Font font20 = new Font("SansSerif", Font.BOLD, 20);
								Font font15 = new Font("SansSerif", Font.BOLD, 15);
								Font font10 = new Font("SansSerif", Font.BOLD, 10);
								
								Label lbTitle3 = new Label("ȸ�������ϱ�");
								Label lbIdmodi = new Label("���̵�: ");
								Label lbNamemodi = new Label("��  ��: ");
								Label lbPhonemodi = new Label("�޴���ȭ: ");
								Label lbAddrmodi = new Label("��  ��: ");
								TextField tfIdmodi = new TextField(20);
								TextField tfNamemodi = new TextField(20);
								TextField tfPhonemodi = new TextField(20);
								TextField tfAddrmodi = new TextField(20);
								Button btmodi = new Button("�����Ϸ�");
								Button btSearch = new Button("ã ��");
								
								f.add(lbTitle3);
								lbTitle3.setBounds(150, 60, 300, 30);		
								lbTitle3.setFont(font30);
								
								f.add(lbIdmodi);
								lbIdmodi.setBounds(60, 120, 70, 30);		
								lbIdmodi.setFont(font15);
								f.add(tfIdmodi);
								tfIdmodi.setBounds(140, 120, 180, 30);		
								tfIdmodi.setFont(font15);
								f.add(btSearch);
								btSearch.setBounds(340, 120, 100, 30);		
								btSearch.setFont(font15);
								
								f.add(lbNamemodi);
								lbNamemodi.setBounds(60, 160, 70, 30);		
								lbNamemodi.setFont(font15);
								f.add(tfNamemodi);
								tfNamemodi.setBounds(140, 160, 180, 30);		
								tfNamemodi.setFont(font15);
								
								f.add(lbPhonemodi);
								lbPhonemodi.setBounds(60, 200, 70, 30);		
								lbPhonemodi.setFont(font15);
								f.add(tfPhonemodi);
								tfPhonemodi.setBounds(140, 200, 180, 30);		
								tfPhonemodi.setFont(font15);
								
								f.add(lbAddrmodi);
								lbAddrmodi.setBounds(60, 240, 70, 30);		
								lbAddrmodi.setFont(font15);
								f.add(tfAddrmodi);
								tfAddrmodi.setBounds(140, 240, 180, 30);		
								tfAddrmodi.setFont(font15);
								
								f.add(btmodi);
								btmodi.setBounds(150, 320, 150, 50);		
								btmodi.setFont(font20);
								
								btmodi.addActionListener(new ActionListener() 
								{
									public void actionPerformed(ActionEvent e) 
									{
										result="";//������ ���ΰ�ħ ȿ��
										
										String idModi = tfIdmodi.getText();
										String nameModi = tfNamemodi.getText();
										String phoneModi = tfPhonemodi.getText();
										String addrModi = tfAddrmodi.getText();
										
										String query = "update members set name = ?, phone = ?, addr = ? where id = ?";
										
										try 
										{
											PreparedStatement pstmt = conn.prepareStatement(query);	
											pstmt.setString(1,nameModi);
											pstmt.setString(2,phoneModi);
											pstmt.setString(3,addrModi);
											pstmt.setString(4,idModi);
											pstmt.executeUpdate();
											pstmt.close();
											System.err.println("ȸ�� �������� �Ϸ�!!");
										} 
										catch (SQLException ee) 
										{
											System.err.println("ȸ�� �������� ����!!");
											
										}
									}
								
							      });
								
								btSearch.addActionListener(new ActionListener() 
								{
									public void actionPerformed(ActionEvent e) 
									{
										String searchID = tfIdmodi.getText();
										
										//��񿡼� ������ �����ͼ� �ؽ�Ʈ���̸�� �ѷ��ֱ�				
										try 
										{
													//��� ������ ���� conn���� ����
											conn = DriverManager.getConnection(url, id, pass);
													//��񿡿���
											stmt = conn.createStatement();
													//��񿡼� ��ȸ�� ��� ����Ÿ�� �����ͼ� rs�� ����
											rs = stmt.executeQuery("select * from members");
													//��񿡼� ��ȸ�� ��絥��Ÿ�� ����� r�� ���� ���پ� üũ�ؼ� ���������� �ݺ�
											while (rs.next()) 
											{
												//���پ� �ݺ��ϸ鼭 result.�� �����ؼ� ����
												//getString�� ���̺��� �÷��� �������� ����Ÿ�� �����ü� ����.
												if(searchID.equals(rs.getString("id")))
												{
													tfIdmodi.setText(rs.getString("id"));
													tfNamemodi.setText(rs.getString("name"));
													tfPhonemodi.setText(rs.getString("phone"));
													tfAddrmodi.setText(rs.getString("addr"));
												}
														
											}				
													
													rs.close();
										} 
										catch (SQLException error) 
										{
											System.err.println("error = " + error.toString());			
										}	
									}
									
							      });
								
								f.addWindowListener(new WindowAdapter() 
								{
									public void windowClosing(WindowEvent e) 
									{
										f.setVisible(false);
									}
								});
								
								f.setVisible(true);//ȭ�鿡 ������â�� �����ִ� �ڵ�
								
							}
						});
						
						btDel.addActionListener(new ActionListener() 
						{
							public void actionPerformed(ActionEvent e) 
							{
								Frame f = new Frame();
								f.setSize(500, 500);
								//����,���� 500,700 �������� ������â�� �����ϴ� �ڵ�
								
								f.setLayout(null);
								
								dimen = Toolkit.getDefaultToolkit().getScreenSize();
								dimen1 = f.getSize();
								xpos = (int) (dimen.getWidth() / 2 - dimen1.getWidth() / 2);
								ypos = (int) (dimen.getHeight() / 2 - dimen1.getHeight() / 2);
								f.setLocation(xpos, ypos);
								
								Font font30 = new Font("SansSerif", Font.BOLD, 30);
								Font font20 = new Font("SansSerif", Font.BOLD, 20);
								Font font15 = new Font("SansSerif", Font.BOLD, 15);
								Font font10 = new Font("SansSerif", Font.BOLD, 10);
								
								Label lbTitle4 = new Label("ȸ�������ϱ�");
								Label delId = new Label("���̵�: ");
								Label delName = new Label("�� ��: ");
								Label delPhone = new Label("�޴���ȭ: ");
								Label delAddr = new Label("�� ��: ");
								Label delNameView = new Label("");
								Label delPhoneView = new Label("");
								Label delAddrView = new Label("");
								
								f.add(lbTitle4);
								lbTitle4.setBounds(150, 60, 300, 30);		
								lbTitle4.setFont(font30);
								
								TextField tfIddel1 = new TextField(15);
								
								f.add(delId);
								delId.setBounds(80, 120, 70, 30);		
								delId.setFont(font20);
								f.add(tfIddel1);
								tfIddel1.setBounds(180, 120, 100, 30);		
								tfIddel1.setFont(font20);
								
								f.add(delName);
								delName.setBounds(80, 160, 70, 30);		
								delName.setFont(font20);
								f.add(delNameView);
								delNameView.setBounds(180, 160, 100, 30);		
								delNameView.setFont(font20);
								
								f.add(delPhone);
								delPhone.setBounds(80, 200, 100, 30);		
								delPhone.setFont(font20);
								f.add(delPhoneView);
								delPhoneView.setBounds(200, 200, 100, 30);		
								delPhoneView.setFont(font20);
								
								f.add(delAddr);
								delAddr.setBounds(80, 240, 70, 30);		
								delAddr.setFont(font20);
								f.add(delAddrView);
								delAddrView.setBounds(180, 240, 100, 30);		
								delAddrView.setFont(font20);
								
								Button btnDel = new Button("�����ϱ�");
								Button btnDelsear = new Button("��ȸ�ϱ�");
								
								f.add(btnDel);
								btnDel.setBounds(120, 350, 100, 30);		
								btnDel.setFont(font20);
								f.add(btnDelsear);
								btnDelsear.setBounds(250, 350, 100, 30);		
								btnDelsear.setFont(font20);
								
								btnDelsear.addActionListener(new ActionListener() 
								{
									public void actionPerformed(ActionEvent e) 
									{
										String delId1 = tfIddel1.getText();
										//��񿡼� ������ �����ͼ� �ؽ�Ʈ���̸�� �ѷ��ֱ�				
										try 
										{
													//��� ������ ���� conn���� ����
											conn = DriverManager.getConnection(url, id, pass);
													//��񿡿���
											stmt = conn.createStatement();
													//��񿡼� ��ȸ�� ��� ����Ÿ�� �����ͼ� rs�� ����
											rs = stmt.executeQuery("select * from members");
													//��񿡼� ��ȸ�� ��絥��Ÿ�� ����� r�� ���� ���پ� üũ�ؼ� ���������� �ݺ�
											while (rs.next()) 
											{
												//���پ� �ݺ��ϸ鼭 result.�� �����ؼ� ����
												//getString�� ���̺��� �÷��� �������� ����Ÿ�� �����ü� ����.
												if(delId1.equals(rs.getString("id")))
												{
													delNameView.setText(rs.getString("name"));
													delPhoneView.setText(rs.getString("phone"));
													delAddrView.setText(rs.getString("addr"));
	
												}
														
											}				
													
											rs.close();
										} 
										catch (SQLException error) 
										{
											System.err.println("error = " + error.toString());			
										}	
									}
								});
								
								btnDel.addActionListener(new ActionListener() 
								{
									public void actionPerformed(ActionEvent e) 
									{
										String iddel= tfIddel1.getText();
										
										String query = "delete from members where id = ? ";
										
										try 
										{
											PreparedStatement pstmt = conn.prepareStatement(query);
											pstmt.setString(1, iddel);
											pstmt.executeUpdate();
											pstmt.close();
											System.err.println("ȸ�� ���� �Ϸ�!!");
										} 
										catch (SQLException ee) 
										{
											System.err.println("ȸ�� ���� ����!!");
											
										}
										
									}
								});
							
								f.addWindowListener(new WindowAdapter() 
								{
									public void windowClosing(WindowEvent e) 
									{
										f.setVisible(false);
									}
								});
								
								f.setVisible(true);//ȭ�鿡 ������â�� �����ִ� �ڵ�
								
							}
						});
						
						fa.addWindowListener(new WindowAdapter() 
						{
							public void windowClosing(WindowEvent e) 
							{
								fa.setVisible(false);
							}
						});
						
						fa.setVisible(true);//ȭ�鿡 ������â�� �����ִ� �ڵ�
					}
				}	
					rs.close();
				} 
				catch (SQLException error) 
				{
					System.err.println("error = " + error.toString());			
				}			
		}		
	}
}
		
	

