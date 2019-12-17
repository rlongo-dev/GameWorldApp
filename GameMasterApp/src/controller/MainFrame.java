package controller;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Item;
import model.ItemTableModel;

import java.util.ArrayList;
import java.util.List;


public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JPanel pnlMain;
	private JPanel pnlItem;
	private JTabbedPane tabbedPane;
	private JScrollPane scpItem;
	private JTable tbeItem;
	private ItemTableModel itemModel;
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("GameMasterApp");
    EntityManager em = emf.createEntityManager();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public MainFrame() {
		initComponents();
		createEvents();
	}

	private void createEvents() {
		// TODO Auto-generated method stub	
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1081, 688);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		//contentPane.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		pnlMain = new JPanel();
		tabbedPane.addTab("Main", null, pnlMain, null);
		
		pnlItem = new JPanel();
		tabbedPane.addTab("Item", null, pnlItem, null);
		
		scpItem = new JScrollPane();
		//scpItem.setBounds(new Rectangle(600, 35, 600, 800));
		pnlItem.add(scpItem);
		//some test code to fill sample data in here
	
		ArrayList<Item> arrItems = new ArrayList<Item>();
		/*
		arrItems.add(new Item(1,"sword",.2,3.5,"Big bad blade"));
		arrItems.add(new Item(2,"chainmail",.1,12.5,"cover my buns"));
		arrItems.add(new Item(3,"long bow",.033333,5.5,"right in your eye"));
		arrItems.add(new Item(4,"swizzle stick",.0001444,10000000.5,"most magical ever"));
		*/
		arrItems = getItemData();
		itemModel = new ItemTableModel(arrItems);
		tbeItem = new JTable(itemModel);
		//tbeItem.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tbeItem.getColumnModel().getColumn(0).setPreferredWidth(27);
		tbeItem.getColumnModel().getColumn(1).setPreferredWidth(50);
		tbeItem.getColumnModel().getColumn(2).setPreferredWidth(30);
		tbeItem.getColumnModel().getColumn(3).setPreferredWidth(30);
		tbeItem.getColumnModel().getColumn(4).setPreferredWidth(100);

		scpItem.setViewportView(tbeItem);

        em.close();
        emf.close();

	}
	
	private ArrayList<Item> getItemData(){
		em.getTransaction().begin();
		

		ArrayList<Item> alItems = new ArrayList<Item>();
		
		alItems.addAll(em.createNamedQuery("Item.findAll").getResultList());
         
		//alItems.add(em.find(Item.class, 1));
		//alItems.add(em.find(Item.class, 2));
		//alItems.add(em.find(Item.class, 3));
		
		return alItems;
		
	}
}
